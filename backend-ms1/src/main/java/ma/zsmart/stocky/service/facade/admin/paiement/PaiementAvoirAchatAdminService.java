package ma.zsmart.stocky.service.facade.admin.paiement;

import java.util.List;
import ma.zsmart.stocky.bean.core.paiement.PaiementAvoirAchat;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAvoirAchatCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.paiement.PaiementAvoirAchatDto;
import org.springframework.http.HttpEntity;


public interface PaiementAvoirAchatAdminService extends  IService<PaiementAvoirAchat,PaiementAvoirAchatCriteria>  {

    List<PaiementAvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    long countByAchatId(Long id);
    List<PaiementAvoirAchat> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);
    List<PaiementAvoirAchat> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);
    long countByAvoirAchatId(Long id);


    HttpEntity<byte[]> createPdf(PaiementAvoirAchatDto dto) throws Exception;

}
