package ma.sauvelle.dto;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto {
    private String status;
    private String discount;
    private List<CommandeDetailDto> commandeDetails = new ArrayList<>();
}
