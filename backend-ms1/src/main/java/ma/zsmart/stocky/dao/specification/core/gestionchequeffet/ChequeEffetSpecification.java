package  ma.zsmart.stocky.dao.specification.core.gestionchequeffet;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zsmart.stocky.bean.core.gestionchequeffet.ChequeEffet;


public class ChequeEffetSpecification extends  AbstractSpecification<ChequeEffetCriteria, ChequeEffet>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("numeroChequeEffet", criteria.getNumeroChequeEffet(),criteria.getNumeroChequeEffetLike());
        addPredicate("dateEmission", criteria.getDateEmission(), criteria.getDateEmissionFrom(), criteria.getDateEmissionTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("beneficiaire","id", criteria.getBeneficiaire()==null?null:criteria.getBeneficiaire().getId());
        addPredicateFk("beneficiaire","id", criteria.getBeneficiaires());
    }

    public ChequeEffetSpecification(ChequeEffetCriteria criteria) {
        super(criteria);
    }

    public ChequeEffetSpecification(ChequeEffetCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
