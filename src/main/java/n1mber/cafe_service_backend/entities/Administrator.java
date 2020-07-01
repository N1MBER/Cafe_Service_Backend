package n1mber.cafe_service_backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "administrators")
public class Administrator extends User{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Cities cities;

    public Administrator() {}
}
