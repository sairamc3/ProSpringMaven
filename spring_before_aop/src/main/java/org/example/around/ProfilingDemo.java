package org.example.around;

import org.example.WorkerBean;
import org.springframework.aop.framework.ProxyFactory;

public class ProfilingDemo {

    public static void main(String[] args) {
        WorkerBean workerBean = new WorkerBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new ProfilingInterceptor());
        proxyFactory.setTarget(workerBean);

        WorkerBean proxy = (WorkerBean) proxyFactory.getProxy();
        proxy.doSomeWork(100);
    }
}
