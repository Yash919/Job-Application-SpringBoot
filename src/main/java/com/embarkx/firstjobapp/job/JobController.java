package com.embarkx.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {


    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        //return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job=jobService.getJobById(id);

        if(job !=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        //return new Job(id,"null","null","null","null","null");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete=jobService.deleteJobById(id);
        if(delete){
            return new ResponseEntity<>("Job Deleted Successfully id: "+String.valueOf(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated=jobService.updateJobById(id,updatedJob);
        if(updated){
            return new ResponseEntity<>("Job Updated Successfully id: "+String.valueOf(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
