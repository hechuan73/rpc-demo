package com.chuan.simulation.framework;

import java.lang.reflect.Proxy;

/**
 * @author hechuan
 */
public class ProxyFactory {

    public static Object getProxy(final Class interfaceClass) {
        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass},
                (proxy, method, args) -> {
            Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), args,
                    method.getParameterTypes());
            URL url = new URL("localhost", 8080);
            Protocol protocol = ProtocolFactory.getProtocol();
            return protocol.send(url, invocation);
        });

    }
}
