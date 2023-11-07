package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.AvoirVente;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirVenteDao extends AbstractRepository<AvoirVente,Long>  {

    List<AvoirVente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);


}
