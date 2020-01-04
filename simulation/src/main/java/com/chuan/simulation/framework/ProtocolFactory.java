package com.chuan.simulation.framework;

import com.chuan.simulation.protocol.http.HttpProtocol;

/**
 * @author hechuan
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (name == null || "".equals(name)) { name = "http"; }
        switch (name) {
            case "http": return new HttpProtocol();
            case "dubbo": return null;
            default:
                break;
        }
        return new HttpProtocol();
    }

}
