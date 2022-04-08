package ma.sauvelle.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CompositionDto {
    private String matierePremiere;
    private long pourcentage;
}
