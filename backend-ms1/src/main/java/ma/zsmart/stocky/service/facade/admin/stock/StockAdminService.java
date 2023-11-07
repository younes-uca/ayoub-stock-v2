package ma.zsmart.stocky.service.facade.admin.stock;

import java.util.List;
import ma.zsmart.stocky.bean.core.stock.Stock;
import ma.zsmart.stocky.dao.criteria.core.stock.StockCriteria;
import ma.zsmart.stocky.zynerator.service.IService;

import ma.zsmart.stocky.ws.dto.stock.StockDto;
import org.springframework.http.HttpEntity;


public interface StockAdminService extends  IService<Stock,StockCriteria>  {

    List<Stock> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    long countByProduitId(Long id);
    List<Stock> findByDepotId(Long id);
    int deleteByDepotId(Long id);
    long countByDepotCode(String code);


    HttpEntity<byte[]> createPdf(StockDto dto) throws Exception;

}
