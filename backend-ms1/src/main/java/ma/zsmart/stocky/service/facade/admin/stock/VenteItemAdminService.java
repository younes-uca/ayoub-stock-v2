package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.VenteItem;
import ma.zsmart.stocky.dao.criteria.core.stock.VenteItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface VenteItemAdminService extends  IService<VenteItem,VenteItemCriteria>  {

    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<VenteItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);



}
