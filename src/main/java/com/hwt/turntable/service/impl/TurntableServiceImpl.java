package com.hwt.turntable.service.impl;

import com.hwt.turntable.cache.GlobalCache;
import com.hwt.turntable.config.GlobalConfiguration;
import com.hwt.turntable.service.TurntableService;
import com.hwt.turntable.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class TurntableServiceImpl implements TurntableService {
    @Resource
    GlobalConfiguration globalConfiguration;

    @Resource
    GlobalCache globalCache;

    @Override
    public int getResult() {
        int result = -1;
        String[] prizes = globalCache.getPrizes();
        if (prizes != null ) {
            int length = prizes.length;
            if (length == 0) {
                return result;
            }
            result = RandomUtil.getInt(0, length+1);
        }
        return result;
    }

    @Override
    public String[] getPrizes() {
        return globalCache.getPrizes();
    }
}
