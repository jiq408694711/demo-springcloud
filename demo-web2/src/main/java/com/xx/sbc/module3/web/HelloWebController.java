package com.xx.sbc.module3.web;

import com.xx.sbc.module3.service.Module3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiyiqin on 2019/6/29.
 */
@RestController
@RequestMapping("web2/module3")
public class HelloWebController {

    @Autowired
    private Module3Service module3Service;

    @GetMapping("/query")
    public String query(Long id) {
        return module3Service.query(id);
    }
}
