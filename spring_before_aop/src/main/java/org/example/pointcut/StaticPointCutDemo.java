package org.example.pointcut;

import org.example.GoodGuitarist;
import org.example.GreatGuitarist;
import org.example.Singer;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointCutDemo {

    public static void main(String[] args) {
        GoodGuitarist goodGuitarist = new GoodGuitarist();
        GreatGuitarist greatGuitarist = new GreatGuitarist();

        Singer proxyOne;
        Singer proxyTwo;

        // Pointcut configuration
        Pointcut pointcut = new SimpleStaticPointcut();
        SimpleBeforeAdvice advice = new SimpleBeforeAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(goodGuitarist);

        proxyOne= (Singer) proxyFactory.getProxy();

        proxyFactory= new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(greatGuitarist);
        proxyTwo = (Singer) proxyFactory.getProxy();


        proxyOne.sing();
        proxyTwo.sing();


    }
}
