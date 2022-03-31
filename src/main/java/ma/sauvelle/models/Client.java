package ma.sauvelle.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client clients = (Client) o;
        return id == clients.id && Objects.equals(nom, clients.nom) && Objects.equals(adresse, clients.adresse) && Objects.equals(telephone, clients.telephone) && Objects.equals(ville, clients.ville) && Objects.equals(email, clients.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, adresse, telephone, ville, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", ville='" + ville + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
