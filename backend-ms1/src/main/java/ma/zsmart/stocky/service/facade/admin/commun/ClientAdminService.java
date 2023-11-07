package ma.zsmart.stocky.service.facade.admin.commun;

import java.util.List;
import ma.zsmart.stocky.bean.core.commun.Client;
import ma.zsmart.stocky.dao.criteria.core.commun.ClientCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;


public interface ClientAdminService extends  IService<Client,ClientCriteria>  {



    HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception;

}
