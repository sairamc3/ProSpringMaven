package org.example.regexpointcut;

import org.example.GrammyGuitarist;
import org.example.GreatGuitarist;
import org.example.Guitar;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexPointcutDemo {

    public static void main(String[] args) {
        GrammyGuitarist grammyGuitarist = new GrammyGuitarist();

        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPattern(".*sing.*");

        Advisor advisor = new DefaultPointcutAdvisor(jdkRegexpMethodPointcut, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(grammyGuitarist);
        proxyFactory.addAdvisor(advisor);

        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();

        proxy.sing();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }
}
