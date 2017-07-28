﻿
ALTER SESSION SET CURRENT_SCHEMA = MCREDITUSER;

CREATE TABLE MCREDIT.FW_MERCHANT_LIMIT_RULE
(
  ID                           NUMBER,
  TYPE                         NUMBER,
  MERCHANT_TYPE                VARCHAR2(4 BYTE),
  MERCHANT_NO                  VARCHAR2(18 BYTE),
  LIMIT                      NUMBER,
  STATUS                       NUMBER,
  OPERATOR_ID                  VARCHAR2(32 BYTE),
  OPERATOR_NAME                VARCHAR2(32 BYTE),
  CREATE_TIME                  TIMESTAMP(6),
  UPDATE_TIME                  TIMESTAMP(6)
);

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.ID IS 'ID';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.TYPE IS '配置类型（1: 默认,2:限定）';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.MERCHANT_TYPE IS '商户类型';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.MERCHANT_NO IS '商户号';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.LIMIT IS '额度';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.STATUS IS '状态(1: 有效，0：失效)';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.OPERATOR_ID IS '操作人ID';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.OPERATOR_NAME IS '操作人名称';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.CREATE_TIME IS '创建时间';

COMMENT ON COLUMN MCREDIT.FW_MERCHANT_LIMIT_RULE.UPDATE_TIME IS '更新时间';


ALTER TABLE MCREDIT.FW_MERCHANT_LIMIT_RULE ADD (
  PRIMARY KEY
 (ID));


CREATE SEQUENCE MCREDIT.SEQ_FW_MERCHANT_LIMIT_RULE;

GRANT DELETE, INSERT, SELECT, UPDATE ON MCREDIT.FW_MERCHANT_LIMIT_RULE TO MCREDITUSER;

GRANT SELECT ON MCREDIT.SEQ_FW_MERCHANT_LIMIT_RULE TO MCREDITUSER;

ALTER SESSION SET CURRENT_SCHEMA = MCREDITUSER;

CREATE OR REPLACE SYNONYM MCREDITUSER.SEQ_FW_MERCHANT_LIMIT_RULE FOR MCREDIT.SEQ_FW_MERCHANT_LIMIT_RULE;
CREATE OR REPLACE SYNONYM MCREDITUSER.FW_MERCHANT_LIMIT_RULE FOR MCREDIT.FW_MERCHANT_LIMIT_RULE;
