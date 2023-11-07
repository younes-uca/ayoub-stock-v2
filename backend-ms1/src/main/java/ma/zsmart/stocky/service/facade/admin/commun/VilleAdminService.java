package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.Ville;
import ma.zsmart.stocky.dao.criteria.core.commun.VilleCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.VilleDto;
import org.springframework.http.HttpEntity;


public interface VilleAdminService extends  IService<Ville,VilleCriteria>  {



    HttpEntity<byte[]> createPdf(VilleDto dto) throws Exception;

}
