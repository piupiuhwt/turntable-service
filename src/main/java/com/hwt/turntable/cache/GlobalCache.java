package com.hwt.turntable.cache;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class GlobalCache {

    @Value("${prizes}")
    private String[] prizes;
}
