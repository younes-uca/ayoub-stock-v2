package ma.zsmart.stocky.service.impl.admin.commun;


import ma.zsmart.stocky.bean.core.commun.Client;
import ma.zsmart.stocky.dao.criteria.core.commun.ClientCriteria;
import ma.zsmart.stocky.dao.facade.core.commun.ClientDao;
import ma.zsmart.stocky.dao.specification.core.commun.ClientSpecification;
import ma.zsmart.stocky.service.facade.admin.commun.ClientAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.service.Attribute;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zsmart.stocky.zynerator.util.VelocityPdf;
import ma.zsmart.stocky.ws.dto.commun.ClientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {
    public static final String TEMPLATE = "template/client.vm";
    public static final String FILE_NAME = "client.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("cin"));

    ATTRIBUTES.add(new Attribute("nom"));

    ATTRIBUTES.add(new Attribute("prenom"));

    ATTRIBUTES.add(new Attribute("telephone"));

    ATTRIBUTES.add(new Attribute("adresse"));

    ATTRIBUTES.add(new Attribute("description"));

    ATTRIBUTES.add(new Attribute("creance","BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }








    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Client.class, ClientSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}
