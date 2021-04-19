package com.hwt.turntable.service;

import com.hwt.turntable.entity.ConnectionInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用服务
 */
public interface CommonService {
    ConnectionInfo getConnectionInfo(HttpServletRequest request);
}
