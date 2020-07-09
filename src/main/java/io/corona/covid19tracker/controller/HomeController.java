package io.corona.covid19tracker.controller;

import io.corona.covid19tracker.models.LocationStats;
import io.corona.covid19tracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping(value="/data")
    public List<LocationStats> getData() {
        return coronaVirusDataService.getAllStats();
    }
}
