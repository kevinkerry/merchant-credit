package com.sdp.mc.intra.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.enums.CompareSymbolEnums;
import com.sdp.mc.common.enums.CompareTypeEnums;
import com.sdp.mc.common.enums.ComputeSymbolEnums;
import com.sdp.mc.common.enums.ConditionSymbolEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.ParseCsvFileUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.intra.web.util.ParseXlsFileUtil;
import com.sdp.mc.intra.worker.limitrule.LimitRuleTrialHandler;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;
import com.sdp.mc.service.limitrule.LimitRuleInfoService;
import com.shengpay.commom.config.GlobalConfig;

/**
 * 商户快速结算额度规则管理的Action
 *
 * @author liyantao01
 *
 */
@Controller
@RequestMapping("/limitrule")
public class LimitRuleInfoAction {
	private static Logger log = LoggerFactory.getLogger(LimitRuleInfoAction.class);
	@Autowired
	private LimitRuleInfoService limitRuleInfoService;

	//额度试算的线程控制服务
	@Autowired
	private LimitRuleTrialHandler limitRuleTrialHandler;

	//额度规则列表
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		log.info("LimitRuleInfoAction.index.start.queryParam");
		List<Newt0LimitRuleInfoDO> dataList = null;
		try {
			//查询列表数据
			dataList = limitRuleInfoService.queryLimitRuleInfo();
			if(dataList!=null){
				for(Newt0LimitRuleInfoDO objDo:dataList){
					String lambdaDesc=objDo.getLambdaDesc();
					if(StringUtils.isNotBlank(lambdaDesc)){
						//将规则描述中的换行换成html识别的换行
						objDo.setLambdaDesc(lambdaDesc.replaceAll("\n", "<br/>"));
					}

				}
			}
			model.put("dataList", dataList);
		} catch (Exception e) {
			log.error("LimitRuleInfoAction.index.error", e);
			dataList = new ArrayList<Newt0LimitRuleInfoDO>();
			model.put("dataList", dataList);
		}
		return "/limitrule/index";
	}

	/**
	 * 规则编辑页面
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		log.info("LimitRuleInfoAction.edit.start.queryParam");
		String id = request.getParameter("id");
		try {
			if (StringUtils.isNotBlank(id)) {
				//根据规则ID查询规则信息
				Newt0LimitRuleInfoDO limitRuleInfo = limitRuleInfoService.getLimitRuleInfoById(id);
				if (limitRuleInfo != null) {
					model.put("entity", limitRuleInfo);
				}
			}
			//设置规则的使用的时间范围
			model.put("startTime", DateUtil.getBeginTimeOfMonth(-1));
			model.put("endTime", DateUtil.getEndTimeOfMonth(-1));
		} catch (Exception e) {
			log.error("LimitRuleInfoAction.edit.error", e);
		}
		return "/limitrule/editRule";
	}
	/**
	 * 更新状态
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateStatus")
	@ResponseBody
	public ErrorMessageVO<Object> updateStatus(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
		log.info("LimitRuleInfoAction.updateStatus.start.queryParam");
		String id = request.getParameter("id");
		String statusStr=request.getParameter("status");
		int status=1;
		if(StringUtils.isNotBlank(statusStr)&&StringUtils.isNumeric(statusStr)){
		    status=Integer.valueOf(statusStr);
		}
		String updateType=status==1?"启用":"禁用";
		try {
			if (StringUtils.isNotBlank(id)) {
				Newt0LimitRuleInfoDO limitRuleInfo = limitRuleInfoService.getLimitRuleInfoById(id);
				if (limitRuleInfo != null) {
					limitRuleInfo.setStatus(status);
					limitRuleInfoService.updateByPrimaryKeySelective(limitRuleInfo);
				}
			}
			error.setSuccess(true);
			error.setErrorCode("0");
			error.setErrorMessage(updateType+"成功");
		} catch (Exception e) {
			error.setSuccess(true);
			error.setErrorCode("-1");
			error.setErrorMessage(updateType+"失败");
			log.error("LimitRuleInfoAction.updateStatus.error", e);
		}
		return error;
	}

	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public void saveEdit(Newt0LimitRuleInfoDO entity, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
		boolean bValid = false;
		if (entity.getId() != null) {
			String ruleLambda=entity.getRuleLambda();
			try {
				if(ruleLambda.indexOf("=")>0){
					ruleLambda=ruleLambda.split("=")[1];
				}
				ruleLambda=URLDecoder.decode(ruleLambda, "utf8");
				String lambdaDesc=getLambdaDescByRuleLambda(ruleLambda);

				Newt0LimitRuleInfoDO limitRuleInfo = limitRuleInfoService.getLimitRuleInfoById(entity.getId()+"");
				if (limitRuleInfo != null) {
					limitRuleInfo.setStatus(entity.getStatus());
					limitRuleInfo.setUpdateDate(new Date());
					limitRuleInfo.setRuleLambda(ruleLambda);
					limitRuleInfo.setLambdaDesc(lambdaDesc);
					int rows =limitRuleInfoService.updateByPrimaryKeySelective(limitRuleInfo);
					bValid = rows == 1;
				}
			} catch (Exception e) {
				bValid=false;
				log.error("save limit rule error ",e);
			}
		} else {
			error.setSuccess(true);
			error.setErrorCode("-1");
			error.setErrorMessage("保存失败,主键不存在！");
		}
		if (bValid) {
			error.setSuccess(true);
			error.setErrorCode("0");
			error.setErrorMessage("保存成功");
		} else {
			error.setSuccess(true);
			error.setErrorCode("-1");
			error.setErrorMessage("保存失败");
		}
        outJson(error,response);
//		return error;
	}

	private void outJson(ErrorMessageVO<Object> error,HttpServletResponse response) {
		   try {
			    response.setContentType("text/javascript;charset=UTF-8");
		        response.setHeader("Cache-Control", "no-store, max-age=0, no-cache, must-revalidate");
		        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		        response.setHeader("Pragma", "no-cache");
	        	JSONObject obj=JSONObject.fromObject(error);
	            PrintWriter out = response.getWriter();
	            out.write(obj.toString());
	            out.close();
	        } catch (IOException e) {
	        	log.error("out put  response error",e);
	        }

	}
    /**
     * 通过规则表达式获取规则的表述
     * @param ruleLambda 规则表达式
     * @return
     */
	private String getLambdaDescByRuleLambda(String ruleLambda) {
		StringBuffer buff =new StringBuffer();
		try {
			if(StringUtils.isNotBlank(ruleLambda)){
				JSONArray jsonArray=JSONArray.fromObject(ruleLambda);
				int ruleSize=jsonArray.size();
			    for (Object object : jsonArray) {
				  JSONObject jsonObj = JSONObject.fromObject(object);
				  //活跃天数的判断条件
				  String activeJudgeSymbol=jsonObj.getString("activeJudgeSymbol");
				  //活跃天数的比较值
				  String activeDayNum=jsonObj.getString("activeDayNum");
				  if(StringUtils.isNotBlank(activeJudgeSymbol)
						  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(activeJudgeSymbol)
						  &&StringUtils.isNotBlank(activeDayNum)){
					  buff.append("(活跃天数");
					  buff.append(CompareSymbolEnums.getByCode(activeJudgeSymbol).getLabel());
					  buff.append(activeDayNum+"天)");
				  }
				  //多重条件判断符号  and  or
				  String conditionJudgeSymbol=jsonObj.getString("conditionJudgeSymbol");
				  //日均范围较大值的数值
				  String dailyMaxValue=jsonObj.getString("dailyMaxValue");
				  //日均范围较小值的数值
				  String dailyMinValue=jsonObj.getString("dailyMinValue");
				  //日均范围较大值的判断符
				  String dailyMaxSymbol=jsonObj.getString("dailyMaxSymbol");
				  //日均范围较小值的判断符
				  String dailyMinSymbol=jsonObj.getString("dailyMinSymbol");
				  if(StringUtils.isNotBlank(conditionJudgeSymbol)&&!ConditionSymbolEnums.ConditionSymbolEmpty.getCode().equals(conditionJudgeSymbol)
						  &&(StringUtils.isNotBlank(dailyMaxValue)||StringUtils.isNotBlank(dailyMinValue))
						  ){
					  buff.append(ConditionSymbolEnums.getByCode(conditionJudgeSymbol).getLabel());
					  String dailyMinString="";
					  String dailyMaxString="";
					  if(StringUtils.isNotBlank(dailyMaxValue)&&StringUtils.isNotBlank(dailyMaxSymbol)
							  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(dailyMaxSymbol)){
						  dailyMaxString=CompareSymbolEnums.getByCode(dailyMaxSymbol).getLabel()+dailyMaxValue;
						  if(StringUtils.isNotBlank(dailyMinValue)&&StringUtils.isNotBlank(dailyMinSymbol)
								  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(dailyMinSymbol)){
						      dailyMinString=dailyMinValue+CompareSymbolEnums.getByCode(dailyMinSymbol).getLabel();
						  }
						  buff.append("("+dailyMinString+"日均交易额"+dailyMaxString+")");
					  }else{
						  dailyMinSymbol=dailyMinSymbol.replace("lt", "gt");
						  dailyMinString=CompareSymbolEnums.getByCode(dailyMinSymbol).getLabel()+dailyMinValue;
						  buff.append("(日均交易额"+dailyMinString+")");
					  }

				  }
				  //计算类型  min max  eq
				  String compareType=jsonObj.getString("compareType");
				  if(ruleSize==1&&CompareTypeEnums.CompareTypeEq.getCode().equals(compareType)&&CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(activeJudgeSymbol)){
					  return jsonObj.getString("fixedValue");
				  }
				  if(StringUtils.isNotBlank(compareType)){
					  String dailyMultiple=jsonObj.getString("dailyMultiple");
					  String totalPercent=jsonObj.getString("totalPercent");
					  String fixedValue=jsonObj.getString("fixedValue");
					  buff.append(", 快速结算额度=");
					  if(CompareTypeEnums.CompareTypeEq.getCode().equals(compareType)){//固定值
						  buff.append(fixedValue);
					  }else{
						  String dailyComputeSymbol=jsonObj.getString("dailyComputeSymbol");
						  String totalComputeSymbol=jsonObj.getString("totalComputeSymbol");
						  buff.append(CompareTypeEnums.getByCode(compareType).getLabel()+"(");
						  buff.append("日均交易额"+ComputeSymbolEnums.getByCode(dailyComputeSymbol).getLabel()+dailyMultiple);
						  buff.append(",总额"+ComputeSymbolEnums.getByCode(totalComputeSymbol).getLabel()+totalPercent+")");
					  }
					  buff.append("\n");
				  }
				}
			}
		} catch (Exception e) {
			log.error("switch limit rule error,ruleLambda:"+ruleLambda,e);
		}
		log.info("规则描述"+buff.toString());
		return buff.toString();
	}

	/**
	 * 试算初始页面
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/trialInit")
	public String trialInit(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		log.info("LimitRuleInfoAction.trialInit.start.queryParam");
		String id = request.getParameter("id");
		try {
			if (StringUtils.isNotBlank(id)) {
				Newt0LimitRuleInfoDO limitRuleInfo = limitRuleInfoService.getLimitRuleInfoById(id);
				if (limitRuleInfo != null) {
					model.put("entity", limitRuleInfo);
				}
				//一个试算规则暂时只保留一个试算结果的值
				String key=LimitRuleInfoConstant.LIMIT_RULE_TRIAL_KEY_PREFIX+id;
				//查看是否有上一次的试算结果
				if(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key)!=null
						&& !"1".equals(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key))){
					model.put("reultFileName", LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key));
				}
			}
		} catch (Exception e) {
			log.error("LimitRuleInfoAction.trialInit.error", e);
		}
		return "/limitrule/trial";
	}
	/**
	 * 试算开始
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/trial")
	@ResponseBody
	public void  trial(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(true);
		error.setErrorMessage("试算中,请稍后...");
		log.info("LimitRuleInfoAction.trial.start");
		String id = request.getParameter("id");
		try {
			if (StringUtils.isNotBlank(id)) {
				Newt0LimitRuleInfoDO limitRuleInfo = limitRuleInfoService.getLimitRuleInfoById(id);
				if (limitRuleInfo != null) {
					model.put("entity", limitRuleInfo);
				}
				String trialFilePath=(String) request.getSession().getAttribute(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_KEY_PREFIX+id);
				if(trialFilePath!=null){
					File file=new File(trialFilePath);
					if(file.exists()){
						String type =file.getName().substring(file.getName().lastIndexOf(".")+1);
						// 解析
						List<String[]> merchantNoList = null;
						if("csv".equals(type.toLowerCase())){
							merchantNoList=ParseCsvFileUtil.readCsvFile(file, "GBK");
						}else if("xls".equals(type.toLowerCase())){
							merchantNoList=ParseXlsFileUtil.readXlsFile(file, "GBK");
						}
						//启用试算线程
						limitRuleTrialHandler.execute(file.getName(), merchantNoList, id);
					}

				}
			}
		} catch (Exception e) {
			log.error("LimitRuleInfoAction.trial.error", e);
		}
//		return error;
		 outJson(error,response);
	}
	/**
	 * 试算异步访问，查看试算结果
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxTrialResult")
//	@ResponseBody
	public void ajaxTrialResult(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(true);
		log.info("LimitRuleInfoAction.ajaxTrialResult.start.queryParam");
		String id = request.getParameter("id");
		try {
			if (StringUtils.isNotBlank(id)) {
				String key=LimitRuleInfoConstant.LIMIT_RULE_TRIAL_KEY_PREFIX+id;
				//判断规则试算是否结束
				if(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key)!=null
						&& !"1".equals(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key))){
					error.setErrorCode("1");
					Map<String ,Object> params=new HashMap<String, Object>();
					params.put("reultFileName", LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key));
					error.setParams(params);
				}else{
					error.setErrorMessage("试算中,请稍后...");
				}

			}
		} catch (Exception e) {
			log.error("LimitRuleInfoAction.ajaxTrialResult.error", e);
		}

//		return error;
		 outJson(error,response);
	}

	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload")
	public String init(
			@RequestParam(value = "file", required = false) MultipartFile mfile,
		DefaultMultipartHttpServletRequest request,
		HttpServletResponse response, ModelMap model) throws IOException {
	ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
	String id = request.getParameter("id");
	error.setErrorCode("1");
	try {
		if (mfile == null) {
			error.setErrorMessage("上传文件不能为空!");
			model.put("msg", error);
			return "/limitrule/uploadResult";
		}
		String type = mfile.getOriginalFilename().substring(
				mfile.getOriginalFilename().lastIndexOf(".") + 1);
		if (StringUtils.isBlank(type)) {
			error.setErrorMessage("请选择文件!");
			model.put("msg", error);
			return "/limitrule/uploadResult";
		}

		if (!("csv".equals(type.toLowerCase())||"xls".equals(type.toLowerCase()))) {
			error.setErrorMessage("您上传文件格式不正确!请上传csv或者xls文件");
			model.put("msg", error);
			return "/limitrule/uploadResult";
		}
		// 解析文件
		log.info("LimitRuleInfoAction.upload.readerFileData.start.fileName="
				+ mfile.getOriginalFilename());
		String filePath=GlobalConfig.getString(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_FILE_PATH);
		File filePathDir=new File(filePath);
		if(!filePathDir.exists()){
			filePathDir.mkdirs();
		}
		String fileName=mfile.getOriginalFilename();
		File trialFile =new File(filePath,fileName);
		FileUtils.copyInputStreamToFile(mfile.getInputStream(), trialFile);
		// 解析
		log.info("LimitRuleInfoAction.upload.readerFileData.end.fileName="+ mfile.getOriginalFilename());
		request.getSession().setAttribute(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_KEY_PREFIX+id, trialFile.getAbsolutePath());
	} catch (Exception e) {
		log.error("LimitRuleInfoAction.upload.uploadFileResponse.addFileInfo", e);
		error.setErrorMessage("上传文件发生异常！");
	}
	model.put("msg", error);
	return "/limitrule/uploadResult";

	}

	/**
	 * 下载试算结果
	 * @param request
	 * @param response
	 * @param modelMap
	 * @throws Exception
	 */
	@RequestMapping("/download")
	public void download(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		String id = request.getParameter("id");
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			String key=LimitRuleInfoConstant.LIMIT_RULE_TRIAL_KEY_PREFIX+id;
			String fileName=LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.get(key);
			//文件存放目录
			String filePath=GlobalConfig.getString(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_FILE_PATH);
			File file=new File(filePath,fileName);
			String contentType = request.getContentType();
			response.reset();
			response.setHeader("Expires", "0");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Cache-Control", "public");

			response.setContentType(contentType);
			if (StringUtils.isNotEmpty(contentType)
					&& contentType.indexOf("image") >= 0) {
				response.addHeader("Content-Disposition", contentType
						+ "; filename=" + URLEncoder.encode(fileName, "UTF8"));
			} else {
				response.addHeader("Content-Disposition", "attachment"
						+ "; filename=" + URLEncoder.encode(fileName, "UTF8"));
			}
				output = new BufferedOutputStream(response.getOutputStream());
				input = new BufferedInputStream(new FileInputStream(file));
				int n;
				// 遍历，开始下载
				while ((n = input.read(buffer, 0, 4096)) > -1) {
					output.write(buffer, 0, n);
				}
				output.flush(); // 不可少
				response.flushBuffer();// 不可少
				//清理之前的试算结果
				request.getSession().removeAttribute(key);
				LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.remove(key);
			} catch (Exception e) {
				log.error("NewT0IntraAction.download error", e);
			} finally {
				// 关闭流，不可少
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			}
	}

	/**
	 * 下载试算的模板
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloadTemplet")
	public void downloadTemplet(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
//		File file = new File(request.getSession().getServletContext().getRealPath("/")+ "/template/limittrialTemplate.csv"); // 根据文件路径获得File文件
		File file = new File(request.getSession().getServletContext().getRealPath("/")+ "/template/limittrialTemplate.xls"); // 根据文件路径获得File文件
		response.setContentType("application/msexcel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ URLEncoder.encode("limittrialTemplate.xls", "UTF-8"));
		response.setContentLength((int) file.length());
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int n;
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // 不可少
			response.flushBuffer();// 不可少
		} catch (Exception e) {
			log.error("NewT0IntraAction.download error", e);
		} finally {
			// 关闭流，不可少
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}

}
