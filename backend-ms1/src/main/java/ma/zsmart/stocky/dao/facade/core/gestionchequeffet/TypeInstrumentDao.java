package ma.zsmart.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zsmart.stocky.zynerator.repository.AbstractRepository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeInstrument;
import org.springframework.stereotype.Repository;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeInstrument;
import java.util.List;


@Repository
public interface TypeInstrumentDao extends AbstractRepository<TypeInstrument,Long>  {
    TypeInstrument findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeInstrument(item.id,item.code) FROM TypeInstrument item")
    List<TypeInstrument> findAllOptimized();

}
