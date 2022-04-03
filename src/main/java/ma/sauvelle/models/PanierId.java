package ma.sauvelle.models;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PanierId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "client_id", table = "paniers")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "produit_id", table = "paniers")
    private Produit produit;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
