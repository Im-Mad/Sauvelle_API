package ma.sauvelle.repository;

import ma.sauvelle.models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepository extends JpaRepository<Unite, Integer> {
    Unite findById(int id);
}
