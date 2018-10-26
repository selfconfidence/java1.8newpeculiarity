package com.vue.crud.vuejpa.service.impl;

import com.vue.crud.vuejpa.pojo.JobInfo;
import com.vue.crud.vuejpa.repository.JobRepository;
import com.vue.crud.vuejpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年10月26号:09点02分
 * @mailbox mynameisweiyan@gmail.com
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<JobInfo> findAll() {
        return jobRepository.findAll();
    }
}
