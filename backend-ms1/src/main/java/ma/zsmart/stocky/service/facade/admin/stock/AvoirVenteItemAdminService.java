package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.AvoirVenteItem;
import ma.zsmart.stocky.dao.criteria.core.stock.AvoirVenteItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface AvoirVenteItemAdminService extends  IService<AvoirVenteItem,AvoirVenteItemCriteria>  {

    List<AvoirVenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AvoirVenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<AvoirVenteItem> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteId(Long id);



}
