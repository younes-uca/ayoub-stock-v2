package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ProprietaireBanqueCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.ProprietaireBanque;


public class ProprietaireBanqueSpecification extends  AbstractSpecification<ProprietaireBanqueCriteria, ProprietaireBanque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("proprietaire","id", criteria.getProprietaire()==null?null:criteria.getProprietaire().getId());
        addPredicateFk("proprietaire","id", criteria.getProprietaires());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
        addPredicateFk("banque","code", criteria.getBanque()==null?null:criteria.getBanque().getCode());
        addPredicateFk("compte","id", criteria.getCompte()==null?null:criteria.getCompte().getId());
        addPredicateFk("compte","id", criteria.getComptes());
    }

    public ProprietaireBanqueSpecification(ProprietaireBanqueCriteria criteria) {
        super(criteria);
    }

    public ProprietaireBanqueSpecification(ProprietaireBanqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
