package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.UniteMesure;
import ma.zsmart.stocky.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.UniteMesureDto;
import org.springframework.http.HttpEntity;


public interface UniteMesureAdminService extends  IService<UniteMesure,UniteMesureCriteria>  {



    HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception;

}
