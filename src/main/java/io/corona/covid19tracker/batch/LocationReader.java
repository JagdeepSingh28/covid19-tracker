package io.corona.covid19tracker.batch;

import io.corona.covid19tracker.models.LocationStats;
import io.corona.covid19tracker.services.CoronaVirusDataService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationReader implements ItemReader<LocationStats> {

    private int nextIndex;
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @Override
    public LocationStats read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        LocationStats locationStats = null;

        if (nextIndex < coronaVirusDataService.getAllStats().size()) {
            locationStats = coronaVirusDataService.getAllStats().get(nextIndex);
            nextIndex++;
        }

        return locationStats;

//        return coronaVirusDataService.getAllStats();
    }
}
