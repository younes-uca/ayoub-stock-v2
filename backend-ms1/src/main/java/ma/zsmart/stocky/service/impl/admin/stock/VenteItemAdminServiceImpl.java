package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.VenteItem;
import ma.zsmart.stocky.dao.criteria.core.stock.VenteItemCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.VenteItemDao;
import ma.zsmart.stocky.dao.specification.core.stock.VenteItemSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.VenteItemAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.VenteAdminService ;
import ma.zsmart.stocky.bean.core.stock.Vente ;
import ma.zsmart.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zsmart.stocky.bean.core.commun.Depot ;
import ma.zsmart.stocky.service.facade.admin.stock.ProduitAdminService ;
import ma.zsmart.stocky.bean.core.stock.Produit ;

import java.util.List;
@Service
public class VenteItemAdminServiceImpl extends AbstractServiceImpl<VenteItem, VenteItemCriteria, VenteItemDao> implements VenteItemAdminService {






    public List<VenteItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public long countByProduitId(Long id){
        return dao.countByProduitId(id);
    }
    public List<VenteItem> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteId(Long id){
        return dao.countByVenteId(id);
    }
    public List<VenteItem> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }






    public void configure() {
        super.configure(VenteItem.class, VenteItemSpecification.class);
    }


    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private ProduitAdminService produitService ;

    public VenteItemAdminServiceImpl(VenteItemDao dao) {
        super(dao);
    }

}
