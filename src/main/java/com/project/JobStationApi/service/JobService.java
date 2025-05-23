package com.project.JobStationApi.service;

import com.project.JobStationApi.exception.JobNotFoundException;
import com.project.JobStationApi.model.Job;
import com.project.JobStationApi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job getJobById(int jobId){
        if(jobId <= 0){
            throw new IllegalArgumentException("Job Id must be valid");
        }
        return jobRepository.findById(jobId).orElseThrow(()-> new JobNotFoundException("Job"+jobId+" is not present"));
    }

    public Job addJob(Job job){
        return jobRepository.save(job);
    }

    public void deleteJobById(int jobId){
        if(jobId <= 0){
            throw new IllegalArgumentException("Job Id must be valid");
        }
        jobRepository.deleteById(jobId);
    }
}
