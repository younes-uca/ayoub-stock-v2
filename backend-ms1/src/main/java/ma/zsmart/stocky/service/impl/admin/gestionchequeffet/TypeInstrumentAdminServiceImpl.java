package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeInstrument;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.TypeInstrumentDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.TypeInstrumentSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeInstrumentAdminServiceImpl extends AbstractServiceImpl<TypeInstrument, TypeInstrumentCriteria, TypeInstrumentDao> implements TypeInstrumentAdminService {





    public TypeInstrument findByReferenceEntity(TypeInstrument t){
        return  dao.findByCode(t.getCode());
    }


    public List<TypeInstrument> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeInstrument.class, TypeInstrumentSpecification.class);
    }



    public TypeInstrumentAdminServiceImpl(TypeInstrumentDao dao) {
        super(dao);
    }

}
