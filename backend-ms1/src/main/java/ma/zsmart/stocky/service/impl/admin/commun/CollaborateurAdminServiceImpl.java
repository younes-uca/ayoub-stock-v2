package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.Collaborateur;
import ma.zsmart.stocky.dao.criteria.core.commun.CollaborateurCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.CollaborateurDao;
import ma.zsmart.stocky.dao.specification.core.commun.CollaborateurSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.CollaborateurAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CollaborateurAdminServiceImpl extends AbstractServiceImpl<Collaborateur, CollaborateurCriteria, CollaborateurDao> implements CollaborateurAdminService {







    public List<Collaborateur> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Collaborateur.class, CollaborateurSpecification.class);
    }



    public CollaborateurAdminServiceImpl(CollaborateurDao dao) {
        super(dao);
    }

}
