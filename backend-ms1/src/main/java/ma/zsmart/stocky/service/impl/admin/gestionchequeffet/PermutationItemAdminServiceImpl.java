package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.PermutationItemDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.PermutationItemSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.PermutationItemAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.PermutationAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Permutation ;
import ma.zsmart.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zsmart.stocky.bean.core.commun.Depot ;
import ma.zsmart.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zsmart.stocky.bean.core.stock.Produit ;

import java.util.List;
@Service
public class PermutationItemAdminServiceImpl extends AbstractServiceImpl<PermutationItem, PermutationItemCriteria, PermutationItemDao> implements PermutationItemAdminService {






    public List<PermutationItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<PermutationItem> findByDepotOrigineId(Long id){
        return dao.findByDepotOrigineId(id);
    }
    public int deleteByDepotOrigineId(Long id){
        return dao.deleteByDepotOrigineId(id);
    }
    public long countByDepotOrigineCode(String code){
        return dao.countByDepotOrigineCode(code);
    }
    public List<PermutationItem> findByDepotDestinationId(Long id){
        return dao.findByDepotDestinationId(id);
    }
    public int deleteByDepotDestinationId(Long id){
        return dao.deleteByDepotDestinationId(id);
    }
    public long countByDepotDestinationCode(String code){
        return dao.countByDepotDestinationCode(code);
    }
    public List<PermutationItem> findByPermutationId(Long id){
        return dao.findByPermutationId(id);
    }
    public int deleteByPermutationId(Long id){
        return dao.deleteByPermutationId(id);
    }
    public long countByPermutationId(Long id){
        return dao.countByPermutationId(id);
    }






    public void configure() {
        super.configure(PermutationItem.class, PermutationItemSpecification.class);
    }


    @Autowired
    private PermutationAdminService permutationService ;
    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;

    public PermutationItemAdminServiceImpl(PermutationItemDao dao) {
        super(dao);
    }

}
