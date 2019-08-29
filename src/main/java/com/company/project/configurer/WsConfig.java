package com.company.project.configurer;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * WebSocket配置类
 * </p>
 *
 * @package: com.xkcoding.websocket.socketio.config
 * @description: WebSocket配置类
 * @author: yangkai.shen
 * @date: Created in 2018-12-18 16:41
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@ConfigurationProperties(prefix = "ws.server")
public class WsConfig {
    /**
     * 端口号
     */
    private Integer port;

    /**
     * host
     */
    private String host;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}