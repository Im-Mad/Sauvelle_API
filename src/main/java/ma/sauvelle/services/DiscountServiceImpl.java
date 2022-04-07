package ma.sauvelle.services;

import ma.sauvelle.models.Commande;
import ma.sauvelle.models.Discount;
import ma.sauvelle.repository.CommandeRepository;
import ma.sauvelle.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

@Service
public class DiscountServiceImpl implements DiscountService {

    final int CODE_LENGTH = 5;

    @Autowired
    DiscountRepository discountRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public Commande applyDiscount(int commandeId,String code) {
        Discount discount = discountRepository.findByCode(code);
        Commande commande = commandeRepository.findById(commandeId);
        commande.setDiscount(discount);
        return commandeRepository.save(commande);
    }

    @Override
    public Discount createDiscount(double pourcentage) {
        Discount discount = new Discount();
        discount.setCode(generateCode(CODE_LENGTH));
        discount.setPourcentage(pourcentage);

        return discountRepository.save(discount);
    }

    static String generateCode(int length){
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        String code = "";
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            code+= c;
        }
        return code.toUpperCase();
    }
}
