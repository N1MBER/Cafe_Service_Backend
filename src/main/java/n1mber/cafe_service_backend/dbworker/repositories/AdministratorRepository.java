package n1mber.cafe_service_backend.dbworker.repositories;

import n1mber.cafe_service_backend.entities.Administrator;
import n1mber.cafe_service_backend.entities.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findAdministratorById(Long id);
    Administrator findAdministratorsByLogin(String login);
    Administrator findAdministratorByCities(Cities city);
}
