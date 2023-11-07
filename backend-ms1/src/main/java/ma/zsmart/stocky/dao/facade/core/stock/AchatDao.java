package ma.zsmart.stocky.dao.facade.core.stock;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.stock.Achat;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AchatDao extends AbstractRepository<Achat,Long>  {

    List<Achat> findByEntrepriseSocieteId(Long id);
    int deleteByEntrepriseSocieteId(Long id);
    long countByEntrepriseSocieteId(Long id);
    List<Achat> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);
    long countByFournisseurId(Long id);
    List<Achat> findByEtatAchatId(Long id);
    int deleteByEtatAchatId(Long id);
    long countByEtatAchatCode(String code);


}
