package ma.zsmart.stocky.service.facade.admin.paiement;

import java.util.List;
import ma.zsmart.stocky.bean.core.paiement.PaiementVente;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementVenteCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.paiement.PaiementVenteDto;
import org.springframework.http.HttpEntity;


public interface PaiementVenteAdminService extends  IService<PaiementVente,PaiementVenteCriteria>  {

    List<PaiementVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    long countByVenteId(Long id);
    List<PaiementVente> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    long countByModePaiementCode(String code);


    HttpEntity<byte[]> createPdf(PaiementVenteDto dto) throws Exception;

}
