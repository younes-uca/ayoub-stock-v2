package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.ModePaiement;
import ma.zsmart.stocky.dao.criteria.core.commun.ModePaiementCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.ModePaiementDao;
import ma.zsmart.stocky.dao.specification.core.commun.ModePaiementSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.ModePaiementAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.commun.ModePaiementDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ModePaiementAdminServiceImpl extends AbstractServiceImpl<ModePaiement, ModePaiementCriteria, ModePaiementDao> implements ModePaiementAdminService {
    public static final String TEMPLATE = "template/modePaiement.vm";
    public static final String FILE_NAME = "modePaiement.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ModePaiementDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public ModePaiement findByReferenceEntity(ModePaiement t){
        return  dao.findByCode(t.getCode());
    }


    public List<ModePaiement> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(ModePaiement.class, ModePaiementSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public ModePaiementAdminServiceImpl(ModePaiementDao dao) {
        super(dao);
    }

}
