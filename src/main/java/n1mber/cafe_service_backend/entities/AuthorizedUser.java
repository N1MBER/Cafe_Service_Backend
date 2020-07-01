package n1mber.cafe_service_backend.entities;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "authorized_user")
public class AuthorizedUser extends User{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = 'id')
    private Long ID;
    @Column(name = 'name')
    private String name;
    @Column(name = "reservation_notification")
    private boolean reservation_notification;
    @Column(name = "new_position_notification")
    private boolean new_position_notification;
    @Column(name = 'has_res')
    private boolean reservation;
    @Column(name = "phone_number")
    private String phone_number;

    public AuthorizedUser() {}

    public Long getID() { return ID; }

    public void setID(Long ID) { this.ID = ID; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isReservation_notification() { return reservation_notification; }

    public void setReservation_notification(boolean reservation_notification) { this.reservation_notification = reservation_notification; }

    public boolean isNew_position_notification() { return new_position_notification; }

    public void setNew_position_notification(boolean new_position_notification) { this.new_position_notification = new_position_notification; }

    public boolean isReservation() { return reservation; }

    public void setReservation(boolean reservation) { this.reservation = reservation; }

    public String getPhone_number() { return phone_number; }

    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }
}
