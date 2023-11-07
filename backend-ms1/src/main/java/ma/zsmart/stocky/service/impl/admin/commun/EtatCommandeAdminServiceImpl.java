package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.EtatCommande;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatCommandeCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.EtatCommandeDao;
import ma.zsmart.stocky.dao.specification.core.commun.EtatCommandeSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.EtatCommandeAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.commun.EtatCommandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatCommandeAdminServiceImpl extends AbstractServiceImpl<EtatCommande, EtatCommandeCriteria, EtatCommandeDao> implements EtatCommandeAdminService {
    public static final String TEMPLATE = "template/etatCommande.vm";
    public static final String FILE_NAME = "etatCommande.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public EtatCommande findByReferenceEntity(EtatCommande t){
        return  dao.findByCode(t.getCode());
    }


    public List<EtatCommande> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(EtatCommande.class, EtatCommandeSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public EtatCommandeAdminServiceImpl(EtatCommandeDao dao) {
        super(dao);
    }

}
