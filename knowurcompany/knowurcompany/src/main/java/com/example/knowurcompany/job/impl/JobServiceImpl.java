package com.example.knowurcompany.job.impl;

import com.example.knowurcompany.job.Job;
import com.example.knowurcompany.job.JobRepositiry;
import com.example.knowurcompany.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

   // private List<Job> jobs=new ArrayList<>();

    JobRepositiry jobRepositiry;

    public JobServiceImpl(JobRepositiry jobRepositiry) {
        this.jobRepositiry = jobRepositiry;
    }

    private Long nextId= 1L;
    public List<Job> findAll() {
        return jobRepositiry.findAll();
    }


    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepositiry.save(job);
    }

    public Job getJobById(Long id){
        return jobRepositiry.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        try{
            jobRepositiry.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepositiry.findById(id);

            if(jobOptional.isPresent()){
                Job job=jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setTitle(updatedJob.getTitle());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                jobRepositiry.save(job);
                return true;
            }

        return false;
    }

}
