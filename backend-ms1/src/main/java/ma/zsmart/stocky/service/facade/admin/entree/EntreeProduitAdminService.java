package ma.zsmart.stocky.service.facade.admin.entree;

import java.util.List;
import ma.zsmart.stocky.bean.core.entree.EntreeProduit;
import ma.zsmart.stocky.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface EntreeProduitAdminService extends  IService<EntreeProduit,EntreeProduitCriteria>  {

    List<EntreeProduit> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurId(Long id);
    List<EntreeProduit> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);



}
