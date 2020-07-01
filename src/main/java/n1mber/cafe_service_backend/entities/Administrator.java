package n1mber.cafe_service_backend.entities;

public class Administrator extends User{

    public Administrator(String login, Roles role, String password) {
        super(login, role, password);
    }
}
