package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    // Before JPA we are working via ArrayList
    //private List<Job> jobs=new ArrayList<>();

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        /* Before JPA
        job.setId(nextID++); // define Long nextID= 1L;
        jobs.add(job);
         */
        // After JPA
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        /* Before JPA
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
         */
        // After JPA
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        /* Before JPA
        Iterator<Job> iterator= jobs.iterator();
        while(iterator.hasNext()){
            Job job=iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
         */
        // After JPA
        try {
            Optional<Job> jobOptional = jobRepository.findById(id);
            if(jobOptional.isPresent()){
                jobRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        /* Before JPA
        for(Job job:jobs){
            if(job.getId().equals(id)){
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setTitle(updatedJob.getTitle());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                return true;
            }
        }
        return false;

         */
        // After JPA
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setDescription(updatedJob.getDescription());
            job.setLocation(updatedJob.getLocation());
            job.setTitle(updatedJob.getTitle());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
