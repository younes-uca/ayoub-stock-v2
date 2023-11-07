package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.EntrepriseSociete;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EntrepriseSocieteDao extends AbstractRepository<EntrepriseSociete,Long>  {


    @Query("SELECT NEW EntrepriseSociete(item.id,item.nom) FROM EntrepriseSociete item")
    List<EntrepriseSociete> findAllOptimized();

}
