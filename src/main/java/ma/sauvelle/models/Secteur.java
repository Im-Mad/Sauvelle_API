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
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secteur secteurs = (Secteur) o;
        return id == secteurs.id && Objects.equals(name, secteurs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
