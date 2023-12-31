package ma.zsmart.stocky.service.impl.admin.paiement;


import ma.zsmart.stocky.bean.core.paiement.PaiementAchat;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAchatCriteria;
import ma.zsmart.stocky.dao.facade.core.paiement.PaiementAchatDao;
import ma.zsmart.stocky.dao.specification.core.paiement.PaiementAchatSpecification;
import ma.zsmart.stocky.service.facade.admin.paiement.PaiementAchatAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.paiement.PaiementAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.stock.AchatAdminService ;
import ma.zsmart.stocky.bean.core.stock.Achat ;
import ma.zsmart.stocky.service.facade.admin.commun.ModePaiementAdminService ;
import ma.zsmart.stocky.bean.core.commun.ModePaiement ;

import java.util.List;
@Service
public class PaiementAchatAdminServiceImpl extends AbstractServiceImpl<PaiementAchat, PaiementAchatCriteria, PaiementAchatDao> implements PaiementAchatAdminService {
    public static final String TEMPLATE = "template/paiementAchat.vm";
    public static final String FILE_NAME = "paiementAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(PaiementAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public PaiementAchat findByReferenceEntity(PaiementAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<PaiementAchat> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public long countByModePaiementCode(String code){
        return dao.countByModePaiementCode(code);
    }

    public List<PaiementAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(PaiementAchat.class, PaiementAchatSpecification.class);
    }


    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaiementAchatAdminServiceImpl(PaiementAchatDao dao) {
        super(dao);
    }

}
