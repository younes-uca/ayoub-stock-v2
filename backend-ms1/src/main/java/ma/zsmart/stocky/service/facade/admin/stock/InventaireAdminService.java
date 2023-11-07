package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.Inventaire;
import ma.zsmart.stocky.dao.criteria.core.stock.InventaireCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface InventaireAdminService extends  IService<Inventaire,InventaireCriteria>  {

    List<Inventaire> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);



}
