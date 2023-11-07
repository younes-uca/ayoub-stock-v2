package ma.zsmart.stocky.service.facade.admin.paiement;

import java.util.List;
import ma.zsmart.stocky.bean.core.paiement.PaiementAchat;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAchatCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.paiement.PaiementAchatDto;
import org.springframework.http.HttpEntity;


public interface PaiementAchatAdminService extends  IService<PaiementAchat,PaiementAchatCriteria>  {

    List<PaiementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<PaiementAchat> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);


    HttpEntity<byte[]> createPdf(PaiementAchatDto dto) throws Exception;

}
