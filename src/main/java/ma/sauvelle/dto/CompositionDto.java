package ma.sauvelle.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CompositionDto {
    private int matierePremiereId;
    private long pourcentage;
}
