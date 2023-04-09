package org.example.dynamicpointcut;

import org.example.SampleBean;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {

        int num = ((Integer) args[0]).intValue();
        return num!=100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz == SampleBean.class;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "foo".equals(method.getName());
    }
}
