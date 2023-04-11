package org.example.annotationpointcut;

import org.example.GrannyGuitarist;
import org.example.Guitar;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutDemo {

    public static void main(String[] args) {
        GrannyGuitarist grannyGuitarist = new GrannyGuitarist();

        Pointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(grannyGuitarist);
        proxyFactory.addAdvisor(advisor);

        GrannyGuitarist proxy = (GrannyGuitarist) proxyFactory.getProxy();

        proxy.rest();
        proxy.sing(new Guitar());
        proxy.talk();


    }
}
