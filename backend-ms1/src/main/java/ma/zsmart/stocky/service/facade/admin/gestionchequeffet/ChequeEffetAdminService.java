package ma.zsmart.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.gestionchequeffet.ChequeEffet;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface ChequeEffetAdminService extends  IService<ChequeEffet,ChequeEffetCriteria>  {

    List<ChequeEffet> findByBeneficiaireId(Long id);
    int deleteByBeneficiaireId(Long id);
    long countByBeneficiaireId(Long id);



}
