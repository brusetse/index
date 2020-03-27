package com.bruse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class IpWhiteList {

    /**
     * 是否开启白名单
     */
    @Value("${dubbo.ipwhite.enabled:true}")
    private boolean enabled;

    /**
     * IP白名单列表
     */
    @Value("#{'${dubbo.ipwhite.list}'.split(',')}")
    private List<String> allowedIps;

    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getAllowedIps() {
        return allowedIps;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAllowedIps(List<String> allowedIps) {
        this.allowedIps = allowedIps;
    }
}
