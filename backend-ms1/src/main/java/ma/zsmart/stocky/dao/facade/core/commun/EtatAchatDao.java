package ma.zsmart.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.EtatAchat;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.commun.EtatAchat;
import java.util.List;


@Repository
public interface EtatAchatDao extends AbstractRepository<EtatAchat,Long>  {
    EtatAchat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatAchat(item.id,item.libelle) FROM EtatAchat item")
    List<EtatAchat> findAllOptimized();

}
