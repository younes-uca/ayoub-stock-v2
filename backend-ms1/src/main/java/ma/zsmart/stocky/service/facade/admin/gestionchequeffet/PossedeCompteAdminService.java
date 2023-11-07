package ma.zsmart.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.gestionchequeffet.PossedeCompte;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface PossedeCompteAdminService extends  IService<PossedeCompte,PossedeCompteCriteria>  {

    List<PossedeCompte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<PossedeCompte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<PossedeCompte> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
