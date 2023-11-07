package ma.zsmart.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zsmart.stocky.bean.core.entree.SortieProduit;
import ma.zsmart.stocky.dao.criteria.core.entree.SortieProduitCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface SortieProduitAdminService extends  IService<SortieProduit,SortieProduitCriteria>  {

    List<SortieProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);



}
