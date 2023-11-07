package ma.zsmart.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface PermutationItemAdminService extends  IService<PermutationItem,PermutationItemCriteria>  {

    List<PermutationItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<PermutationItem> findByDepotOrigineId(Long id);
    int deleteByDepotOrigineId(Long id);
    long countByDepotOrigineCode(String code);
    List<PermutationItem> findByDepotDestinationId(Long id);
    int deleteByDepotDestinationId(Long id);
    long countByDepotDestinationCode(String code);
    List<PermutationItem> findByPermutationId(Long id);
    int deleteByPermutationId(Long id);
    long countByPermutationId(Long id);



}
