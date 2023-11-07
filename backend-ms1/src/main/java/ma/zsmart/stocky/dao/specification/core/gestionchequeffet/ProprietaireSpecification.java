package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ProprietaireCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Proprietaire;


public class ProprietaireSpecification extends  AbstractSpecification<ProprietaireCriteria, Proprietaire>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria) {
        super(criteria);
    }

    public ProprietaireSpecification(ProprietaireCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
