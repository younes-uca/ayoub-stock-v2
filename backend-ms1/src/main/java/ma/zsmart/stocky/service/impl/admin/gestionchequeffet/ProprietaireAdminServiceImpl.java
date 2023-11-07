package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.Proprietaire;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.ProprietaireDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.ProprietaireSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.ProprietaireAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProprietaireAdminServiceImpl extends AbstractServiceImpl<Proprietaire, ProprietaireCriteria, ProprietaireDao> implements ProprietaireAdminService {












    public void configure() {
        super.configure(Proprietaire.class, ProprietaireSpecification.class);
    }



    public ProprietaireAdminServiceImpl(ProprietaireDao dao) {
        super(dao);
    }

}
