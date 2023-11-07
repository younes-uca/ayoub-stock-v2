package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.Commande;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommandeDao extends AbstractRepository<Commande,Long>  {

    List<Commande> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Commande> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurId(Long id);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeCode(String code);


}
