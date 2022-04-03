package ma.sauvelle.models;

import javax.persistence.*;

@Entity
@Table(name = "cooperatives")
public class Cooperative {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "nom", nullable = true, length = 500)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "secteur_id", nullable = false)
    private Secteur secteur;

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

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
