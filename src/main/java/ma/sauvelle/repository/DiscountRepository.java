package ma.sauvelle.repository;

import ma.sauvelle.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    Discount findByCode(String code);

}
