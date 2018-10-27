package com.vue.crud.vuejpa.service.impl;

import com.vue.crud.vuejpa.pojo.JobInfo;
import com.vue.crud.vuejpa.repository.JobRepository;
import com.vue.crud.vuejpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Page<JobInfo> findAll(Integer page,Integer size)
    {
        Page<JobInfo> all = jobRepository.findAll(PageRequest.of(page, size));

        return all;
    }

    @Override
    public void removeById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Optional<JobInfo> findById(Long id) {
        return jobRepository.findById(id);
    }
}
