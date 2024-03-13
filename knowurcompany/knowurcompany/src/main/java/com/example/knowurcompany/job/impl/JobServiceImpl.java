package com.example.knowurcompany.job.impl;

import com.example.knowurcompany.job.Job;
import com.example.knowurcompany.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs=new ArrayList<>();
    private Long nextId= 1L;
    public List<Job> findAll() {
        return jobs;
    }


    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    public Job getJobById(Long id){
        for(int i=0;i<jobs.size();i++){
            if(jobs.get(i).getId()==id){
                return jobs.get(i);
            }
        }
        return null;
    }
}
