package ma.zsmart.stocky.service.impl.admin.paiement;


import ma.zsmart.stocky.bean.core.paiement.PaiementAvoirAchat;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAvoirAchatCriteria;
import ma.zsmart.stocky.dao.facade.core.paiement.PaiementAvoirAchatDao;
import ma.zsmart.stocky.dao.specification.core.paiement.PaiementAvoirAchatSpecification;
import ma.zsmart.stocky.service.facade.admin.paiement.PaiementAvoirAchatAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.paiement.PaiementAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.AchatAdminService ;
import ma.zsmart.stocky.bean.core.stock.Achat ;
import ma.zsmart.stocky.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zsmart.stocky.bean.core.stock.AvoirAchat ;
import ma.zsmart.stocky.service.facade.admin.commun.ModePaiementAdminService ;
import ma.zsmart.stocky.bean.core.commun.ModePaiement ;

import java.util.List;
@Service
public class PaiementAvoirAchatAdminServiceImpl extends AbstractServiceImpl<PaiementAvoirAchat, PaiementAvoirAchatCriteria, PaiementAvoirAchatDao> implements PaiementAvoirAchatAdminService {
    public static final String TEMPLATE = "template/paiementAvoirAchat.vm";
    public static final String FILE_NAME = "paiementAvoirAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));

    }

    @Override
    public HttpEntity<byte[]> createPdf(PaiementAvoirAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public PaiementAvoirAchat findByReferenceEntity(PaiementAvoirAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementAvoirAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<PaiementAvoirAchat> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public long countByModePaiementCode(String code){
        return dao.countByModePaiementCode(code);
    }
    public List<PaiementAvoirAchat> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatId(Long id){
        return dao.countByAvoirAchatId(id);
    }

    public List<PaiementAvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(PaiementAvoirAchat.class, PaiementAvoirAchatSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaiementAvoirAchatAdminServiceImpl(PaiementAvoirAchatDao dao) {
        super(dao);
    }

}
