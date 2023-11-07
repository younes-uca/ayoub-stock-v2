package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.Compte;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.CompteDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.CompteSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.CompteAdminService;
import ma.zsmart.stocky.zynerator.service.AbstractServiceImpl;
import ma.zsmart.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.BanqueAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Banque ;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.ProprietaireAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Proprietaire ;

import java.util.List;
@Service
public class CompteAdminServiceImpl extends AbstractServiceImpl<Compte, CompteCriteria, CompteDao> implements CompteAdminService {






    public List<Compte> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }
    public long countByBanqueCode(String code){
        return dao.countByBanqueCode(code);
    }
    public List<Compte> findByProprietaireId(Long id){
        return dao.findByProprietaireId(id);
    }
    public int deleteByProprietaireId(Long id){
        return dao.deleteByProprietaireId(id);
    }
    public long countByProprietaireId(Long id){
        return dao.countByProprietaireId(id);
    }

    public List<Compte> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Compte.class, CompteSpecification.class);
    }


    @Autowired
    private BanqueAdminService banqueService ;
    @Autowired
    private ProprietaireAdminService proprietaireService ;

    public CompteAdminServiceImpl(CompteDao dao) {
        super(dao);
    }

}
