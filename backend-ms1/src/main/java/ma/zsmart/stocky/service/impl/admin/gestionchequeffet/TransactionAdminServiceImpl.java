package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.Transaction;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.TransactionDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.TransactionSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.TransactionAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.TypeTransactionAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeTransaction ;
import ma.zsmart.stocky.service.facade.admin.chequeffet.InstrumentAdminService ;
import ma.zsmart.stocky.bean.core.chequeffet.Instrument ;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Compte ;

import java.util.List;
@Service
public class TransactionAdminServiceImpl extends AbstractServiceImpl<Transaction, TransactionCriteria, TransactionDao> implements TransactionAdminService {






    public List<Transaction> findByTypeTransactionId(Long id){
        return dao.findByTypeTransactionId(id);
    }
    public int deleteByTypeTransactionId(Long id){
        return dao.deleteByTypeTransactionId(id);
    }
    public long countByTypeTransactionCode(String code){
        return dao.countByTypeTransactionCode(code);
    }
    public List<Transaction> findByInstrumentId(Long id){
        return dao.findByInstrumentId(id);
    }
    public int deleteByInstrumentId(Long id){
        return dao.deleteByInstrumentId(id);
    }
    public long countByInstrumentId(Long id){
        return dao.countByInstrumentId(id);
    }
    public List<Transaction> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }






    public void configure() {
        super.configure(Transaction.class, TransactionSpecification.class);
    }


    @Autowired
    private TypeTransactionAdminService typeTransactionService ;
    @Autowired
    private InstrumentAdminService instrumentService ;
    @Autowired
    private CompteAdminService compteService ;

    public TransactionAdminServiceImpl(TransactionDao dao) {
        super(dao);
    }

}
