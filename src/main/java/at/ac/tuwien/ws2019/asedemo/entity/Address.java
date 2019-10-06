package at.ac.tuwien.ws2019.asedemo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="ADDRESS")
@Entity
public class Address implements Serializable {


    private static final long serialVersionUID = 6793835532485034433L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_A_id")
    @SequenceGenerator(name="seq_A_id", sequenceName = "SEQ_ADDRESS_ID", allocationSize=1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "STREET")
    private String street;

    @Column(name = "DOOR")
    private String door;

    @Column(name = "ZIP_CODE")
    private String zipcode;

    @Column(name = "CITY")
    private String city;

    @ManyToOne
    @JoinColumn(name = "USERINFO_ID")
    private UserInfo userInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
