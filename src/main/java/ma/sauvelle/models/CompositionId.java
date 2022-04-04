package ma.sauvelle.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CompositionId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "matiere_premiere_id")
    private MatierePremiere matieresPremiere;

    @JsonIgnore
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public MatierePremiere getMatieresPremiere() {
        return matieresPremiere;
    }

    public void setMatieresPremiere(MatierePremiere matieresPremiere) {
        this.matieresPremiere = matieresPremiere;
    }
}
