package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.Marque;
import ma.zsmart.stocky.dao.criteria.core.commun.MarqueCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.MarqueDao;
import ma.zsmart.stocky.dao.specification.core.commun.MarqueSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.MarqueAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque, MarqueCriteria, MarqueDao> implements MarqueAdminService {





    public Marque findByReferenceEntity(Marque t){
        return  dao.findByCode(t.getCode());
    }


    public List<Marque> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Marque.class, MarqueSpecification.class);
    }



    public MarqueAdminServiceImpl(MarqueDao dao) {
        super(dao);
    }

}
