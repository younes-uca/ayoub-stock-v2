package ma.zsmart.stocky.service.impl.admin.chequeffet;


import ma.zsmart.stocky.bean.core.chequeffet.Instrument;
import ma.zsmart.stocky.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zsmart.stocky.dao.facade.core.chequeffet.InstrumentDao;
import ma.zsmart.stocky.dao.specification.core.chequeffet.InstrumentSpecification;
import ma.zsmart.stocky.service.facade.admin.chequeffet.InstrumentAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.TypeInstrument ;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.ChequeEffetAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.ChequeEffet ;

import java.util.List;
@Service
public class InstrumentAdminServiceImpl extends AbstractServiceImpl<Instrument, InstrumentCriteria, InstrumentDao> implements InstrumentAdminService {






    public List<Instrument> findByTypeInstrumentId(Long id){
        return dao.findByTypeInstrumentId(id);
    }
    public int deleteByTypeInstrumentId(Long id){
        return dao.deleteByTypeInstrumentId(id);
    }
    public long countByTypeInstrumentCode(String code){
        return dao.countByTypeInstrumentCode(code);
    }
    public List<Instrument> findByChequeEffetId(Long id){
        return dao.findByChequeEffetId(id);
    }
    public int deleteByChequeEffetId(Long id){
        return dao.deleteByChequeEffetId(id);
    }
    public long countByChequeEffetId(Long id){
        return dao.countByChequeEffetId(id);
    }






    public void configure() {
        super.configure(Instrument.class, InstrumentSpecification.class);
    }


    @Autowired
    private TypeInstrumentAdminService typeInstrumentService ;
    @Autowired
    private ChequeEffetAdminService chequeEffetService ;

    public InstrumentAdminServiceImpl(InstrumentDao dao) {
        super(dao);
    }

}
