package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.Stock;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StockDao extends AbstractRepository<Stock,Long>  {

    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<Stock> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);


}
