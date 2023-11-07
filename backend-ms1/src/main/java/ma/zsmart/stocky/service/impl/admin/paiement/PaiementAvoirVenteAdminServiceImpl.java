package ma.zsmart.stocky.service.impl.admin.paiement;


import ma.zsmart.stocky.bean.core.paiement.PaiementAvoirVente;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAvoirVenteCriteria;
import ma.zsmart.stocky.dao.facade.core.paiement.PaiementAvoirVenteDao;
import ma.zsmart.stocky.dao.specification.core.paiement.PaiementAvoirVenteSpecification;
import ma.zsmart.stocky.service.facade.admin.paiement.PaiementAvoirVenteAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.paiement.PaiementAvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.VenteAdminService ;
import ma.zsmart.stocky.bean.core.stock.Vente ;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zsmart.stocky.bean.core.stock.AvoirVente ;
import ma.zsmart.stocky.service.facade.admin.commun.ModePaiementAdminService ;
import ma.zsmart.stocky.bean.core.commun.ModePaiement ;

import java.util.List;
@Service
public class PaiementAvoirVenteAdminServiceImpl extends AbstractServiceImpl<PaiementAvoirVente, PaiementAvoirVenteCriteria, PaiementAvoirVenteDao> implements PaiementAvoirVenteAdminService {
    public static final String TEMPLATE = "template/paiementAvoirVente.vm";
    public static final String FILE_NAME = "paiementAvoirVente.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));

    }

    @Override
    public HttpEntity<byte[]> createPdf(PaiementAvoirVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public PaiementAvoirVente findByReferenceEntity(PaiementAvoirVente t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementAvoirVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteId(Long id){
        return dao.countByVenteId(id);
    }
    public List<PaiementAvoirVente> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public long countByModePaiementCode(String code){
        return dao.countByModePaiementCode(code);
    }
    public List<PaiementAvoirVente> findByAvoirVenteId(Long id){
        return dao.findByAvoirVenteId(id);
    }
    public int deleteByAvoirVenteId(Long id){
        return dao.deleteByAvoirVenteId(id);
    }
    public long countByAvoirVenteId(Long id){
        return dao.countByAvoirVenteId(id);
    }

    public List<PaiementAvoirVente> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(PaiementAvoirVente.class, PaiementAvoirVenteSpecification.class);
    }


    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaiementAvoirVenteAdminServiceImpl(PaiementAvoirVenteDao dao) {
        super(dao);
    }

}
