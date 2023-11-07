package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.Depot;
import ma.zsmart.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.DepotDao;
import ma.zsmart.stocky.dao.specification.core.commun.DepotSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.DepotAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class DepotAdminServiceImpl extends AbstractServiceImpl<Depot, DepotCriteria, DepotDao> implements DepotAdminService {





    public Depot findByReferenceEntity(Depot t){
        return  dao.findByCode(t.getCode());
    }


    public List<Depot> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Depot.class, DepotSpecification.class);
    }



    public DepotAdminServiceImpl(DepotDao dao) {
        super(dao);
    }

}
