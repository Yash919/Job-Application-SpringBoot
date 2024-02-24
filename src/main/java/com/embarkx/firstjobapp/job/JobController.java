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
    public ResponseEntity<?> findAll(){
        // ResponseEntity<List<Job>>
        // return ResponseEntity.ok(jobService.findAll());
        List<Job> jobs=jobService.findAll();

        if(jobs.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse("No jobs were present currently.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }else{
            return new ResponseEntity<>(jobs,HttpStatus.OK);
        }
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<?> getJobById(@PathVariable Long id){
        // ResponseEntity<Job>
        Job job=jobService.getJobById(id);

        if(job !=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }else{
            ErrorResponse errorResponse = new ErrorResponse("No Job present for the ID: "+ id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        //return new Job(id,"null","null","null","null","null");
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete=jobService.deleteJobById(id);
        if(delete){
            return new ResponseEntity<>("Job Deleted Successfully ID: "+ id,HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with the ID: "+id+" is not present.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated=jobService.updateJobById(id,updatedJob);
        if(updated){
            return new ResponseEntity<>("Job Updated Successfully id: "+String.valueOf(id),HttpStatus.OK);
        }
        return new ResponseEntity<>("Job with ID: "+id+" is not present. No Updation take place",HttpStatus.NOT_FOUND);
    }
}
