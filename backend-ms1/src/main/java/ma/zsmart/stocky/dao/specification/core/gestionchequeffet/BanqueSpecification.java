package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.BanqueCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Banque;


public class BanqueSpecification extends  AbstractSpecification<BanqueCriteria, Banque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public BanqueSpecification(BanqueCriteria criteria) {
        super(criteria);
    }

    public BanqueSpecification(BanqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
