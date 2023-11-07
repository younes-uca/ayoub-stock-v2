package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.EtatVente;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.commun.EtatVente;
import java.util.List;


@Repository
public interface EtatVenteDao extends AbstractRepository<EtatVente,Long>  {
    EtatVente findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatVente(item.id,item.libelle) FROM EtatVente item")
    List<EtatVente> findAllOptimized();

}
