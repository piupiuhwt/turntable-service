package com.hwt.turntable.service;

import com.hwt.turntable.entity.ConnectionInfo;

import java.util.List;

public interface TurntableService {
    /**
     * 获取转盘结果
     * @return 本次转盘结果值
     */
    int getResult(ConnectionInfo connectionInfo);

    /**
     * 获取转盘的奖品列表
     * @return 转盘奖品列表
     */
    String[] getPrizes();
}
