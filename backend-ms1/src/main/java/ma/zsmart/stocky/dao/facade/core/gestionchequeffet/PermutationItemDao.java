package ma.zsmart.stocky.dao.facade.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.PermutationItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PermutationItemDao extends AbstractRepository<PermutationItem,Long>  {

    List<PermutationItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<PermutationItem> findByDepotOrigineId(Long id);
    int deleteByDepotOrigineId(Long id);
    long countByDepotOrigineCode(String code);
    List<PermutationItem> findByDepotDestinationId(Long id);
    int deleteByDepotDestinationId(Long id);
    long countByDepotDestinationCode(String code);
    List<PermutationItem> findByPermutationId(Long id);
    int deleteByPermutationId(Long id);
    long countByPermutationId(Long id);


}
