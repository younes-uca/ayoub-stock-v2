package ma.zsmart.stocky.dao.facade.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.ChequeEffet;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ChequeEffetDao extends AbstractRepository<ChequeEffet,Long>  {

    List<ChequeEffet> findByBeneficiaireId(Long id);
    int deleteByBeneficiaireId(Long id);
    long countByBeneficiaireId(Long id);


}
