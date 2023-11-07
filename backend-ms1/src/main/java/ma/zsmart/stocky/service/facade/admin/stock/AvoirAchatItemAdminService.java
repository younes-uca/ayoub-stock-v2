package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.AvoirAchatItem;
import ma.zsmart.stocky.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface AvoirAchatItemAdminService extends  IService<AvoirAchatItem,AvoirAchatItemCriteria>  {

    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<AvoirAchatItem> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatId(Long id);



}
