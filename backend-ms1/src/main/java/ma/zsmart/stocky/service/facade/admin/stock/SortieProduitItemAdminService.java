package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.SortieProduitItem;
import ma.zsmart.stocky.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface SortieProduitItemAdminService extends  IService<SortieProduitItem,SortieProduitItemCriteria>  {

    List<SortieProduitItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<SortieProduitItem> findBySortieProduitId(Long id);
    int deleteBySortieProduitId(Long id);
    long countBySortieProduitReference(String reference);



}
