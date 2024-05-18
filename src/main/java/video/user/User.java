package video.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;



@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String status;
}
