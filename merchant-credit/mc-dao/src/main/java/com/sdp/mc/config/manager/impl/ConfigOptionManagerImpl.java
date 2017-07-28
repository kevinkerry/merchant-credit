package com.sdp.mc.config.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.vo.ConfigOptionVO;
import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
import com.sdp.mc.config.dao.daointerface.ConfigOptionDAO;
import com.sdp.mc.config.manager.ConfigOptionManager;

@Service("configOptionManager")
public class ConfigOptionManagerImpl implements ConfigOptionManager {
	private Logger logger = LoggerFactory.getLogger(ConfigOptionManagerImpl.class);
	
    @Autowired
    private ConfigOptionDAO configOptionDAO;

    /**
     * 根据主键删除null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long optionId) {
        int rows = configOptionDAO.deleteByPrimaryKey(optionId);
        return rows;
    }

    /**
     * 添加null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public Long insert(ConfigOptionDO record) {
        Long id = configOptionDAO.insert(record);
        return record.getOptionId();
    }

    /**
     * 添加null【ConfigOptionDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public Long insertSelective(ConfigOptionDO record) {
        Long id = configOptionDAO.insertSelective(record);
        return record.getOptionId();
    }

    /**
     * 根据Example对象查询得到null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ConfigOptionDO> selectByExample(ConfigOptionDOExample example) {
        List<ConfigOptionDO> list = configOptionDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public ConfigOptionDO selectByPrimaryKey(Long optionId) {
        ConfigOptionDO record = configOptionDAO.selectByPrimaryKey(optionId);
        return record;
    }

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(ConfigOptionDO record) {
        int rows = configOptionDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public int updateByPrimaryKey(ConfigOptionDO record) {
        int rows = configOptionDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    @Override
    public List<ConfigOptionDO> selectByQuery(ConfigOptionDOExample example) {
        Integer totalItem = (Integer)configOptionDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<ConfigOptionDO> returnList = new ArrayList<ConfigOptionDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<ConfigOptionDO> list =configOptionDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
    
    public void timerUpdate() {
        Timer timer = new Timer();  
        timer.schedule(new TimerTask() {  
            public void run() {  
            	loadConfigOption();
            }  
        }, 60000, 60000); 

      }
    
    @PostConstruct
    public void init(){
    	loadConfigOption();
		timerUpdate();
    }
    @Override
    public void loadConfigOption(){
    	logger.info("loadConfigOption start...");
    	ConfigOptionDOExample example = new ConfigOptionDOExample();
    	List<ConfigOptionDO> list = this.selectByExample(example);
    	if (list != null && list.size() > 0) {
    		List<ConfigOptionVO> listVO = new ArrayList<ConfigOptionVO>();
    		for (ConfigOptionDO configOptionDO : list) {
    			ConfigOptionVO vo = new ConfigOptionVO();
    			BeanUtils.copyProperties(configOptionDO, vo);
    			listVO.add(vo);
    		}
    		ConfigOptionHelper.init(listVO);
    	} 
    	logger.info("loadConfigOption end!");
    }
    
	/*public String getConfigByKey(String key) {
		ConfigOptionDOExample example = new ConfigOptionDOExample();
		example.setOptionKey(key);
		List<ConfigOptionDO> list = this.selectByExample(example);
		if (list != null && list.size() > 0) {
			ConfigOptionDO cfg = list.get(0);
			if (StringUtils.isNotBlank(cfg.getOptionValue())) {
				return cfg.getOptionValue();
			} else {
				return cfg.getOptionDefValue();
			}
		}
		return null;
	}
	
	*//**
	 * 根据key查询配置
	 * **//*
	public Long getLongByKey(String key) {
		String value = this.getConfigByKey(key);
		if (value != null) {
			return Long.valueOf(value);
		}
		return null;
	}

	public boolean getBooleanByKey(String key) {
		String cfg = this.getConfigByKey(key);
		if ("".equals(cfg) || cfg == null) {
			return false;
		}
		return Boolean.valueOf(cfg);
	}*/

}