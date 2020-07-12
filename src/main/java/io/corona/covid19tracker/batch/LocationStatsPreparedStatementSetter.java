package io.corona.covid19tracker.batch;

import io.corona.covid19tracker.models.LocationStats;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocationStatsPreparedStatementSetter implements ItemPreparedStatementSetter<LocationStats> {

    @Override
    public void setValues(LocationStats locationStats,
                          PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, locationStats.getState());
        preparedStatement.setString(2, locationStats.getCountry());
        preparedStatement.setInt(3, locationStats.getLatestTotalCases());
        preparedStatement.setInt(4, locationStats.getDiffFromPrevDay());
    }
}
