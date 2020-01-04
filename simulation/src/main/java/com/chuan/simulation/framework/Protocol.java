package com.chuan.simulation.framework;

import com.chuan.simulation.framework.URL;

/**
 * @author hechuan
 */
public interface Protocol {

    /**
     * Start the tomcat to run servlet apps.
     *
     * @param url the url of local listening
     */
    void start(URL url);

    /**
     * Send the remote process invocation and return the result.
     *
     * @param url the url of local listening
     * @param invocation the invocation data
     * @return the result of this remote process invocation
     */
    String send(URL url, Invocation invocation);
}
