package com.chuan.simulation.framework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hechuan
 */
@Data
@AllArgsConstructor
public class URL implements Serializable {

    private String host;
    private int port;
}
