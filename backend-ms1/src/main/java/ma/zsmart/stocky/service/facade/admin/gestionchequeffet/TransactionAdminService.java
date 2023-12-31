package ma.zsmart.stocky.service.facade.admin.gestionchequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Transaction;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.TransactionCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface TransactionAdminService extends  IService<Transaction,TransactionCriteria>  {

    List<Transaction> findByTypeTransactionId(Long id);
    int deleteByTypeTransactionId(Long id);
    long countByTypeTransactionCode(String code);
    List<Transaction> findByInstrumentId(Long id);
    int deleteByInstrumentId(Long id);
    long countByInstrumentId(Long id);
    List<Transaction> findByCompteId(Long id);
    int deleteByCompteId(Long id);
    long countByCompteId(Long id);



}
