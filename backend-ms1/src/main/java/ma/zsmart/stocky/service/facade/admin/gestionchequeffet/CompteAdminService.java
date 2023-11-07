package ma.zsmart.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Compte;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface CompteAdminService extends  IService<Compte,CompteCriteria>  {

    List<Compte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<Compte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);



}
