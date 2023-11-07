package ma.zsmart.stocky.dao.facade.core.depense;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.depense.Depense;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DepenseDao extends AbstractRepository<Depense,Long>  {



}
