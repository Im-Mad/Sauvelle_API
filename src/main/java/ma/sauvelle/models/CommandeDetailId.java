package ma.sauvelle.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CommandeDetailId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commandeId) {
        this.commande = commandeId;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

}
