package n1mber.cafe_service_backend.entities;

import javax.persistence.*;

@MappedSuperclass
@SuppressWarnings("PWD")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Column(name = "login")
    private String login;
    @Column(name = "user_role")
    private Roles role;
    @Column(name = "password")
    private String password;

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public Roles getRole() { return role; }

    public void setRole(Roles role) { this.role = role; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
