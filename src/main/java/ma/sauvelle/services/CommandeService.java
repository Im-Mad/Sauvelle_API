package ma.sauvelle.services;

import ma.sauvelle.dto.CommandeDto;
import ma.sauvelle.models.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> getAllCommandes();
    List<Commande> getAllCommandesByStatus(String status);
    Commande getCommande(int commandId);
    Commande createCommande(CommandeDto commande);
}
