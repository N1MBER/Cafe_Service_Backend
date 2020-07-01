package n1mber.cafe_service_backend.entities;

public abstract class User {
    private String login;
    private Roles role;
    private String password;

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public Roles getRole() { return role; }

    public void setRole(Roles role) { this.role = role; }

    public String getPassword() { return password; }

    public User(String login, Roles role, String password) {
        this.login = login;
        this.role = role;
        this.password = password;
    }

    public void setPassword(String password) { this.password = password; }
}
