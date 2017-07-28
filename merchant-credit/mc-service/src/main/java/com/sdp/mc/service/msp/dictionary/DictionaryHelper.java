package com.sdp.mc.service.msp.dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdp.mc.dao.readonly.dictionary.DictionaryEO;

/**
 * 字典帮助
 * @author liuxi.xiliu
 */
public class DictionaryHelper {
    /**
     * 所有字典
     * Key : 分类码
     * Value : Map，字典项键值对
     */
    private static Map<String, Map<String, String>> ALL_DICTIONARY_KV_MAP;

    /**
     * 所有字典
     * Key : 分类码
     * Value : List，按sort排序的该分类的字典项
     */
    private static Map<String, List<DictionaryRO>> ALL_DICTIONARY_LIST_MAP;

    /**
     * 根据分类码，建，取值
     */
    public static String getValue(String label, String key) {
        Map<String, String> map = ALL_DICTIONARY_KV_MAP.get(label);
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    /**
     * 根据分类码，建，取值
     */
    public static String getValue(String label, Boolean key) {
    	String keyStr = key == null? "0" : ( key? "1" : "0" ); 
        return getValue(label, keyStr);
    }

    /**
     * 根据分类码，建，取值
     */
    public static Integer getInt(String label, String key) {
        String v = getValue( label, key );
        return v == null? null : Integer.parseInt( v );
    }
    
    /**
     * 根据分类码取得所有字典项(排序的)
     */
    public static List<DictionaryRO> getDictionaryList(String label) {
        List<DictionaryRO> list = ALL_DICTIONARY_LIST_MAP.get(label);
        return list == null ? new ArrayList<DictionaryRO>() : list;
    }

	/**
	 * 将list中的值逐个取出作为字典的key，取得value，将所有value按指定的字符串连接起来
	 * @param label
	 * @param keyList
	 * @param ps : 连接value时再前后加上的字符串
	 * @param joiner : 连接字符串
	 */
    public static String getJoinedValueOfList( String label, List<String> keyList, String ps, String joiner ) {
    	StringBuffer strb = new StringBuffer();
    	for( int i = 0; i < keyList.size(); i ++ ){
    		String v = getValue( label, String.valueOf( keyList.get( i ) ) );
    		strb.append( ps ).append( v ).append( ps );
    		if( i != keyList.size() - 1 ){
    			strb.append( joiner );
    		}
    	}
    	return strb.toString();
    }
    
    /**
     * 初始化
     */
    public static void init(List<DictionaryEO> list) {
        Map<String, Map<String, String>> allDictionaryKvMap = new HashMap<String, Map<String, String>>();
        Map<String, List<DictionaryRO>> allDictionaryListMap = new HashMap<String, List<DictionaryRO>>();
        String curLabel = "";
        for (DictionaryEO eo : list) {
            String label = eo.getLabel();
            if (!curLabel.equals(label)) {
                allDictionaryKvMap.put(label, new HashMap<String, String>());
                allDictionaryListMap.put(label, new ArrayList<DictionaryRO>());
                curLabel = label;
            }

            String key = eo.getKey();
            String value = eo.getValue();
            allDictionaryKvMap.get(label).put(key, value);
            allDictionaryListMap.get(label).add(new DictionaryRO(eo));
        }
        ALL_DICTIONARY_KV_MAP = allDictionaryKvMap;
        ALL_DICTIONARY_LIST_MAP = allDictionaryListMap;
    }
    
    
/****用到的Label或key**********************************************************************/
    public static String LABEL_MPOS_MCC_PROFIT_VALUE="mposMccProfit";//mpos行业分润比例20130319
    public static String LABEL_MERCHANT_STATUS = "merchantStatus"; //商户状态
    public static String LABEL_TERMINAL_STATUS = "terminalStatus"; //终端状态
    
    public static String LABEL_MERCHANT_MPOS_MERCHANT_KIND_NAME = "merchantMposMerchantKindName"; //mpos商户(业务)类型名称，例如校园周边、非校园周边
    public static String LABEL_TERMINAL_MPOS_TERMINAL_KIND_NAME = "terminalMposTerminalKindName"; //mpos终端(业务)类型名称，例如mpos的一型机、二型机

    public static String LABEL_DIR_PATH = "dirPath";	//附件目录
    public static String LABEL_TXN_TYPE = "txnType";	//交易类型
    public static String LABEL_TXN_STATUS = "txnStatus";	//交易状态
    public static String LABEL_STL_STATUS = "stlStatus";	//结算状态
    public static String LABEL_CUR = "cur";	//币别
    public static String LABEL_CARD_TYPE = "cardType";	//卡类型
    public static String LABEL_SRV_ENTRY_MODE = "srvEntryMode";	//输入模式
    public static String LABEL_RESP_CODE = "respCode";	//响应码
    public static String LABEL_RECON_TYPE = "reconType";	//对账单类型
    public static String LABEL_RECON_GENERATE_TYPE = "reconGenerateType";	//对账单生成类型
    public static String LABEL_PROFIT_SETTLE_ORDER_STATUS = "profitSettleOrderStatus";	//分润结算单结算状态
    public static String LABEL_PROFIT_INVOICE_STATUS = "profitInvoiceStatus";	//分润发票状态

    public static String LABEL_PROFIT_ROLE_CODE = "profitRoleCode";	//分润角色代码
    public static String KEY_PROFIT_ROLE_CODE_POS_PMT = "roleCodePosPmt";	//分润角色-pos代理商
    public static String KEY_PROFIT_ROLE_CODE_MPOS_PMT = "roleCodeMposPmt";	//分润角色-mpos代理商
    
    
    public static String LABEL_APPLY_POSM_MERCHANT_STATUS = "applyPosmMerchantStatus";	//【进件】商户状态
    public static String LABEL_APPLY_POSM = "applyPosm";	//【进件】
    public static String KEY_APPLY_POSM_ATTACHMENT_TEMP_DIR = "attachmentTempDir";	//【进件】-服务端保存附件的临时目录
    public static String KEY_APPLY_POSM_FTP_HOST = "ftpHost";	//【进件】-服务端保存附件的临时目录
    public static String KEY_APPLY_POSM_FTP_USER = "ftpUser";	//【进件】-服务端保存附件的临时目录
    public static String KEY_APPLY_POSM_FTP_PASSWORD = "ftpPassword";	//【进件】-服务端保存附件的临时目录
    public static String KEY_APPLY_POSM_FTP_DIR = "ftpDir";	//【进件】-服务端保存附件的临时目录
    public static String KEY_APPLY_POSM_ATTACHMENT_SRC_PREFIX = "attachmentSrcPrefix";	//【进件】-附件的外网访问地址前缀
    public static String KEY_APPLY_POSM_CRM_OPEN_MERCHANT_MD5KEY = "crmOpenMerchantMd5key";	//【进件】-调用CRM签名md5的key
    public static String KEY_APPLY_POSM_MERCH_APPLY_FORM_PDF_TEMPLATE_PATH = "merchApplyFormPdfTemplatePath";  //【进件】-商户申请表pdf模板地址
    public static String KEY_APPLY_POSM_UPLOAD_PIC_SIZE_LIMIT = "uploadPicSizeLimit";  //【进件】-上传【图片】文件的最大字节数
    public static String KEY_APPLY_POSM_UPLOAD_ZIP_SIZE_LIMIT = "uploadZipSizeLimit";  //【进件】-上传【压缩】文件的最大字节数

    
    public static String LABEL_QUIT_ASS_URL = "quitAssUrl";	//(注销)链接后面跟的地址
    public static String KEY_QUIT_ASS_URL = "quitAssUrl"; //(注销)链接后面跟的地址
    
    public static String LABEL_OPERATION_MANUAL = "operationManual";	//【操作手册】
    public static String KEY_POS_MERCHANT_OPER_MANU_FORM_PDF_PATH = "posMerchantOperManuFormPdfPath"; //【操作手册】-POS商户版操作手册地址
    public static String KEY_POS_PROT_OPER_MANU_FORM_PDF_PATH = "posProtOperManuFormPdfPath"; //【操作手册】-POS代理商版操作手册地址
    public static String KEY_MPOS_PROT_OPER_MANU_FORM_PDF_PATH = "mposProtOperManuFormPdfPath"; //【操作手册】-MPOS代理商版操作手册地址

    public static String LABEL_DOC_TEMPLATE="docTemplate";//文档模板
    public static String KEY_DOC_TEMPLATE_TERMIANL_ADD_1="terminalAdd1";//增机
    public static String KEY_DOC_TEMPLATE_TERMIANL_ADD_2="terminalAdd2";//增机
    
    public static String LABEL_DOWNLOAD_RECORD_PARAMS = "downloadRecordParams";//下载记录的参数
    public static String KEY_DOWNLOAD_RECORD_PARAMS_FILE_BASE_PATH = "fileBasePath";	//下载记录的参数-(下载文件的)基本路径
    public static String KEY_DOWNLOAD_RECORD_PARAMS_DOWNLOADING_NUM_LIMIT = "downloadingNumLimit";	//下载记录的参数-(每个操作员)下载中的任务数限制
    public static String KEY_DOWNLOAD_RECORD_PARAMS_FILE_PATH_YYYYMMDD = "filePathYYYYMMDD";	//下载记录的参数-生成文件的地址是否带上年月日
    public static String KEY_DOWNLOAD_RECORD_PARAMS_OVERDUE_DAYS = "overdueDays";	//下载记录的参数-生成文件的地址是否带上年月日
    
    public static String LABEL_DOWNLOAD_RECORD_FUNC = "downloadRecordFunc";//下载记录的功能
    public static String LABEL_DOWNLOAD_RECORD_STATUS = "downloadRecordStatus";//下载记录的状态
    
    public static String LABEL_USE_CANCEL_BIND = "labelUseCancelBind"; //是否使用解绑功能
    public static String LABEL_ISSUER_ID = "issuerId"; //银行代码
    
    public static String LABEL_BMANAGER = "bmanager";	//【商务经理】

    public static String LABEL_MPOS_INFO_USE_STATUS = "mposInfoUseStatus";	//mposInfo的使用状态 

    public static String LABEL_WARN_CONF = "warnConf";	//warn(报警)设置
    public static String KEY_WARN_ENVIRONMENT = "warnEnvironment";	//warn(报警)设置
    public static String KEY_WARN_EMAIL_FROM = "warnEmailFrom";	//warn(报警)发件箱
    public static String KEY_WARN_EMAIL_TO_ETL_TASK = "warnEmailToEtlTask";	//warn(报警)收件人:etl任务
    
    public static String LABEL_FACADE_POSORDERQUERY_CONF = "facadePosOrderQueryConf";	//商户订单查询接口设置
    public static String KEY_FACADE_POSORDERQUERY_MERCHANT_TXNTIME_RANGE = "facadePOQMcTTimeRange";	//商户日期跨度限制(天)
    public static String KEY_FACADE_POSORDERQUERY_PMT_TXNTIME_RANGE = "facadePOQPmtTTimeRange";	//代理商日期跨度限制(天)
    public static String LABEL_SETTLE_TYPE="settleType"; //结算分润-结算类型
    
    public static String LABEL_PFS_SETTLE_ORDER_FILE_DIR = "pfsSttlOrderFileDirLabel";
    public static String PFS_SETTLE_ORDER_DETAIL_FILE_DIR = "pfsSttlOrderDetailFileDir";

    public static String LABEL_MPOS_PMT_STL_FAST_CONF = "mposPmtStlFastConf";	//mpos代理商快速结算配置
    public static String KEY_MPOS_PMT_STL_FAST_CONF_ESLP = "everySetLimitProp";//mpos代理商快速结算配置，每个商户的限制比例
    
    public static String LABEL_ETL_POSM_HG_LEVEL = "etlPosmHgLevel";	//清洗商户合规等级
    public static String KEY_ETL_POSM_HG_LEVEL_APP_ID = "appId";	//appId
    public static String KEY_ETL_POSM_HG_LEVEL_AUTH_KEY = "authKey";	//授权码
    
    public static String LABEL_TASK_RUNNER_ALLOWED_IPS = "lbtaskRunnerAllowedIps";	//允许运行任务的ip
    
    public static String LABEL_TASK_RUNNER_IP_CHECK = "lbTaskRunnerIpCheck";	//ip限制开关
    
    public static String KEY_TASK_RUNNER_IP_CHECK = "keyTaskRunnerIpCheck";	
    public static String KEY_TASK_RUNNER_IP_CHECK_ON = "1";	//限制开关-开
    
    public static String LABEL_MSP_FUNCTION_USE_LOG = "mspFunctionUseLog";	//MSP功能使用日志
    public static String KEY_FUL_TOTAL_RUN_FLAG = "totalRunFlag";//MSP功能使用日志总开关
    public static String KEY_FUL_TOTAL_RUN_FLAG_ON = "1";	//MSP功能使用日志总开关-开
    
    public static String LABEL_ETL_DATA_DEALER_CONFIG = "etlDataDealerConfig";	//etl数据处理配置
    public static String LABEL_ETL_DATA_DEALER_CONFIG_PPSI_FILL_OTHER_PROPERTIES1 = "ppsI_fillOtherProperties1";	//pps指令清洗是否执行fillOtherProperties1
    
    public static String LABEL_OPERATOR_LOCK = "operatorLockLabel";//操作者锁定
    public static String OPERATOR_ACCESS_LOCK_TIME = "operatorAccessLockTime";//操作者访问锁定时间
}
