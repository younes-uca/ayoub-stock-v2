package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.SortieProduitItem;
import ma.zsmart.stocky.dao.criteria.core.stock.SortieProduitItemCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.SortieProduitItemDao;
import ma.zsmart.stocky.dao.specification.core.stock.SortieProduitItemSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.SortieProduitItemAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zsmart.stocky.bean.core.stock.Produit ;
import ma.zsmart.stocky.service.facade.admin.entree.SortieProduitAdminService ;
import ma.zsmart.stocky.bean.core.entree.SortieProduit ;

import java.util.List;
@Service
public class SortieProduitItemAdminServiceImpl extends AbstractServiceImpl<SortieProduitItem, SortieProduitItemCriteria, SortieProduitItemDao> implements SortieProduitItemAdminService {






    public List<SortieProduitItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<SortieProduitItem> findBySortieProduitId(Long id){
        return dao.findBySortieProduitId(id);
    }
    public int deleteBySortieProduitId(Long id){
        return dao.deleteBySortieProduitId(id);
    }
    public long countBySortieProduitReference(String reference){
        return dao.countBySortieProduitReference(reference);
    }






    public void configure() {
        super.configure(SortieProduitItem.class, SortieProduitItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private SortieProduitAdminService sortieProduitService ;

    public SortieProduitItemAdminServiceImpl(SortieProduitItemDao dao) {
        super(dao);
    }

}
