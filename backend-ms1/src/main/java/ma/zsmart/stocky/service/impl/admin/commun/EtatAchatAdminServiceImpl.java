package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.EtatAchat;
import ma.zsmart.stocky.dao.criteria.core.commun.EtatAchatCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.EtatAchatDao;
import ma.zsmart.stocky.dao.specification.core.commun.EtatAchatSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.EtatAchatAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.commun.EtatAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatAchatAdminServiceImpl extends AbstractServiceImpl<EtatAchat, EtatAchatCriteria, EtatAchatDao> implements EtatAchatAdminService {
    public static final String TEMPLATE = "template/etatAchat.vm";
    public static final String FILE_NAME = "etatAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public EtatAchat findByReferenceEntity(EtatAchat t){
        return  dao.findByCode(t.getCode());
    }


    public List<EtatAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(EtatAchat.class, EtatAchatSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAchatAdminServiceImpl(EtatAchatDao dao) {
        super(dao);
    }

}
