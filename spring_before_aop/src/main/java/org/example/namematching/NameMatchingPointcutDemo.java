package org.example.namematching;

import org.example.GrammyGuitarist;
import org.example.Guitar;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NameMatchingPointcutDemo {

    public static void main(String[] args) {
        GrammyGuitarist johnMayor = new GrammyGuitarist();

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("sing");
        pointcut.addMethodName("rest");

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(johnMayor);
        proxyFactory.addAdvisor(advisor);

        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();

        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();
    }
}
