package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.CommandeItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommandeItemDao extends AbstractRepository<CommandeItem,Long>  {

    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    long countByCommandeId(Long id);


}
