package n1mber.cafe_service_backend.dbworker.repositories;

import n1mber.cafe_service_backend.entities.AuthorizedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<AuthorizedUser, Long> {
    Collection<AuthorizedUser> getUsers();
    AuthorizedUser findAuthorizedUserByLogin(String login);
}
