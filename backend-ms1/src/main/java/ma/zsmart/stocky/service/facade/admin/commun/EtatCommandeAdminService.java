package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.EtatCommande;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.EtatCommandeDto;
import org.springframework.http.HttpEntity;


public interface EtatCommandeAdminService extends  IService<EtatCommande,EtatCommandeCriteria>  {



    HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception;

}
