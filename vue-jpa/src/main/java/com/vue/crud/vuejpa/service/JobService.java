package com.vue.crud.vuejpa.service;

import com.vue.crud.vuejpa.pojo.JobInfo;

import java.util.List;

/**
 * @author misterWei
 * @create 2018年10月26号:09点02分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface JobService {

    public List<JobInfo> findAll();
}
