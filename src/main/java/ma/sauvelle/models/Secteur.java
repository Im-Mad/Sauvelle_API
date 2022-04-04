package ma.sauvelle.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "secteurs")
public class Secteur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secteur secteurs = (Secteur) o;
        return id == secteurs.id && Objects.equals(nom, secteurs.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }
}
