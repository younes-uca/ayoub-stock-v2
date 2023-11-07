package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.InventaireItem;
import ma.zsmart.stocky.dao.criteria.core.stock.InventaireItemCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.InventaireItemDao;
import ma.zsmart.stocky.dao.specification.core.stock.InventaireItemSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.InventaireItemAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zsmart.stocky.bean.core.stock.Produit ;
import ma.zsmart.stocky.service.facade.admin.stock.InventaireAdminService ;
import ma.zsmart.stocky.bean.core.stock.Inventaire ;

import java.util.List;
@Service
public class InventaireItemAdminServiceImpl extends AbstractServiceImpl<InventaireItem, InventaireItemCriteria, InventaireItemDao> implements InventaireItemAdminService {






    public List<InventaireItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<InventaireItem> findByInventaireId(Long id){
        return dao.findByInventaireId(id);
    }
    public int deleteByInventaireId(Long id){
        return dao.deleteByInventaireId(id);
    }
    public long countByInventaireReference(String reference){
        return dao.countByInventaireReference(reference);
    }






    public void configure() {
        super.configure(InventaireItem.class, InventaireItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private InventaireAdminService inventaireService ;

    public InventaireItemAdminServiceImpl(InventaireItemDao dao) {
        super(dao);
    }

}
