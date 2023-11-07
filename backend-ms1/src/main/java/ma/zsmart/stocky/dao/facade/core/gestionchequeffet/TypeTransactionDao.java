package ma.zsmart.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeTransaction;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeTransaction;
import java.util.List;


@Repository
public interface TypeTransactionDao extends AbstractRepository<TypeTransaction,Long>  {
    TypeTransaction findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeTransaction(item.id,item.libelle) FROM TypeTransaction item")
    List<TypeTransaction> findAllOptimized();

}
