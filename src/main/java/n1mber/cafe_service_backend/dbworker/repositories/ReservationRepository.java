package n1mber.cafe_service_backend.dbworker.repositories;

import n1mber.cafe_service_backend.entities.Cities;
import n1mber.cafe_service_backend.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Collection findReservations(Cities cities);
}
