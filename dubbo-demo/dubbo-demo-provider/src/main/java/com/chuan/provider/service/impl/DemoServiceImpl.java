package com.chuan.provider.service.impl;

import com.chuan.api.DemoService;

/**
 * @author hechuan
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
