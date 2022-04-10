package ma.sauvelle.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "commandes_details", schema = "sauvelle")
public class CommandeDetail {

    @EmbeddedId
    private CommandeDetailId pk = new CommandeDetailId();

    @Basic
    @Column(name = "quantite", nullable = true)
    private Integer quantite;

    @Basic
    @Column(name = "prix_unite", nullable = true, precision = 0)
    private Double prixUnite;

    public CommandeDetailId getPk() {
        return pk;
    }

    public void setPk(CommandeDetailId id) {
        this.pk = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixUnite() {
        return prixUnite;
    }

    public void setPrixUnite(Double prixUnite) {
        this.prixUnite = prixUnite;
    }

    @JsonIgnore
    public Commande getCommande() {
        return pk.getCommande();
    }

    public void setCommande(Commande commandeId) {
        pk.setCommande(commandeId);
    }

    public Produit getProduit() {
        return pk.getProduit();
    }

    public void setProduit(Produit produit) {
        pk.setProduit(produit);
    }
}
