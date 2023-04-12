package org.example.controlflowpointcut;

import org.example.GreatGuitarist;
import org.example.before.SimpleBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowDemo {
    public static void main(String[] args) {
        ControlFlowDemo controlFlowDemo = new ControlFlowDemo();
        controlFlowDemo.run();
    }

    private void run() {

        GreatGuitarist greatGuitarist = new GreatGuitarist();

        Pointcut pc = new ControlFlowPointcut(ControlFlowDemo.class, "test");

        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(greatGuitarist);
        proxyFactory.addAdvisor(advisor);

        GreatGuitarist proxy = (GreatGuitarist) proxyFactory.getProxy();

        System.out.println("Trying under normal invoke");
        proxy.sing();

        System.out.println("Trying under ControlFlowDemo.test");
        test(proxy);

    }

    private void test(GreatGuitarist greatGuitarist) {

        greatGuitarist.sing();
    }


}
