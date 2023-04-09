package org.example.after;

import org.example.Guitarist;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class AfterReturningAdvice implements org.springframework.aop.AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue,
                               Method method,
                               Object[] args,
                               Object target) throws Throwable {
        System.out.println("After " + method.getName()+", Put down the guitar");
    }

    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AfterReturningAdvice());
        proxyFactory.setTarget(guitarist);

        Guitarist proxy = (Guitarist)proxyFactory.getProxy();

        proxy.sing();
    }
}
