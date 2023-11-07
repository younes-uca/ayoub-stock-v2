package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.AvoirAchat;
import ma.zsmart.stocky.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.AvoirAchatDao;
import ma.zsmart.stocky.dao.specification.core.stock.AvoirAchatSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirAchatAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.stocky.service.facade.admin.stock.AchatAdminService ;
import ma.zsmart.stocky.bean.core.stock.Achat ;
import ma.zsmart.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zsmart.stocky.bean.core.commun.EntrepriseSociete ;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirAchatItemAdminService ;
import ma.zsmart.stocky.bean.core.stock.AvoirAchatItem ;

import java.util.List;
@Service
public class AvoirAchatAdminServiceImpl extends AbstractServiceImpl<AvoirAchat, AvoirAchatCriteria, AvoirAchatDao> implements AvoirAchatAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AvoirAchat create(AvoirAchat t) {
        super.create(t);
        if (t.getAvoirAchatItems() != null) {
                t.getAvoirAchatItems().forEach(element-> {
                    element.setAvoirAchat(t);
                    avoirAchatItemService.create(element);
            });
        }
        return t;
    }

    public AvoirAchat findWithAssociatedLists(Long id){
        AvoirAchat result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAvoirAchatItems(avoirAchatItemService.findByAvoirAchatId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        avoirAchatItemService.deleteByAvoirAchatId(id);
    }


    public void updateWithAssociatedLists(AvoirAchat avoirAchat){
    if(avoirAchat !=null && avoirAchat.getId() != null){
            List<List<AvoirAchatItem>> resultAvoirAchatItems= avoirAchatItemService.getToBeSavedAndToBeDeleted(avoirAchatItemService.findByAvoirAchatId(avoirAchat.getId()),avoirAchat.getAvoirAchatItems());
            avoirAchatItemService.delete(resultAvoirAchatItems.get(1));
            ListUtil.emptyIfNull(resultAvoirAchatItems.get(0)).forEach(e -> e.setAvoirAchat(avoirAchat));
            avoirAchatItemService.update(resultAvoirAchatItems.get(0),true);
    }
    }




    public List<AvoirAchat> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<AvoirAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }






    public void configure() {
        super.configure(AvoirAchat.class, AvoirAchatSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private AvoirAchatItemAdminService avoirAchatItemService ;

    public AvoirAchatAdminServiceImpl(AvoirAchatDao dao) {
        super(dao);
    }

}
