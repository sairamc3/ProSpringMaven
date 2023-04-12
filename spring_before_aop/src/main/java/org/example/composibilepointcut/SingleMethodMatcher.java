package org.example.composibilepointcut;

import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

public class SingleMethodMatcher extends StaticMethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().startsWith("si");
    }
}
