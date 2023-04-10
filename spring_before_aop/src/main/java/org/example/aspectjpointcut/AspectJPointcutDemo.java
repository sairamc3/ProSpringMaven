package org.example.aspectjpointcut;

import org.example.GrammyGuitarist;
import org.example.Guitar;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectJPointcutDemo {

    public static void main(String[] args) {
        GrammyGuitarist greatGuitarist = new GrammyGuitarist();

        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression("execution(* sing*(..))");

        Advisor advisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(greatGuitarist);
        proxyFactory.addAdvisor(advisor);

        GrammyGuitarist proxy = (GrammyGuitarist) proxyFactory.getProxy();


        proxy.sing(new Guitar());
        proxy.sing();
        proxy.talk();
        proxy.rest();
    }
}
