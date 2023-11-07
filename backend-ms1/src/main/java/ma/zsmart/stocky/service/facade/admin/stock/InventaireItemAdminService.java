package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.InventaireItem;
import ma.zsmart.stocky.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface InventaireItemAdminService extends  IService<InventaireItem,InventaireItemCriteria>  {

    List<InventaireItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<InventaireItem> findByInventaireId(Long id);
    int deleteByInventaireId(Long id);
    long countByInventaireReference(String reference);



}
