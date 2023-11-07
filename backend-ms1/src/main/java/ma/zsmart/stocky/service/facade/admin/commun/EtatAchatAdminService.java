package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.EtatAchat;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.EtatAchatDto;
import org.springframework.http.HttpEntity;


public interface EtatAchatAdminService extends  IService<EtatAchat,EtatAchatCriteria>  {



    HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception;

}
