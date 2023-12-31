package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.EtatVente;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.EtatVenteDto;
import org.springframework.http.HttpEntity;


public interface EtatVenteAdminService extends  IService<EtatVente,EtatVenteCriteria>  {



    HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception;

}
