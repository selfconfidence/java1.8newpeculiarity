package com.vue.crud.vuejpa.controller;

import com.vue.crud.vuejpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author misterWei
 * @create 2018年10月26号:09点03分
 * @mailbox mynameisweiyan@gmail.com
 */
@RestController
public class JobController {
    @Autowired
    private JobService jobService;
}
