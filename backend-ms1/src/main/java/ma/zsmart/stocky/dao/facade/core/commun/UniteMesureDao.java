package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.UniteMesure;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.commun.UniteMesure;
import java.util.List;


@Repository
public interface UniteMesureDao extends AbstractRepository<UniteMesure,Long>  {
    UniteMesure findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW UniteMesure(item.id,item.libelle) FROM UniteMesure item")
    List<UniteMesure> findAllOptimized();

}
