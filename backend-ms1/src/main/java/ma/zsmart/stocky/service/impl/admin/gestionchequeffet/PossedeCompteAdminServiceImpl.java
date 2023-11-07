package ma.zsmart.stocky.service.impl.admin.gestionchequeffet;


import ma.zsmart.stocky.bean.core.gestionchequeffet.PossedeCompte;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PossedeCompteCriteria;
import ma.zsmart.stocky.dao.facade.core.gestionchequeffet.PossedeCompteDao;
import ma.zsmart.stocky.dao.specification.core.gestionchequeffet.PossedeCompteSpecification;
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.PossedeCompteAdminService;
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
import ma.zsmart.stocky.service.facade.admin.gestionchequeffet.CompteAdminService ;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Compte ;

import java.util.List;
@Service
public class PossedeCompteAdminServiceImpl extends AbstractServiceImpl<PossedeCompte, PossedeCompteCriteria, PossedeCompteDao> implements PossedeCompteAdminService {






    public List<PossedeCompte> findByProprietaireId(Long id){
        return dao.findByProprietaireId(id);
    }
    public int deleteByProprietaireId(Long id){
        return dao.deleteByProprietaireId(id);
    }
    public long countByProprietaireId(Long id){
        return dao.countByProprietaireId(id);
    }
    public List<PossedeCompte> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }
    public long countByBanqueCode(String code){
        return dao.countByBanqueCode(code);
    }
    public List<PossedeCompte> findByCompteId(Long id){
        return dao.findByCompteId(id);
    }
    public int deleteByCompteId(Long id){
        return dao.deleteByCompteId(id);
    }
    public long countByCompteId(Long id){
        return dao.countByCompteId(id);
    }






    public void configure() {
        super.configure(PossedeCompte.class, PossedeCompteSpecification.class);
    }


    @Autowired
    private BanqueAdminService banqueService ;
    @Autowired
    private ProprietaireAdminService proprietaireService ;
    @Autowired
    private CompteAdminService compteService ;

    public PossedeCompteAdminServiceImpl(PossedeCompteDao dao) {
        super(dao);
    }

}
