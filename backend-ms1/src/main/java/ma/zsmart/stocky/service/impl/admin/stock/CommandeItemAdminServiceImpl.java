package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.CommandeItem;
import ma.zsmart.stocky.dao.criteria.core.stock.CommandeItemCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.CommandeItemDao;
import ma.zsmart.stocky.dao.specification.core.stock.CommandeItemSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.CommandeItemAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zsmart.stocky.bean.core.stock.Produit ;
import ma.zsmart.stocky.service.facade.admin.stock.CommandeAdminService ;
import ma.zsmart.stocky.bean.core.stock.Commande ;

import java.util.List;
@Service
public class CommandeItemAdminServiceImpl extends AbstractServiceImpl<CommandeItem, CommandeItemCriteria, CommandeItemDao> implements CommandeItemAdminService {






    public List<CommandeItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<CommandeItem> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public long countByCommandeId(Long id){
        return dao.countByCommandeId(id);
    }






    public void configure() {
        super.configure(CommandeItem.class, CommandeItemSpecification.class);
    }


    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private CommandeAdminService commandeService ;

    public CommandeItemAdminServiceImpl(CommandeItemDao dao) {
        super(dao);
    }

}
