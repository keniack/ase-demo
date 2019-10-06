package at.ac.tuwien.ws2019.asedemo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Table(name="USERINFO")
@Entity
public class UserInfo implements Serializable {


    private static final long serialVersionUID = 3524738228656619788L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_U_id")
    @SequenceGenerator(name="seq_U_id", sequenceName = "SEQ_USERINFO_ID", allocationSize=1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    @OneToMany(
            mappedBy = "userInfo",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Address> addresses;

    public UserInfo(){}
    public UserInfo(Integer id){
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
