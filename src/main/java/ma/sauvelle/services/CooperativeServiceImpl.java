package ma.sauvelle.services;

import ma.sauvelle.models.Cooperative;
import ma.sauvelle.repository.CooperativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CooperativeServiceImpl implements CooperativeService{

    @Autowired
    CooperativeRepository cooperativeRepository;
    @Override
    public List<Cooperative> findAll() {
        return cooperativeRepository.findAll();
    }

    @Override
    public Cooperative findById(int cooperativeId) {
        return cooperativeRepository.findById(cooperativeId);
    }

    @Override
    public List<Cooperative> searchBySecteur(String secteurNom) {
        return cooperativeRepository.findAllBySecteurNom(secteurNom);
    }
}
