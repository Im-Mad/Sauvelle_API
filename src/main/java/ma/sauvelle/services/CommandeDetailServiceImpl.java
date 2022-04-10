package ma.sauvelle.services;

import ma.sauvelle.models.CommandeDetail;
import ma.sauvelle.repository.CommandeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeDetailServiceImpl implements CommandeDetailService{


    @Autowired
    CommandeDetailRepository commandeDetailRepository;

    @Override
    public CommandeDetail save(CommandeDetail commandeDetail) {
        return commandeDetailRepository.save(commandeDetail);
    }
}
