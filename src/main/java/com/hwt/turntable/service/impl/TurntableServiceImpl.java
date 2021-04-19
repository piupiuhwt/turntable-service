package com.hwt.turntable.service.impl;

import com.hwt.turntable.cache.GlobalCache;
import com.hwt.turntable.config.GlobalConfiguration;
import com.hwt.turntable.entity.ConnectionInfo;
import com.hwt.turntable.service.TurntableService;
import com.hwt.turntable.utils.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TurntableServiceImpl implements TurntableService {
    private static final Logger logger = LoggerFactory.getLogger(TurntableServiceImpl.class);

    @Resource
    GlobalConfiguration globalConfiguration;

    @Resource
    GlobalCache globalCache;

    @Override
    public int getResult(ConnectionInfo connectionInfo) {
        int result = -1;
        String[] prizes = globalCache.getPrizes();
        try {

            if (prizes != null ) {
                int length = prizes.length;
                if (length == 0) {
                    return result;
                }
                result = RandomUtil.getInt(0, length);
            }
            return result;
        } finally {
            logger.info("本次连接：" + connectionInfo);
            logger.info("结果："+(result == -1 ? "数组未初始化或长度为0":prizes[result]));
        }
    }

    @Override
    public String[] getPrizes() {
        return globalCache.getPrizes();
    }
}
