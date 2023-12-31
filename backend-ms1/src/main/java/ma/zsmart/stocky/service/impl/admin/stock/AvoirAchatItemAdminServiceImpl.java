package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.AvoirAchatItem;
import ma.zsmart.stocky.dao.criteria.core.stock.AvoirAchatItemCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.AvoirAchatItemDao;
import ma.zsmart.stocky.dao.specification.core.stock.AvoirAchatItemSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirAchatItemAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zsmart.stocky.bean.core.commun.Depot ;
import ma.zsmart.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zsmart.stocky.bean.core.stock.Produit ;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zsmart.stocky.bean.core.stock.AvoirAchat ;

import java.util.List;
@Service
public class AvoirAchatItemAdminServiceImpl extends AbstractServiceImpl<AvoirAchatItem, AvoirAchatItemCriteria, AvoirAchatItemDao> implements AvoirAchatItemAdminService {






    public List<AvoirAchatItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<AvoirAchatItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }
    public List<AvoirAchatItem> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatId(Long id){
        return dao.countByAvoirAchatId(id);
    }






    public void configure() {
        super.configure(AvoirAchatItem.class, AvoirAchatItemSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;

    public AvoirAchatItemAdminServiceImpl(AvoirAchatItemDao dao) {
        super(dao);
    }

}
