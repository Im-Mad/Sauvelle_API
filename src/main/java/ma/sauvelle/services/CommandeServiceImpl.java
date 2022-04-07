package ma.sauvelle.services;

import ma.sauvelle.models.Commande;
import ma.sauvelle.models.Status;
import ma.sauvelle.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService{

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> getAllCommandesByStatus(String statusName) {
        Status status = Status.valueOf(statusName);
        if (Arrays.asList(Status.values()).contains(status))
            return commandeRepository.findAllByStatus(status);
        else
            return commandeRepository.findAll();
    }

    @Override
    public Commande getCommande(int commandId) {
        System.out.println(commandeRepository.findById(commandId));
        return commandeRepository.findById(commandId);
    }

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
}
