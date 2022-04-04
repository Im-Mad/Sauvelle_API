package ma.sauvelle.services;

import ma.sauvelle.models.Cooperative;

import java.util.List;

public interface CooperativeService {
    List<Cooperative> findAll();

    List<Cooperative> searchBySecteur(String secteurNom);


}
