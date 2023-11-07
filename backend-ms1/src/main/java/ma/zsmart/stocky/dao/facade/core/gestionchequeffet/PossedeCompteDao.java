package ma.zsmart.stocky.dao.facade.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.PossedeCompte;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PossedeCompteDao extends AbstractRepository<PossedeCompte,Long>  {

    List<PossedeCompte> findByProprietaireId(Long id);
    int deleteByProprietaireId(Long id);
    long countByProprietaireId(Long id);
    List<PossedeCompte> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);
    long countByBanqueCode(String code);
    List<PossedeCompte> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);


}
