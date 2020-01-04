package com.chuan.simulation.consumer;

import com.chuan.simulation.framework.ProxyFactory;
import com.chuan.simulation.provider.service.HelloService;

/**
 * @author hechuan
 */
public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = (HelloService) ProxyFactory.getProxy(HelloService.class);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.sayHello("hechuan"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
