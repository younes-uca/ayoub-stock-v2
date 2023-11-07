package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.Depot;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.commun.Depot;
import java.util.List;


@Repository
public interface DepotDao extends AbstractRepository<Depot,Long>  {
    Depot findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Depot(item.id,item.libelle) FROM Depot item")
    List<Depot> findAllOptimized();

}
