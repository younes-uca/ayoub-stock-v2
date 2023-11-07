package ma.zsmart.stocky.service.facade.admin.chequeffet;

import java.util.List;
import ma.zsmart.stocky.bean.core.chequeffet.Instrument;
import ma.zsmart.stocky.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zsmart.stocky.zynerator.service.IService;



public interface InstrumentAdminService extends  IService<Instrument,InstrumentCriteria>  {

    List<Instrument> findByTypeInstrumentId(Long id);
    int deleteByTypeInstrumentId(Long id);
    long countByTypeInstrumentCode(String code);
    List<Instrument> findByChequeEffetId(Long id);
    int deleteByChequeEffetId(Long id);
    long countByChequeEffetId(Long id);



}
