package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.AvoirAchat;
import ma.zsmart.stocky.dao.criteria.core.stock.AvoirAchatCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface AvoirAchatAdminService extends  IService<AvoirAchat,AvoirAchatCriteria>  {

    List<AvoirAchat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);



}
