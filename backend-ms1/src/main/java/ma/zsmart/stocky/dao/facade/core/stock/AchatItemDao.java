package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.AchatItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AchatItemDao extends AbstractRepository<AchatItem,Long>  {

    List<AchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AchatItem> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<AchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);


}
