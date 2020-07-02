package n1mber.cafe_service_backend.dbworker.repositories;

import n1mber.cafe_service_backend.entities.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CityRepository extends JpaRepository<Cities, Long> {
    Cities getCity(String name);
    Collection<Cities> getCities();
}
