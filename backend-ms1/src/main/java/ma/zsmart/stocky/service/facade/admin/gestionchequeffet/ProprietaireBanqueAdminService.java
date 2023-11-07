package ma.zsmart.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.gestionchequeffet.ProprietaireBanque;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface ProprietaireBanqueAdminService extends  IService<ProprietaireBanque,ProprietaireBanqueCriteria>  {

    List<ProprietaireBanque> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<ProprietaireBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<ProprietaireBanque> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
