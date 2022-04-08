package ma.sauvelle.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "compositions")
public class Composition {

    @JsonIgnore
    @EmbeddedId
    private CompositionId pk;

    @Basic
    @Column(name = "pourcentage", nullable = false, precision = 0)
    private double pourcentage;

    public CompositionId getPk() {
        return pk;
    }

    public void setPk(CompositionId compositionId) {
        this.pk = compositionId;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    @JsonIgnore
    public Produit getProduit() {
        return pk.getProduit();
    }

    public void setProduit(Produit produit) {
        pk.setProduit(produit);
    }

    public MatierePremiere getMatieresPremiere() {
        return pk.getMatieresPremiere();
    }

    public void setMatieresPremiere(MatierePremiere matieresPremiere) {
        pk.setMatieresPremiere(matieresPremiere);
    }
}
