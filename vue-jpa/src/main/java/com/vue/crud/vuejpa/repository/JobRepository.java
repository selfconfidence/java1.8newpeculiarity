package com.vue.crud.vuejpa.repository;

import com.vue.crud.vuejpa.pojo.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author misterWei
 * @create 2018年10月26号:09点00分
 * @mailbox mynameisweiyan@gmail.com
 */
public interface JobRepository extends JpaRepository<JobInfo,Long>,JpaSpecificationExecutor<JobInfo> {
}
