package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.AvoirVente;
import ma.zsmart.stocky.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface AvoirVenteAdminService extends  IService<AvoirVente,AvoirVenteCriteria>  {

    List<AvoirVente> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);



}
