package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.EntreeProduitItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EntreeProduitItemDao extends AbstractRepository<EntreeProduitItem,Long>  {

    List<EntreeProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<EntreeProduitItem> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);
    long countByEntreeProduitReference(String reference);


}
