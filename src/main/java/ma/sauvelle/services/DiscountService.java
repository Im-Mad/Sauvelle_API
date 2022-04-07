package ma.sauvelle.services;

import ma.sauvelle.models.Commande;
import ma.sauvelle.models.Discount;

public interface DiscountService {
    Commande applyDiscount(int commandeId, String code);
    Discount createDiscount(double pourcentage);
}
