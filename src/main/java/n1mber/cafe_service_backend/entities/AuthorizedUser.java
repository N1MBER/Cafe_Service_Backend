package n1mber.cafe_service_backend.entities;

public class AuthorizedUser extends User{

    public AuthorizedUser(String login, Roles role, String password) {
        super(login, role, password);
    }
}
