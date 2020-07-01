package n1mber.cafe_service_backend.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = 'cities')
public class Cities {
    @Id
    private String name;

}
