package com.chuan.consumer;

import com.chuan.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hechuan
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        System.out.println(demoService.sayHello("hechuan"));
    }
}
