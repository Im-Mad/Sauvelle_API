package ma.sauvelle.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "commandes")
public class Commande {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Basic
    @Column(name = "date", nullable = true)
    private Timestamp date;
    @Basic
    @Column(name = "montant", nullable = false, precision = 0)
    private double montant;
    @Basic
    @Column(name = "status", nullable = true)
    private Status status;

    @OneToMany(mappedBy = "pk.commande")
    private Set<CommandeDetail> commandeDetails = new HashSet<>();

    public Set<CommandeDetail> getCommandeDetails() {
        return commandeDetails;
    }

    public void setCommandeDetails(Set<CommandeDetail> commandeDetails) {
        this.commandeDetails = commandeDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }




}
