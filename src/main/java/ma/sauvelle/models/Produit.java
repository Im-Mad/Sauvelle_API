package ma.sauvelle.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produits")
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = false, length = 25)
    private String nom;
    @Basic
    @Column(name = "description", nullable = false, length = 500)
    private String description;
    @Basic
    @Column(name = "prix", nullable = false, precision = 0)
    private double prix;
    @ManyToOne
    @JoinColumn(name = "unite_id", nullable = false)
    private Unite unite;
    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "cooperative_id", nullable = false)
    private Cooperative cooperative;
    @ManyToMany
    @JoinTable(
            name = "compositions",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_premiere_id")
    )
    private List<MatierePremiere> matieresPremieres;

    @OneToMany(mappedBy = "pk.commande")
    private Set<CommandeDetail> commandeDetails = new HashSet<>();

    public Set<CommandeDetail> getCommandeDetails() {
        return commandeDetails;
    }

    public void setCommandeDetails(Set<CommandeDetail> commandeDetails) {
        this.commandeDetails = commandeDetails;
    }


    public List<MatierePremiere> getMatieresPremieres() {
        return matieresPremieres;
    }

    public void setMatieresPremieres(List<MatierePremiere> matieresPremieres) {
        this.matieresPremieres = matieresPremieres;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Cooperative getCooperative() {
        return cooperative;
    }

    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }
}
