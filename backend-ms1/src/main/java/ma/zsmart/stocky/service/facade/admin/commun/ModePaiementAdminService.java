package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.ModePaiement;
import ma.zsmart.stocky.dao.criteria.core.commun.ModePaiementCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.ModePaiementDto;
import org.springframework.http.HttpEntity;


public interface ModePaiementAdminService extends  IService<ModePaiement,ModePaiementCriteria>  {



    HttpEntity<byte[]> createPdf(ModePaiementDto dto) throws Exception;

}
