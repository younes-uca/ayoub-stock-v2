package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.Categorie;
import ma.zsmart.stocky.dao.criteria.core.commun.CategorieCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.CategorieDao;
import ma.zsmart.stocky.dao.specification.core.commun.CategorieSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.CategorieAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieAdminServiceImpl extends AbstractServiceImpl<Categorie, CategorieCriteria, CategorieDao> implements CategorieAdminService {





    public Categorie findByReferenceEntity(Categorie t){
        return  dao.findByCode(t.getCode());
    }


    public List<Categorie> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Categorie.class, CategorieSpecification.class);
    }



    public CategorieAdminServiceImpl(CategorieDao dao) {
        super(dao);
    }

}
