package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.PermutationItemCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.PermutationItem;


public class PermutationItemSpecification extends  AbstractSpecification<PermutationItemCriteria, PermutationItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("depotOrigine","id", criteria.getDepotOrigine()==null?null:criteria.getDepotOrigine().getId());
        addPredicateFk("depotOrigine","id", criteria.getDepotOrigines());
        addPredicateFk("depotOrigine","code", criteria.getDepotOrigine()==null?null:criteria.getDepotOrigine().getCode());
        addPredicateFk("depotDestination","id", criteria.getDepotDestination()==null?null:criteria.getDepotDestination().getId());
        addPredicateFk("depotDestination","id", criteria.getDepotDestinations());
        addPredicateFk("depotDestination","code", criteria.getDepotDestination()==null?null:criteria.getDepotDestination().getCode());
        addPredicateFk("permutation","id", criteria.getPermutation()==null?null:criteria.getPermutation().getId());
        addPredicateFk("permutation","id", criteria.getPermutations());
    }

    public PermutationItemSpecification(PermutationItemCriteria criteria) {
        super(criteria);
    }

    public PermutationItemSpecification(PermutationItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
