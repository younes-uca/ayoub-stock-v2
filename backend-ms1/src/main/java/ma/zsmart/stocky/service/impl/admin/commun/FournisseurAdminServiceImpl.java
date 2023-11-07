package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.Fournisseur;
import ma.zsmart.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.FournisseurDao;
import ma.zsmart.stocky.dao.specification.core.commun.FournisseurSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.FournisseurAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.commun.VilleAdminService ;
import ma.zsmart.stocky.bean.core.commun.Ville ;

import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur, FournisseurCriteria, FournisseurDao> implements FournisseurAdminService {
    public static final String TEMPLATE = "template/fournisseur.vm";
    public static final String FILE_NAME = "fournisseur.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("nom"));

    ATTRIBUTES.add(new Attribute("ice"));

    ATTRIBUTES.add(new Attribute("telephone"));

    ATTRIBUTES.add(new Attribute("infoBancaire"));


    ATTRIBUTES.add(new Attribute("adresse"));

    ATTRIBUTES.add(new Attribute("creance","BigDecimal"));

    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }





    public List<Fournisseur> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }
    public long countByVilleId(Long id){
        return dao.countByVilleId(id);
    }



    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Fournisseur.class, FournisseurSpecification.class);
    }


    @Autowired
    private VilleAdminService villeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public FournisseurAdminServiceImpl(FournisseurDao dao) {
        super(dao);
    }

}
