package com.chuan.simulation.provider;

import com.chuan.simulation.framework.Protocol;
import com.chuan.simulation.framework.ProtocolFactory;
import com.chuan.simulation.framework.URL;
import com.chuan.simulation.provider.service.HelloService;
import com.chuan.simulation.provider.service.impl.HelloServiceImpl;

/**
 * @author hechuan
 */
public class Provider {

    public static void main(String[] args) {
        LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);
        // need to config the host and port in boot parameters.
        URL url = new URL("localhost", Integer.parseInt(System.getProperty("port")));
        // start the tomcat
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
