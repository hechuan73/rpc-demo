package com.chuan.simulation.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.chuan.simulation.framework.Invocation;
import com.chuan.simulation.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author hechuan
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            var interfaceName = invocation.getInterfaceName();
            var methodName = invocation.getMethodName();
            var implClass = LocalRegister.get(interfaceName);
            var method = implClass.getMethod(methodName, invocation.getParamTypes());
            var result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            System.out.println("tomcat:" + result);
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
