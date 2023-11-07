package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.ModePaiement;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.commun.ModePaiement;
import java.util.List;


@Repository
public interface ModePaiementDao extends AbstractRepository<ModePaiement,Long>  {
    ModePaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ModePaiement(item.id,item.libelle) FROM ModePaiement item")
    List<ModePaiement> findAllOptimized();

}
