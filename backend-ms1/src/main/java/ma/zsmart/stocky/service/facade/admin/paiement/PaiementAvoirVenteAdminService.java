package ma.zsmart.stocky.service.facade.admin.paiement;

import java.util.List;
import ma.zsmart.stocky.bean.core.paiement.PaiementAvoirVente;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAvoirVenteCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.paiement.PaiementAvoirVenteDto;
import org.springframework.http.HttpEntity;


public interface PaiementAvoirVenteAdminService extends  IService<PaiementAvoirVente,PaiementAvoirVenteCriteria>  {

    List<PaiementAvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<PaiementAvoirVente> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);
    List<PaiementAvoirVente> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);
    long countByAvoirVenteId(Long id);


    HttpEntity<byte[]> createPdf(PaiementAvoirVenteDto dto) throws Exception;

}
