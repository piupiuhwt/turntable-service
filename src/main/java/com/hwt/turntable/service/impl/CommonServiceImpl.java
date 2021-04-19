package com.hwt.turntable.service.impl;

import com.hwt.turntable.TurntableApplication;
import com.hwt.turntable.entity.ConnectionInfo;
import com.hwt.turntable.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Service
public class CommonServiceImpl implements CommonService {
    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);
    @PostConstruct
    public void init(){
        ConnectionInfo connectionInfo = new ConnectionInfo();
    }

    @Override
    public ConnectionInfo getConnectionInfo(HttpServletRequest request) {
        ConnectionInfo.ConnectionInfoBuilder builder = new ConnectionInfo.ConnectionInfoBuilder();
        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        String forwardAddress = request.getHeader("x-forwarded-for");
        String ipString = forwardAddress != null ? forwardAddress : request.getRemoteAddr();
        String host = request.getRemoteHost();
        int port = request.getRemotePort();
        builder.setHost(host).setIpString(ipString).setPort(port);
        return builder.build();
    }
}
