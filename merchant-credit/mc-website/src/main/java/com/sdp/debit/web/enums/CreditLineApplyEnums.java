package com.sdp.debit.web.enums;
/**
 * 额度申请枚举类
 * @author zhangyulong
 *
 */
public class CreditLineApplyEnums {
	 /**
     * 申请人性别
     */
    public enum ApplicantSexEnum{
    	MAN("a","男"),
        WOMAN("b","女");

        private String code;
        private String description;

        ApplicantSexEnum(String code, String description){
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static ApplicantSexEnum parse(String code) {
            for (ApplicantSexEnum temp : values()) {
                if (temp.getCode().equals(code)) { return temp; }
            }
            return null;
        }
    }
    
    /**
     * 申请人婚姻状况
     */
    public enum MaritalStatusEnum{
    	UNMARRIED("a","未婚"),
    	MARRIED("b","已婚"),
        DIVORCE("c","离异"),
        WIDOWED("d","丧偶");

        private String code;
        private String description;

        MaritalStatusEnum(String code, String description){
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static MaritalStatusEnum parse(String code) {
            for (MaritalStatusEnum temp : values()) {
                if (temp.getCode().equals(code)) { return temp; }
            }
            return null;
        }
    }
    
    /**
     * 申请人亲人朋友关系枚举
     */
    public enum RelativeEnum{
    	OTHERRELATIVE("a","其他亲戚"),
    	FRIEND("b","朋友");

        private String code;
        private String description;

        RelativeEnum(String code, String description){
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static RelativeEnum parse(String code) {
            for (RelativeEnum temp : values()) {
                if (temp.getCode().equals(code)) { return temp; }
            }
            return null;
        }
    }
	
    /**
     * 保存或者更新标记
     */
    public enum SaveOrUpdateEnum{
    	SAVE("0","保存"),
    	UPDATE("1","更新");

        private String code;
        private String description;

        SaveOrUpdateEnum(String code, String description){
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public static SaveOrUpdateEnum parse(String code) {
            for (SaveOrUpdateEnum temp : values()) {
                if (temp.getCode().equals(code)) { return temp; }
            }
            return null;
        }
    }
    
    public enum OtherPropertyUploadEnum{
    	UNUPLOAD("0","未上传"),
    	UPLOAD("1","上传");
    	  private String code;
          private String description;

          OtherPropertyUploadEnum(String code, String description){
              this.code = code;
              this.description = description;
          }

          public String getCode() {
              return code;
          }

          public String getDescription() {
              return description;
          }

          public static OtherPropertyUploadEnum parse(String code) {
              for (OtherPropertyUploadEnum temp : values()) {
                  if (temp.getCode().equals(code)) { return temp; }
              }
              return null;
          }
    }
    
    public enum ApplicantAmountEnum{
    	FIVE("50000","五万"),
    	TEN("100000","十万"),
    	FIFTEEN("150000","十五万"),
    	TWENTY("200000","二十万"),
    	THIRTY("300000","三十万"),
    	FORTY("400000","四十万"),
    	FIFTY("500000","五十万");
    	
    	  private String code;
          private String description;

          ApplicantAmountEnum(String code, String description){
              this.code = code;
              this.description = description;
          }

          public String getCode() {
              return code;
          }

          public String getDescription() {
              return description;
          }

          public static ApplicantAmountEnum parse(String code) {
              for (ApplicantAmountEnum temp : values()) {
                  if (temp.getCode().equals(code)) { return temp; }
              }
              return null;
          }
    }
}
