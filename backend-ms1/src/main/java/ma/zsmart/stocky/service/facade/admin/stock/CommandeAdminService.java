package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.Commande;
import ma.zsmart.stocky.dao.criteria.core.stock.CommandeCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface CommandeAdminService extends  IService<Commande,CommandeCriteria>  {

    List<Commande> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Commande> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurId(Long id);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    long countByEtatCommandeCode(String code);



}
