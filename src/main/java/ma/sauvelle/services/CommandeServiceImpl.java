package ma.sauvelle.services;

import ma.sauvelle.dto.CommandeDto;
import ma.sauvelle.models.Commande;
import ma.sauvelle.models.CommandeDetail;
import ma.sauvelle.models.Status;
import ma.sauvelle.services.CommandeDetailService;
import ma.sauvelle.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

@Service
public class CommandeServiceImpl implements CommandeService{

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    DiscountService discountService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    ClientService clientService;

    @Autowired
    CommandeDetailService commandeDetailService;

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
    @Transactional
    public Commande createCommande(CommandeDto commandeDto, String username) {

        Commande commande = new Commande();
        commande.setClient(clientService.findClientByUsername(username));
        commande.setDate(new Timestamp(new Date().getTime()));
        commande.setDiscount(discountService.getDiscount(commandeDto.getDiscount()));
        commande.setStatus(Status.valueOf(Status.class, commandeDto.getStatus()));
        Set<CommandeDetail> commadeDetails = new HashSet<>();
        commandeDto.getCommandeDetails().stream().forEach(cd -> {
            System.out.println(cd);
            CommandeDetail commandeDetail = new CommandeDetail();
            commandeDetail.setProduit(produitService.findById(cd.getProduitId()));
            commandeDetail.setPrixUnite(cd.getPrixUnite());
            commandeDetail.setQuantite(cd.getQuantite());
            commadeDetails.add(commandeDetail);


        });
        commande.setCommandeDetails(commadeDetails);
        System.out.println(commande);
        Commande savedCommande = commandeRepository.save(commande);
        commande.getCommandeDetails().stream().forEach(commandeDetail ->{
            commandeDetail.setCommande(savedCommande);
            commandeDetailService.save(commandeDetail);
        });

        return savedCommande;
    }
}
