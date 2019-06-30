package com.xx.sbc.module3.service;

import org.springframework.stereotype.Service;

/**
 * Created by jiyiqin on 2019/6/30.
 */
@Service
public class Module3Service {

    public String query(Long id) {
        return "web2:" + id;
    }
}
