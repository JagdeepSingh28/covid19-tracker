package io.corona.covid19tracker.batch;

import io.corona.covid19tracker.models.LocationStats;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<LocationStats, LocationStats> {

    @Override
    public LocationStats process(LocationStats locationStats) throws Exception {
        return locationStats;
    }
}
