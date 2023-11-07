package ma.zsmart.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Banque;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Banque;
import java.util.List;


@Repository
public interface BanqueDao extends AbstractRepository<Banque,Long>  {
    Banque findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Banque(item.id,item.libelle) FROM Banque item")
    List<Banque> findAllOptimized();

}
