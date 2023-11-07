package  ma.zsmart.stocky.dao.specification.core.commun;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.commun.ModePaiementCriteria;
import ma.zsmart.stocky.bean.core.commun.ModePaiement;


public class ModePaiementSpecification extends  AbstractSpecification<ModePaiementCriteria, ModePaiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ModePaiementSpecification(ModePaiementCriteria criteria) {
        super(criteria);
    }

    public ModePaiementSpecification(ModePaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
