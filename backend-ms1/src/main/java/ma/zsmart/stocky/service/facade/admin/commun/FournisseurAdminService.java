package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.Fournisseur;
import ma.zsmart.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;


public interface FournisseurAdminService extends  IService<Fournisseur,FournisseurCriteria>  {

    List<Fournisseur> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleId(Long id);


    HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception;

}
