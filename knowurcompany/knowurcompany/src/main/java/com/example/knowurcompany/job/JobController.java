package com.example.knowurcompany.job;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Successfully created",HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job=jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean isDelete=jobService.deleteJob(id);
        if(isDelete)
            return new ResponseEntity<>("Job deleted",HttpStatus.OK);
        else
            return new ResponseEntity<>("Job deletion failed",HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated= jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
