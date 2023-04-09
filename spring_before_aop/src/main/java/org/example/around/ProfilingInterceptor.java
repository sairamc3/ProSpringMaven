package org.example.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.Arrays;


public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        System.out.println("Before method started, started the timer");

        Object proceed = invocation.proceed();

        stopWatch.stop();

        dumpInfo(invocation, stopWatch.getTotalTimeMillis());
        return proceed;
    }

    private void dumpInfo(MethodInvocation invocation, long totalTimeMillis) {

        Method method = invocation.getMethod();
        Object[] arguments = invocation.getArguments();
        Object target = invocation.getThis();

        System.out.println("Executed Method -> " + method.getName());
        System.out.println(" on the object of type -> " + target.getClass().getName());

        System.out.println(" With Arguments -> ");

        Arrays.stream(arguments).forEach(System.out::println);

        System.out.println(" time taken -> " + totalTimeMillis + " ms");
    }
}
