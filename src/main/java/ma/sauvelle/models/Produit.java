package ma.sauvelle.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "pk.produit", fetch=FetchType.LAZY)
    private List<Composition> compositions = new ArrayList<>();
}
