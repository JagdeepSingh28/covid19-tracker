package io.corona.covid19tracker.batch;

import io.corona.covid19tracker.models.LocationStats;
import io.corona.covid19tracker.repository.LocationStatsRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<LocationStats> {

    @Autowired
    private LocationStatsRepository locationStatsRepository;

    private static final String QUERY_INSERT_STUDENT = "INSERT " +
            "INTO location_stats(state, country, latest_total_cases, diff_from_prev_day) " +
            "VALUES (?, ?, ?, ?)";

    @Override
    public void write(List<? extends LocationStats> locationStats) throws Exception {
//        System.out.println("Data Saved for Users: " + locationStats);
//        locationStatsRepository.saveAll(locationStats);
    }

//    @Bean
//    JdbcBatchItemWriter<LocationStats> databaseItemWriter(DataSource dataSource,
//                                                 NamedParameterJdbcTemplate jdbcTemplate) {
//        JdbcBatchItemWriter<LocationStats> databaseItemWriter = new JdbcBatchItemWriter<>();
//        databaseItemWriter.setDataSource(dataSource);
//        databaseItemWriter.setJdbcTemplate(jdbcTemplate);
//
//        databaseItemWriter.setSql(QUERY_INSERT_STUDENT);
//
//        ItemPreparedStatementSetter<LocationStats> valueSetter =
//                new LocationStatsPreparedStatementSetter();
//        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);
//
//        return databaseItemWriter;
//    }
}
