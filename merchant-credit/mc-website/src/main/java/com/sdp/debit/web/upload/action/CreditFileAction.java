package com.sdp.debit.web.upload.action;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.web.action.BaseAction;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.model.fileManager.DeleteFileResponse;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.model.fileManager.UploadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;

@RequestMapping(value = { "/posMerchant/file", "/mposMerchant/file","/posPromoter/file", "/mposPromoter/file" })
@Controller
public class CreditFileAction extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(CreditFileAction.class);

	/**
	 * 文件管理服务s
	 */
	@Autowired
	private FileManagerService fileManagerService;
	/**
	 * 商户信用额度申请
	 */
	@Autowired
	protected MerchantCreditLinesApplyService merchantCreditLinesApplyService;
	
	@Value("${easypay.file.store.url}")
	private String easypayFileStoreUrl;

	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = { "/upload" })
	public void init(DefaultMultipartHttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		log.info("CreditFileAction-->upload-->init  request="+request);
		UploadFileResponse uploadFileResponse = fileManagerService.uploadFile(
				request, "uploadfield");
		log.info("CreditFileAction-->upload-->init  uploadFileResponse="+uploadFileResponse);
		String agent=request.getHeader("User-Agent").toLowerCase();
		String agentType=getBrowserName(agent);
		writeJson(response, uploadFileResponse,agentType);

	}
	/**
	 * 云收银文件上传
	 */
	@RequestMapping(value = { "/easypayUpload"})
	public void easyUpload(DefaultMultipartHttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		log.info("CreditFileAction-->upload-->init  request="+request);
		UploadFileResponse uploadFileResponse = fileManagerService.uploadFile(
				request, easypayFileStoreUrl, "uploadfield");
		log.info("CreditFileAction-->upload-->init  uploadFileResponse="+uploadFileResponse);
		String agent=request.getHeader("User-Agent").toLowerCase();
		String agentType=getBrowserName(agent);
		writeJson(response, uploadFileResponse,agentType);
		
	}

	@RequestMapping("/delete.htm")
	public void delete(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String key = request.getParameter("key");
		String kind = request.getParameter("kind");
		String code = request.getParameter("code");
		DeleteFileResponse deleteFileResponse = fileManagerService
				.delteFile(key);
		String agent=request.getHeader("User-Agent").toLowerCase();
		String agentType=getBrowserName(agent);
		/**
		 * 删除本地的附件记录
		 */
		deleteFileLog(request,kind,code);
		writeJson(response, deleteFileResponse,agentType);
	}

	@RequestMapping("/newDelete.htm")
	public void newDelete(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String key = request.getParameter("storeKey");
		String kind = request.getParameter("kind");
		String code = request.getParameter("code");
		DeleteFileResponse deleteFileResponse = fileManagerService
				.delteFile(key);
		String agent=request.getHeader("User-Agent").toLowerCase();
		String agentType=getBrowserName(agent);
		/**
		 * 删除本地的附件记录
		 */
		deleteFileLog(request,kind,code);
		writeJson(response, deleteFileResponse,agentType);
	}
	@RequestMapping("/easypayDelete.htm")
	public void easypayDelete(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String key = request.getParameter("storeKey");
		String kind = request.getParameter("kind");
		String code = request.getParameter("code");
		DeleteFileResponse deleteFileResponse = fileManagerService
				.delteFile(key, easypayFileStoreUrl);
		String agent=request.getHeader("User-Agent").toLowerCase();
		String agentType=getBrowserName(agent);
		/**
		 * 删除本地的附件记录
		 */
		deleteFileLog(request,kind,code);
		writeJson(response, deleteFileResponse,agentType);
	}

	/**
	 * 删除附件时同时删除本地记录
	 * 通过申请额度时生成的ID 商户号   inputKind  inputCode
	 * @param request
	 */
	private void deleteFileLog(HttpServletRequest request,String kind,String code){
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession()); // 默认通过filter都存在merchant
		String merchantNo = user.getMerchantNo();
		List<DoMeCreditLinesApplyInfoPO> list=null;
		// 查询最近一次申购
		DoMerchantCreditLinesApplyPO applyPO = merchantCreditLinesApplyService.getLatestCreditLines(merchantNo);
		//查询出需要更新数据记录的ID
		if(null!=applyPO){
			Map<String,Object> mps=new HashMap<String, Object>();
			mps.put("lineApplyOrderId", String.valueOf(applyPO.getId()));
			mps.put("merchantNo", merchantNo);
			if(null!=kind&&!"".equals(kind)&&null!=code&&!"".equals(code)){
				mps.put("inputKind", kind.replaceAll("_", " "));
				mps.put("inputCode", code);
			}

		    list=merchantCreditLinesApplyService.getCreditLinesApplyInfo(mps);

		    if(null!=list&&!list.isEmpty()){
		    	//更新ID记录
		    	merchantCreditLinesApplyService.updateCreditLinesApplyInfoByID(list.get(0).getId());
		    }
		}


	}
	@RequestMapping("/download.htm")
	public void download(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		String key = request.getParameter("key");
		String fileName = request.getParameter("fileName");
		String contentType = request.getParameter("contentType");
		OutputStream os = null;
		try {
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
				response.setHeader( "Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );
			} else {
				response.addHeader("Content-Disposition", "attachment"
						+ "; filename=" + URLEncoder.encode(fileName, "UTF8"));
				response.setHeader( "Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );
			}

			response.setBufferSize(1024);

			DownloadFileResponse downloadFileResponse = fileManagerService
					.downLoadFile(key);
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			log.error("CreditFileAction.download.error", e);
		} finally {
			if(os!=null){
				os.flush();
				os.close();
				os = null;
			}
		}
	}

	@RequestMapping("/newDownload.htm")
	public void newDownload(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		String key = request.getParameter("storeKey");
		String fileName = request.getParameter("oriFileName");
		String contentType = request.getParameter("contentType");
		OutputStream os = null;
		try {
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
			response.setBufferSize(1024);

			DownloadFileResponse downloadFileResponse = fileManagerService
					.downLoadFile(key);
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);

		} catch (Exception e) {
			log.error("CreditFileAction.newDownload.error", e);
		} finally {
			if(os!=null){
				os.flush();
				os.close();
				os = null;
			}

		}
	}
	
	@RequestMapping("/easypayDownload.htm")
	public void easypayDownload(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		String key = request.getParameter("storeKey");
		log.info("easypayDownload -------------- key:"+key);
		try {
			response.setHeader("Content-Type", "image/jpeg");
			
			DownloadFileResponse downloadFileResponse = fileManagerService
					.downLoadFile(key, easypayFileStoreUrl);
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			
		} catch (Exception e) {
			log.error("CreditFileAction.easypayDownload.error----下载小文件失败 {}", e.getMessage());
		} finally {
			if(response.getOutputStream()!=null){
				response.getOutputStream().close();
			}
			
		}
	}

}
