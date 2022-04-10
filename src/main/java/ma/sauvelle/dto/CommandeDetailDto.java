package ma.sauvelle.dto;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDetailDto {
    private int produitId;
    private int quantite;
    private double prixUnite;
}
