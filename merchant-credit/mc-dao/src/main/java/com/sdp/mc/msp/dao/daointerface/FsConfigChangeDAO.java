package com.sdp.mc.msp.dao.daointerface;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sdp.mc.msp.dao.mapper.FsConfigChangeMapper;

public interface FsConfigChangeDAO extends FsConfigChangeMapper {

	@Select({ "SELECT MAX(FC.version) from TB_FS_CONFIG_CHANGE fc where FC.OBJ_ID = #{objId,jdbcType=DECIMAL} and fc.type = #{objType,jdbcType=DECIMAL} " })
	public Integer selectMaxVersion(@Param("objId") long objId, @Param("objType") int objType);
	@Select({"select count(t.create_time) from tb_fs_config_change t ",
	"where t.type = 1 " ,
	"and (t.beforefast_settle_workday_fee!=t.fast_settle_workday_fee or t.beforefast_settle_holiday_fee!=t.fast_settle_holiday_fee) " ,
	"and t.create_time between trunc(sysdate, 'mm') and add_months(trunc(sysdate,'mm'),1) " ,
	"and obj_id= #{objId,jdbcType=DECIMAL}"})
	public Integer selectChangeFeeSum(@Param("objId") long objId);
}