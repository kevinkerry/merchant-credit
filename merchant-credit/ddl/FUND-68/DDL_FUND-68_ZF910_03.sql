alter session set current_schema = mcredit;
alter table FW_POLICY_CONFIG_INFO add QUOTA_TYPE NUMBER;
comment on column MCREDIT.FW_POLICY_CONFIG_INFO.QUOTA_TYPE
  is '额度类型 1：临时 2：永久'; 