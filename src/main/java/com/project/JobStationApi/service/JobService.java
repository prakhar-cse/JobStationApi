package com.project.JobStationApi.service;

import com.project.JobStationApi.exception.JobNotFoundException;
import com.project.JobStationApi.model.Job;
import com.project.JobStationApi.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JobService {

    private static final Logger log = LoggerFactory.getLogger(JobService.class);
    @Autowired
    JobRepository jobRepository;

    public List<Job> getAllJobs(){
        log.info("---List of all jobs---");
        return jobRepository.findAll();
    }

    public Job getJobById(int jobId){
        if(jobId <= 0){
            log.info("---{} is invalid---",jobId);
            throw new IllegalArgumentException("Job Id must be valid");
        }
        return jobRepository.findById(jobId).orElseThrow(()-> new JobNotFoundException("Job "+jobId+" is not present"));
    }

    public Job addJob(Job job){
        log.info("---{} job is added---",job.getJobTitle());
        return jobRepository.save(job);
    }

    public void deleteJobById(int jobId){
        if(jobId <= 0){
            throw new IllegalArgumentException("Job Id must be valid");
        }
        if(! jobRepository.existsById(jobId)){
            throw new JobNotFoundException("Job "+jobId+" is not present");
        }
        log.info("---jobid {} is deleted---",jobId);
        jobRepository.deleteById(jobId);
    }

    public Job updateJob(int job_id, Job newJobBody) {
        Optional<Job> oldJob = jobRepository.findById(job_id);
        if(oldJob.isEmpty()){
            ResponseEntity.notFound();
        }

        Job JobObj = oldJob.get();
        JobObj.setJobLocation(newJobBody.getJobLocation());
        JobObj.setJobTitle(newJobBody.getJobTitle());
        JobObj.setJobDescription(newJobBody.getJobDescription());

        log.info("---jobId {} is updated---",job_id);
        jobRepository.save(JobObj);
        return JobObj;
    }
}
