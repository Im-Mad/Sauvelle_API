package ma.sauvelle.services;

import ma.sauvelle.models.Cooperative;

import java.util.List;

public interface CooperativeService {
    List<Cooperative> findAll();
    Cooperative findById(int cooperativeId);
    List<Cooperative> searchBySecteur(String secteurNom);


}
