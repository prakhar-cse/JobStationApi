package com.project.JobStationApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    int JobId;
    String JobLocation;
    String JobTitle;
    String JobDescription;

}
