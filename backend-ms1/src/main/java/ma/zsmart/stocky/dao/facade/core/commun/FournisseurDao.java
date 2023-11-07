package ma.zsmart.stocky.dao.facade.core.commun;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.Fournisseur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FournisseurDao extends AbstractRepository<Fournisseur,Long>  {

    List<Fournisseur> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleId(Long id);


}
