package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.Achat;
import ma.zsmart.stocky.dao.criteria.core.stock.AchatCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.AchatDao;
import ma.zsmart.stocky.dao.specification.core.stock.AchatSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.AchatAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.stocky.service.facade.admin.stock.AchatItemAdminService ;
import ma.zsmart.stocky.bean.core.stock.AchatItem ;
import ma.zsmart.stocky.service.facade.admin.commun.FournisseurAdminService ;
import ma.zsmart.stocky.bean.core.commun.Fournisseur ;
import ma.zsmart.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zsmart.stocky.bean.core.commun.EntrepriseSociete ;
import ma.zsmart.stocky.service.facade.admin.commun.EtatAchatAdminService ;
import ma.zsmart.stocky.bean.core.commun.EtatAchat ;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zsmart.stocky.bean.core.stock.AvoirAchat ;

import java.util.List;
@Service
public class AchatAdminServiceImpl extends AbstractServiceImpl<Achat, AchatCriteria, AchatDao> implements AchatAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Achat create(Achat t) {
        super.create(t);
        if (t.getAchatItems() != null) {
                t.getAchatItems().forEach(element-> {
                    element.setAchat(t);
                    achatItemService.create(element);
            });
        }
        if (t.getAvoirs() != null) {
                t.getAvoirs().forEach(element-> {
                    element.setAchat(t);
                    avoirAchatService.create(element);
            });
        }
        return t;
    }

    public Achat findWithAssociatedLists(Long id){
        Achat result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAchatItems(achatItemService.findByAchatId(id));
            result.setAvoirs(avoirAchatService.findByAchatId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        achatItemService.deleteByAchatId(id);
        avoirAchatService.deleteByAchatId(id);
    }


    public void updateWithAssociatedLists(Achat achat){
    if(achat !=null && achat.getId() != null){
            List<List<AchatItem>> resultAchatItems= achatItemService.getToBeSavedAndToBeDeleted(achatItemService.findByAchatId(achat.getId()),achat.getAchatItems());
            achatItemService.delete(resultAchatItems.get(1));
            ListUtil.emptyIfNull(resultAchatItems.get(0)).forEach(e -> e.setAchat(achat));
            achatItemService.update(resultAchatItems.get(0),true);
            List<List<AvoirAchat>> resultAvoirs= avoirAchatService.getToBeSavedAndToBeDeleted(avoirAchatService.findByAchatId(achat.getId()),achat.getAvoirs());
            avoirAchatService.delete(resultAvoirs.get(1));
            ListUtil.emptyIfNull(resultAvoirs.get(0)).forEach(e -> e.setAchat(achat));
            avoirAchatService.update(resultAvoirs.get(0),true);
    }
    }




    public List<Achat> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Achat> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurId(Long id){
        return dao.countByFournisseurId(id);
    }
    public List<Achat> findByEtatAchatId(Long id){
        return dao.findByEtatAchatId(id);
    }
    public int deleteByEtatAchatId(Long id){
        return dao.deleteByEtatAchatId(id);
    }
    public long countByEtatAchatCode(String code){
        return dao.countByEtatAchatCode(code);
    }






    public void configure() {
        super.configure(Achat.class, AchatSpecification.class);
    }


    @Autowired
    private AchatItemAdminService achatItemService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private EtatAchatAdminService etatAchatService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;

    public AchatAdminServiceImpl(AchatDao dao) {
        super(dao);
    }

}
