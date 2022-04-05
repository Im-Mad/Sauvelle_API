package ma.sauvelle.services;

import ma.sauvelle.models.Commande;
import ma.sauvelle.models.Status;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

public interface CommandeService {
    List<Commande> getAllCommandes();
    List<Commande> getAllCommandesByStatus(String status);
    Commande getCommande(int commandId);
    Commande createCommande(Commande commande);
}
