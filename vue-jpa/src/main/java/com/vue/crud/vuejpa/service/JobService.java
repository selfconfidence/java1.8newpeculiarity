package com.vue.crud.vuejpa.service;

import com.vue.crud.vuejpa.pojo.JobInfo;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author misterWei
 * @create 2018年10月26号:09点02分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface JobService {

    public Page<JobInfo> findAll(Integer page,Integer size);
    void removeById(Long id);
    Optional<JobInfo> findById(Long id);
}
