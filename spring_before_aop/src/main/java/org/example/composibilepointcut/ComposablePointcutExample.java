package org.example.composibilepointcut;

import org.example.GrammyGuitarist;
import org.example.Guitar;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ComposablePointcutExample {

    public static void main(String[] args) {
        GrammyGuitarist grammyGuitarist = new GrammyGuitarist();

        ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new SingleMethodMatcher());


        System.out.println("----Test-1----");
        GrammyGuitarist proxy = getProxy(grammyGuitarist, pointcut);
        testProxy(proxy);
        System.out.println();


        System.out.println("----Test-2----");
        pointcut.union(new TalkMethodMatcher());
        proxy = getProxy(grammyGuitarist, pointcut);
        testProxy(proxy);
        System.out.println();


        System.out.println("----Test-3----");
        pointcut.intersection(new RestMethodMatcher());
        proxy = getProxy(grammyGuitarist, pointcut);
        testProxy(proxy);


    }

    private static void testProxy(GrammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }

    private static GrammyGuitarist getProxy(GrammyGuitarist grammyGuitarist, ComposablePointcut pointcut) {

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(grammyGuitarist);

        return (GrammyGuitarist) proxyFactory.getProxy();
    }

}
