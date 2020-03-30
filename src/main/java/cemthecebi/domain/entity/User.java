package cemthecebi.domain.entity;

import cemthecebi.domain.model.enumtype.Role;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
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

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "emil", unique = true, nullable = false)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGsmNumber() {
        return gsmNumber;
    }

    public void setGsmNumber(String gsmNumber) {
        this.gsmNumber = gsmNumber;
    }

    public Boolean getGsmNumberVerified() {
        return gsmNumberVerified;
    }

    public void setGsmNumberVerified(Boolean gsmNumberVerified) {
        this.gsmNumberVerified = gsmNumberVerified;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
