package com.shengpay.autorepayment.service;

import java.io.File;
import java.util.List;

import javax.xml.ws.WebServiceException;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.ext.dataobject.TbWithholdingInfoDTO;
import com.shengpay.model.fileManager.UploadFileResponse;

/**
 * 提供功能，验证  解析，上传小文件，上传FTP
 * @author liutao
 *
 */
public interface WithholdFileService {
	/**
	 * 验证文件
	 * @return
	 * @throws Exception
	 */
	public TbWithholdingInfoDTO checkFile(List<String[]> list, String fileType)throws Exception;
	/**
	 * 上传文件到FTP
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public ErrorMessageVO uploadFileToFTP(String brechNo)throws Exception;
	/**
	 * 解析文件
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public List<String[]> readerFileData(File file)throws Exception;
	public List<String[]> readerFileData(String fileName)throws Exception;
	/**
	 * 上传文件到小文件
	 * @param storeUrl
	 * @param bytes
	 * @return
	 */
	public UploadFileResponse uploadFileTOStore(String fileName);
	public UploadFileResponse uploadFileTOStore(File file);
	/**
	 * 调用接口
	 * @param brechNo
	 * @return
	 * @throws Exception
	 * @throws WebServiceException
	 */
	public void apply(TbWithholdingOrderInfoPO orderPo) throws WebServiceException, Exception;

	/**
	 * job
	 * @throws Exception
	 */
	public void run()throws Exception;
	/**
	 * job 委托扣款交易订单状态查询
	 * @throws Exception
	 */
	public void transStautsQueryExecute();
	/**
	 * 检查钱包代扣数据
	 * @param list
	 * @return
	 * @throws Exception
	 */
	TbWithholdingInfoDTO checkWalletFile(List<String[]> list) throws Exception;
	/**
	 * 钱包代扣
	 * @param orderPo
	 * @throws WebServiceException
	 * @throws Exception
	 */
	public void walletWithholdApply(TbWithholdingOrderInfoPO orderPo) throws WebServiceException, Exception;
	/**
	 * 更新批次状态为完成状态
	 * @param brechNo
	 * @throws Exception
	 */
	public void updateBatchInfoToSucess(String brechNo) throws Exception;

}
