package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.EtatCommande;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.commun.EtatCommande;
import java.util.List;


@Repository
public interface EtatCommandeDao extends AbstractRepository<EtatCommande,Long>  {
    EtatCommande findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatCommande(item.id,item.libelle) FROM EtatCommande item")
    List<EtatCommande> findAllOptimized();

}
