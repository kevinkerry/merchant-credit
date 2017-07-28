package com.shengpay.debit.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import com.shengpay.debit.common.risk.model.CreditRiskTypes;
import com.shengpay.debit.common.risk.model.CreditRiskTypesItems;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;
import com.shengpay.debit.common.risk.model.InputTypeEnum;
import com.shengpay.debit.common.risk.model.ScoreType4Submit;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.service.fileManager.FileManagerService;

public class CreditLinesApplyServiceUtil {

	public static List<ScoreType4Submit> buildScoreType4SubmitList(Map<String, DoMeCreditLinesApplyInfoPO> policyTypes, GetCreditRiskResponseModel creditModel) {
		List<ScoreType4Submit> scoreType4SubmitList = new ArrayList<ScoreType4Submit>();
		for (CreditRiskTypes creditRiskType : creditModel.getTypes()) {
			ScoreType4Submit scoreType4Submit = new ScoreType4Submit();
			for (CreditRiskTypesItems creditRiskTypesItem : creditRiskType.getItems()) {
				// 获取落地的输入项
				String key = creditRiskType.getCode() + "_" + creditRiskTypesItem.getCode();
				DoMeCreditLinesApplyInfoPO inputItem = policyTypes.get(key);

				ScoreType4Submit.Item item = null;
				// 取出附件url
				String url = null;
				if (StringUtils.isNotBlank(inputItem.getExtInfo())) {
					url = JSONObject.fromObject(inputItem.getExtInfo()).getString(InputTypeEnum.ATTACHMENT.code);
				}
				// 如果是附件
				if (InputTypeEnum.ATTACHMENT.code.equals(creditRiskTypesItem.getCode())) {
					// 校验是否是必填项
					if (Boolean.TRUE.toString().equals(creditRiskTypesItem.getIsNeed())) {
						if (url == null) {
							throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
						}
					}
					// 附件地址不为空才传入此参数
					if (url != null) {
						item = new ScoreType4Submit.ItemAttachment(inputItem.getInputCode(), url);
					}

				} else if (InputTypeEnum.ENUM_ATTACHMENT.code.equals(creditRiskTypesItem.getCode())) {
					// 如果是枚举+附件
					if (Boolean.TRUE.toString().equals(creditRiskTypesItem.getIsNeed())) {
						if (url == null || StringUtils.isBlank(inputItem.getInputValue())) {
							throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
						}
					}
					if (url != null && StringUtils.isNotBlank(inputItem.getInputValue())) {
						item = new ScoreType4Submit.Item4Submit(inputItem.getInputCode(), inputItem.getInputValue(), url);
					}
				} else if (InputTypeEnum.TEXT.code.equals(creditRiskTypesItem.getCode()) || InputTypeEnum.ENUM.code.equals(creditRiskTypesItem.getCode())) {
					// 文本、枚举等情况
					if (Boolean.TRUE.toString().equals(creditRiskTypesItem.getIsNeed()) && StringUtils.isBlank(inputItem.getInputValue())) {
						throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
					}
					item = new ScoreType4Submit.ItemValue(inputItem.getInputCode(), inputItem.getInputValue());
				} else {
					throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
				}
				// 把输入项添加到数组
				if (item != null) {
					scoreType4Submit.add(item);
				}
			}
			scoreType4SubmitList.add(scoreType4Submit);
		}
		return scoreType4SubmitList;
	}
	/**
	 * 对方法进行重写 等金高回来看是否需要合并
	 * @param policyTypes
	 * @param creditModel
	 * @return
	 * liutao
	 */
	public static List<ScoreType4Submit> buildScoreType4SubmitListA(Map<String, DoMeCreditLinesApplyInfoPO> policyTypes, GetCreditRiskResponseModel creditModel,FileManagerService fileService) {
		List<ScoreType4Submit> scoreType4SubmitList = new ArrayList<ScoreType4Submit>();
		for (CreditRiskTypes creditRiskType : creditModel.getTypes()) {
			ScoreType4Submit scoreType4Submit = new ScoreType4Submit();
			/**
			 * 这里需要传入code
			 * 如果需要提交代码，需要评审
			 */
			scoreType4Submit.setCode(creditRiskType.getCode()==null?"":creditRiskType.getCode().replaceAll("_", " "));
			for (CreditRiskTypesItems creditRiskTypesItem : creditRiskType.getItems()) {
				// 获取落地的输入项
				String key = creditRiskType.getCode() + "_" + creditRiskTypesItem.getCode();
				/**
				 * 这里需要对key做转换，去掉包含的所有“_”
				 */
				key=creditRiskType.getCode().replaceAll("_", " ")+"_" + creditRiskTypesItem.getCode();
				DoMeCreditLinesApplyInfoPO inputItem = policyTypes.get(key);

				ScoreType4Submit.Item item = null;
				// 取出附件url
				String url = null;
				/**
				 * 这里何毅说要改
				 * 注掉的为原有代码，如果需要提交
				 */
				if (StringUtils.isNotBlank(inputItem.getExtInfo())) {
				    url=fileService.getManagerDownloadUrl(inputItem.getExtInfo());
//					url = JSONObject.fromObject(inputItem.getExtInfo()).getString(InputTypeEnum.ATTACHMENT.code);
				}
				/**
				 * 下面这部分有问题，不应该用creditRiskTypesItem.getCode() 应该用creditRiskTypesItem.getInputType() 来做比较
				 */
				// 如果是附件
				if (InputTypeEnum.ATTACHMENT.code.equals(creditRiskTypesItem.getInputType())) {
					// 校验是否是必填项
					if (Boolean.TRUE.toString().equals(creditRiskTypesItem.getIsNeed())) {
						if (url == null) {
							throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
						}
					}
					// 附件地址不为空才传入此参数
					if (url != null) {
						item = new ScoreType4Submit.ItemAttachment(inputItem.getInputCode(), url);
					}

				} else if (InputTypeEnum.ENUM_ATTACHMENT.code.equals(creditRiskTypesItem.getInputType())) {
					// 如果是枚举+附件
					if (Boolean.TRUE.toString().equals(creditRiskTypesItem.getIsNeed())) {
						if (!"none".equals(inputItem.getInputValue()) && (url == null || StringUtils.isBlank(inputItem.getInputValue()))) {
							throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
						}
					}
					if (StringUtils.isNotBlank(inputItem.getInputValue())) {
						item = new ScoreType4Submit.Item4Submit(inputItem.getInputCode(), inputItem.getInputValue(), url);
					}
				} else if (InputTypeEnum.TEXT.code.equals(creditRiskTypesItem.getInputType()) || InputTypeEnum.ENUM.code.equals(creditRiskTypesItem.getInputType())) {
					// 文本、枚举等情况
					if (Boolean.TRUE.toString().equals(creditRiskTypesItem.getIsNeed()) && StringUtils.isBlank(inputItem.getInputValue())) {
						throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
					}
					item = new ScoreType4Submit.ItemValue(inputItem.getInputCode(), inputItem.getInputValue());
				} else {
					throw new RuntimeException(creditRiskTypesItem.getDesc() + "是必填项");
				}
				// 把输入项添加到数组
				if (item != null) {
					scoreType4Submit.add(item);
				}
			}
			scoreType4SubmitList.add(scoreType4Submit);
		}
		return scoreType4SubmitList;
	}
}
