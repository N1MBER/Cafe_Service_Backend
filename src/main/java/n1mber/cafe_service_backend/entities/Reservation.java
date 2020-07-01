package n1mber.cafe_service_backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = 'reservation')
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Cities cities;
    private String reservation_name;
    private String reservation_phone;
    private String reservation_wishes;
    private Date reservation_date;
}
