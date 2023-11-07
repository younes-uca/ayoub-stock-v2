package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PermutationCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Permutation;


public class PermutationSpecification extends  AbstractSpecification<PermutationCriteria, Permutation>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("datePermutation", criteria.getDatePermutation(), criteria.getDatePermutationFrom(), criteria.getDatePermutationTo());
    }

    public PermutationSpecification(PermutationCriteria criteria) {
        super(criteria);
    }

    public PermutationSpecification(PermutationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
