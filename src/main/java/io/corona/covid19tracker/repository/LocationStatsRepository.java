package io.corona.covid19tracker.repository;

import io.corona.covid19tracker.models.LocationStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationStatsRepository extends JpaRepository<LocationStats, Integer> {
}
