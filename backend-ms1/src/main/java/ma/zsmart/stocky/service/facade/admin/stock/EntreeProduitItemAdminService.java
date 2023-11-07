package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.EntreeProduitItem;
import ma.zsmart.stocky.dao.criteria.core.stock.EntreeProduitItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface EntreeProduitItemAdminService extends  IService<EntreeProduitItem,EntreeProduitItemCriteria>  {

    List<EntreeProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<EntreeProduitItem> findByEntreeProduitId(Long id);
    int deleteByEntreeProduitId(Long id);
    long countByEntreeProduitReference(String reference);



}
