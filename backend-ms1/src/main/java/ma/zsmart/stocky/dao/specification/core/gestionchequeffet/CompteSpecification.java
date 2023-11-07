package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Compte;


public class CompteSpecification extends  AbstractSpecification<CompteCriteria, Compte>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numeroCompte", criteria.getNumeroCompte(),criteria.getNumeroCompteLike());
        addPredicateBigDecimal("solde", criteria.getSolde(), criteria.getSoldeMin(), criteria.getSoldeMax());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
        addPredicateFk("banque","code", criteria.getBanque()==null?null:criteria.getBanque().getCode());
        addPredicateFk("proprietaire","id", criteria.getProprietaire()==null?null:criteria.getProprietaire().getId());
        addPredicateFk("proprietaire","id", criteria.getProprietaires());
    }

    public CompteSpecification(CompteCriteria criteria) {
        super(criteria);
    }

    public CompteSpecification(CompteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
