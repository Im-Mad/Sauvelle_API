package ma.sauvelle.repository;

import ma.sauvelle.models.CommandeDetail;
import ma.sauvelle.models.CommandeDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDetailRepository extends JpaRepository<CommandeDetail, CommandeDetailId> {

}
