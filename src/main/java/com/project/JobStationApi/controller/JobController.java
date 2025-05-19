package com.project.JobStationApi.controller;

import com.project.JobStationApi.model.Job;
import com.project.JobStationApi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public ResponseEntity<String> getAllJobs(){
        jobService.getAllJobs();
        return new ResponseEntity<>("all jobs", HttpStatus.OK);
    }

    @GetMapping("/{job_id}")
    public ResponseEntity<String> getJobById(){

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job_body){

        return new ResponseEntity<>("Job created", HttpStatus.OK);
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
