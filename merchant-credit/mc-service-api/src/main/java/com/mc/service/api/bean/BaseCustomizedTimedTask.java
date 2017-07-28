package com.mc.service.api.bean;

import java.util.Map;

import com.mc.service.api.exception.TimedTaskException;

public abstract class BaseCustomizedTimedTask {
      public abstract void execute(Map<String,String> param) throws TimedTaskException;
      
      protected final String STATUS_FAILURE = "-1";
      
}
