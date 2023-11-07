package ma.zsmart.stocky.dao.facade.core.commun;

import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.commun.Client;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {



}
