package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.AchatItem;
import ma.zsmart.stocky.dao.criteria.core.stock.AchatItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface AchatItemAdminService extends  IService<AchatItem,AchatItemCriteria>  {

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
