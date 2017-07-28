package com.sdp.test.mc.job;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.management.InstanceNotFoundException;

import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public abstract class MiniTestCase extends AbstractJUnit4SpringContextTests {

    private Object testTargetObject;
    private AtomicBoolean init = new AtomicBoolean(false);
    private Logger logger = LoggerFactory.getLogger(getClass());
    private ConcurrentHashMap<Object, Object> mockObjectSet = new ConcurrentHashMap<Object, Object>();
    private List<Class<?>> testTargetFields = null;
    /**
     *
     * @param testTargetClass 被测试的目标类
     * @param testTargetField 被Mock testTargetClass属性。该参数可为空，为空时会Mock testTargetClass的所有属性。
     */
    public void makeMiniTestCase(Object testTargetObject, Class<?>... testTargetField) throws Exception{
        if (testTargetObject == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(" 'testTargetObject'  Can't be null");
            logger.error("", illegalArgumentException);
            throw illegalArgumentException;
        }
        this.testTargetObject = testTargetObject;
        if (testTargetField != null) {
            this.testTargetFields = Arrays.asList(testTargetField);
        }

        try {
            initMock(testTargetObject);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("", e);
            throw e;
        }
    }

    private void initMock(Object object) throws IllegalArgumentException, IllegalAccessException{
        logger.debug("正在初始化 MiniTestCase ...");
        if (init.compareAndSet(false, true)) {
            Class<? extends Object> cls = object.getClass();

            procField(getFields(cls));
            logger.debug("初始化完成 MiniTestCase .");
        }
    }

    private void procField(List<Field> targetFieldList) throws IllegalArgumentException, IllegalAccessException{
        if (targetFieldList == null || targetFieldList.isEmpty()) {
            return;
        }

        for (Field field : targetFieldList) {

            Class<?> typeOfTargetObject = field.getType();
            if (testTargetFields != null &&
                !testTargetFields.isEmpty() &&
                !testTargetFields.contains(typeOfTargetObject)) {
                continue;
            }

            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                Object mock = PowerMockito.mock(typeOfTargetObject);
                mockObjectSet.putIfAbsent(field.getName(), mock);
                setField(field, mock);
            }

        }
    }

    private void setField(Field field, Object mock) throws IllegalArgumentException, IllegalAccessException{
        field.setAccessible(true);
        field.set(testTargetObject, mock);
    }

    private List<Field> getFields(Class<?> targetClass) {
        List<Field> list = new ArrayList<Field>();
        list.addAll(Arrays.asList(targetClass.getDeclaredFields()));
        return list;
    }

    protected <T> T mock(String fieldName, Class<T> t) throws InstanceNotFoundException{
        Object object = mockObjectSet.get(fieldName);
        if (object == null) {
            throw new InstanceNotFoundException("Mock '"+fieldName+"' Object is not found!!");
        }
        logger.debug("成功Mock '" + fieldName +"' 实例.");
        return t.cast(object);
    }
}
