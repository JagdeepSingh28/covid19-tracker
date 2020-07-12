package io.corona.covid19tracker.controller;

import io.corona.covid19tracker.models.LocationStats;
import io.corona.covid19tracker.repository.LocationStatsRepository;
import io.corona.covid19tracker.services.CoronaVirusDataService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationStatsController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job processJob;

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @Autowired
    LocationStatsRepository locationStatsRepository;

    @GetMapping(value="/data")
    public List<LocationStats> getData() throws Exception{
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);

        System.out.println("Batch job has been invoked");

        return locationStatsRepository.findAll();
    }
}
