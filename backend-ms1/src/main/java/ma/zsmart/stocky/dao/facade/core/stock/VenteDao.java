package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.Vente;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VenteDao extends AbstractRepository<Vente,Long>  {

    List<Vente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientId(Long id);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);
    long countByEtatVenteCode(String code);


}
