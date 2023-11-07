package ma.zsmart.stocky.service.impl.admin.stock;


import ma.zsmart.stocky.bean.core.stock.Commande;
import ma.zsmart.stocky.dao.criteria.core.stock.CommandeCriteria;
import ma.zsmart.stocky.dao.facade.core.stock.CommandeDao;
import ma.zsmart.stocky.dao.specification.core.stock.CommandeSpecification;
import ma.zsmart.stocky.service.facade.admin.stock.CommandeAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zsmart.stocky.service.facade.admin.commun.EtatCommandeAdminService ;
import ma.zsmart.stocky.bean.core.commun.EtatCommande ;
import ma.zsmart.stocky.service.facade.admin.commun.FournisseurAdminService ;
import ma.zsmart.stocky.bean.core.commun.Fournisseur ;
import ma.zsmart.stocky.service.facade.admin.stock.CommandeItemAdminService ;
import ma.zsmart.stocky.bean.core.stock.CommandeItem ;
import ma.zsmart.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zsmart.stocky.bean.core.commun.EntrepriseSociete ;

import java.util.List;
@Service
public class CommandeAdminServiceImpl extends AbstractServiceImpl<Commande, CommandeCriteria, CommandeDao> implements CommandeAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Commande create(Commande t) {
        super.create(t);
        if (t.getCommandeItems() != null) {
                t.getCommandeItems().forEach(element-> {
                    element.setCommande(t);
                    commandeItemService.create(element);
            });
        }
        return t;
    }

    public Commande findWithAssociatedLists(Long id){
        Commande result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCommandeItems(commandeItemService.findByCommandeId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        commandeItemService.deleteByCommandeId(id);
    }


    public void updateWithAssociatedLists(Commande commande){
    if(commande !=null && commande.getId() != null){
            List<List<CommandeItem>> resultCommandeItems= commandeItemService.getToBeSavedAndToBeDeleted(commandeItemService.findByCommandeId(commande.getId()),commande.getCommandeItems());
            commandeItemService.delete(resultCommandeItems.get(1));
            ListUtil.emptyIfNull(resultCommandeItems.get(0)).forEach(e -> e.setCommande(commande));
            commandeItemService.update(resultCommandeItems.get(0),true);
    }
    }




    public List<Commande> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Commande> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public long countByFournisseurId(Long id){
        return dao.countByFournisseurId(id);
    }
    public List<Commande> findByEtatCommandeId(Long id){
        return dao.findByEtatCommandeId(id);
    }
    public int deleteByEtatCommandeId(Long id){
        return dao.deleteByEtatCommandeId(id);
    }
    public long countByEtatCommandeCode(String code){
        return dao.countByEtatCommandeCode(code);
    }






    public void configure() {
        super.configure(Commande.class, CommandeSpecification.class);
    }


    @Autowired
    private EtatCommandeAdminService etatCommandeService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private CommandeItemAdminService commandeItemService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;

    public CommandeAdminServiceImpl(CommandeDao dao) {
        super(dao);
    }

}
