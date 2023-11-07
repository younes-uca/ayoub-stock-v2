package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeTransaction;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.TypeTransactionCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.TypeTransactionDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.TypeTransactionSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.TypeTransactionAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeTransactionAdminServiceImpl extends AbstractServiceImpl<TypeTransaction, TypeTransactionCriteria, TypeTransactionDao> implements TypeTransactionAdminService {





    public TypeTransaction findByReferenceEntity(TypeTransaction t){
        return  dao.findByCode(t.getCode());
    }


    public List<TypeTransaction> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeTransaction.class, TypeTransactionSpecification.class);
    }



    public TypeTransactionAdminServiceImpl(TypeTransactionDao dao) {
        super(dao);
    }

}
