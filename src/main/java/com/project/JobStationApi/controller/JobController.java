package com.project.JobStationApi.controller;

import com.project.JobStationApi.model.Job;
import com.project.JobStationApi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobList = jobService.getAllJobs();
        return new ResponseEntity<>(jobList, HttpStatus.OK);
    }

    @GetMapping("/{job_id}")
    public ResponseEntity<Job> getJobById(@PathVariable int job_id){
        Job job = jobService.getJobById(job_id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job_body){
        Job savedJob = jobService.addJob(job_body);  // save and get the saved entity (with ID)
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }


    @PutMapping("/{job_id}")
    public ResponseEntity<String> updateJob(@RequestBody Job job_body){

        return new ResponseEntity<>("Job updated", HttpStatus.OK);
    }

    @PatchMapping("/{job_id}")
    public ResponseEntity<String> updateJobLocation(@RequestBody Job job_body){

        return new ResponseEntity<>("Job location updated", HttpStatus.OK);
    }

    @DeleteMapping("/{job_id}")
    public ResponseEntity<String> deleteJob(){

        return new ResponseEntity<>("Job deleted", HttpStatus.OK);
    }
}
