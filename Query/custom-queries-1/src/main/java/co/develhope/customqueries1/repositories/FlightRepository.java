package co.develhope.customqueries1.repositories;

import co.develhope.customqueries1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestResource
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
