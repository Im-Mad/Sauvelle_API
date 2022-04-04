package ma.sauvelle.models;

import javax.persistence.*;

@Entity
@Table(name = "paniers")
public class Panier {

    @EmbeddedId
    private PanierId pk;

    @Basic
    @Column(name = "quantite", nullable = true)
    private Integer quantite;

    public PanierId getPk() {
        return pk;
    }


    public void setPk(PanierId pk) {
        this.pk = pk;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Client getClient() {
        return pk.getClient();
    }

    public void setClient(Client client) {
        pk.setClient(client);
    }

    public Produit getProduit() {
        return pk.getProduit();
    }

    public void setProduit(Produit produit) {
        pk.setProduit(produit);
    }
}
