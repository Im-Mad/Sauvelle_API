package ma.sauvelle.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
@Getter
@Setter
public class ProduitDto {
    private String nom;
    private String description;
    private double prix;
    private int uniteId;
    private int categorieId;
    private int cooperativeId;
    private List<CompositionDto> compositions;

}
