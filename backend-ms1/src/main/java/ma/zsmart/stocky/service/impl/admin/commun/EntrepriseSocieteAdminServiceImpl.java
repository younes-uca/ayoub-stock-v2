package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.EntrepriseSociete;
import ma.zsmart.stocky.dao.criteria.core.commun.EntrepriseSocieteCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.EntrepriseSocieteDao;
import ma.zsmart.stocky.dao.specification.core.commun.EntrepriseSocieteSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EntrepriseSocieteAdminServiceImpl extends AbstractServiceImpl<EntrepriseSociete, EntrepriseSocieteCriteria, EntrepriseSocieteDao> implements EntrepriseSocieteAdminService {







    public List<EntrepriseSociete> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(EntrepriseSociete.class, EntrepriseSocieteSpecification.class);
    }



    public EntrepriseSocieteAdminServiceImpl(EntrepriseSocieteDao dao) {
        super(dao);
    }

}
