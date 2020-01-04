package com.chuan.simulation.provider.service.impl;

import com.chuan.simulation.provider.service.HelloService;

/**
 * @author hechuan
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String username) {
        return "Hello " + username;
    }
}
