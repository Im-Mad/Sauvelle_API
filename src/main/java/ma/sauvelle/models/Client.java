package ma.sauvelle.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = false, length = 25)
    private String nom;
    @Basic
    @Column(name = "adresse", nullable = true, length = 80)
    private String adresse;
    @Basic
    @Column(name = "telephone", nullable = true, length = 20)
    private String telephone;
    @Basic
    @Column(name = "ville", nullable = true, length = 10)
    private String ville;
    @Basic
    @Column(name = "email", nullable = true, length = 30)
    private String email;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_role")
    private Role role;

}
