package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FlightRepository extends JpaRepository <Flight , Long> {
    Page<Flight> findAllByStatus(FlightStatus status, PageRequest of);

    List<Flight> getCustomFlight(FlightStatus p1, FlightStatus p2);
}