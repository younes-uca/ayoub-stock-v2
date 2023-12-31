package ma.zsmart.stocky.service.impl.admin.entree;


import ma.zsmart.stocky.bean.core.entree.EntreeProduit;
import ma.zsmart.stocky.dao.criteria.core.entree.EntreeProduitCriteria;
import ma.zsmart.stocky.dao.facade.core.entree.EntreeProduitDao;
import ma.zsmart.stocky.dao.specification.core.entree.EntreeProduitSpecification;
import ma.zsmart.stocky.service.facade.admin.entree.EntreeProduitAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.stocky.service.facade.admin.commun.DepotAdminService ;
import ma.zsmart.stocky.bean.core.commun.Depot ;
import ma.zsmart.stocky.service.facade.admin.commun.FournisseurAdminService ;
import ma.zsmart.stocky.bean.core.commun.Fournisseur ;
import ma.zsmart.stocky.service.facade.admin.stock.EntreeProduitItemAdminService ;
import ma.zsmart.stocky.bean.core.stock.EntreeProduitItem ;

import java.util.List;
@Service
public class EntreeProduitAdminServiceImpl extends AbstractServiceImpl<EntreeProduit, EntreeProduitCriteria, EntreeProduitDao> implements EntreeProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public EntreeProduit create(EntreeProduit t) {
        super.create(t);
        if (t.getEntreeProduitItems() != null) {
                t.getEntreeProduitItems().forEach(element-> {
                    element.setEntreeProduit(t);
                    entreeProduitItemService.create(element);
            });
        }
        return t;
    }

    public EntreeProduit findWithAssociatedLists(Long id){
        EntreeProduit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setEntreeProduitItems(entreeProduitItemService.findByEntreeProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        entreeProduitItemService.deleteByEntreeProduitId(id);
    }


    public void updateWithAssociatedLists(EntreeProduit entreeProduit){
    if(entreeProduit !=null && entreeProduit.getId() != null){
            List<List<EntreeProduitItem>> resultEntreeProduitItems= entreeProduitItemService.getToBeSavedAndToBeDeleted(entreeProduitItemService.findByEntreeProduitId(entreeProduit.getId()),entreeProduit.getEntreeProduitItems());
            entreeProduitItemService.delete(resultEntreeProduitItems.get(1));
            ListUtil.emptyIfNull(resultEntreeProduitItems.get(0)).forEach(e -> e.setEntreeProduit(entreeProduit));
            entreeProduitItemService.update(resultEntreeProduitItems.get(0),true);
    }
    }



    public EntreeProduit findByReferenceEntity(EntreeProduit t){
        return  dao.findByReference(t.getReference());
    }

    public List<EntreeProduit> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurId(Long id){
        return dao.countByFournisseurId(id);
    }
    public List<EntreeProduit> findByDepotId(Long id){
        return dao.findByDepotId(id);
    }
    public int deleteByDepotId(Long id){
        return dao.deleteByDepotId(id);
    }
    public long countByDepotCode(String code){
        return dao.countByDepotCode(code);
    }

    public List<EntreeProduit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EntreeProduit.class, EntreeProduitSpecification.class);
    }


    @Autowired
    private DepotAdminService depotService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private EntreeProduitItemAdminService entreeProduitItemService ;

    public EntreeProduitAdminServiceImpl(EntreeProduitDao dao) {
        super(dao);
    }

}
