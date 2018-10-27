package com.vue.crud.vuejpa.controller;

import com.vue.crud.vuejpa.pojo.JobInfo;
import com.vue.crud.vuejpa.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author misterWei
 * @create 2018年10月26号:09点03分
 * @mailbox mynameisweiyan@gmail.com
 */
@RestController
@RequestMapping("/jobo")
public class JobController {
    @Autowired
    private JobService jobService;
   @GetMapping("/findAll")
    public Page<JobInfo> findAll(Integer page, Integer size){
       return jobService.findAll(page,size);
   }
   @GetMapping("/removeById/{id}")
    public boolean removeById(@PathVariable Long id){
       try {
           jobService.removeById(id);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
   }
    @GetMapping("/findById/{id}")
    public JobInfo findById(@PathVariable Long id){
        Optional<JobInfo> byId = jobService.findById(id);
        return byId.get();
    }

}
