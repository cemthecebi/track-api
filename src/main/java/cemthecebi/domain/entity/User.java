package cemthecebi.domain.entity;

import cemthecebi.domain.model.enumtype.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Size(min = 4, max = 255, message = "Minimum email length: 4 characters")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    @Column(name = "password")
    private String password;

    @Size(max = 15, message = "Maximum gsmNumber length: 8 characters")
    @Column(name = "gsm_number", unique = true)
    private String gsmNumber;

    @Column(name = "gsm_number_verified", unique = true)
    private Boolean gsmNumberVerified;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}
