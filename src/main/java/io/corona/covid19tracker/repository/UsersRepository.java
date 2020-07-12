package io.corona.covid19tracker.repository;

import io.corona.covid19tracker.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
