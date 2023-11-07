package  ma.zsmart.stocky.dao.specification.core.stock;

import ma.zsmart.stocky.zynerator.specification.AbstractSpecification;
import ma.zsmart.stocky.dao.criteria.core.stock.VenteCriteria;
import ma.zsmart.stocky.bean.core.stock.Vente;


public class VenteSpecification extends  AbstractSpecification<VenteCriteria, Vente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("codeVente", criteria.getCodeVente(),criteria.getCodeVenteLike());
        addPredicateBigDecimal("montantHt", criteria.getMontantHt(), criteria.getMontantHtMin(), criteria.getMontantHtMax());
        addPredicateBigDecimal("tauxTva", criteria.getTauxTva(), criteria.getTauxTvaMin(), criteria.getTauxTvaMax());
        addPredicateBigDecimal("montantTva", criteria.getMontantTva(), criteria.getMontantTvaMin(), criteria.getMontantTvaMax());
        addPredicateBigDecimal("montantTtc", criteria.getMontantTtc(), criteria.getMontantTtcMin(), criteria.getMontantTtcMax());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSociete()==null?null:criteria.getEntrepriseSociete().getId());
        addPredicateFk("entrepriseSociete","id", criteria.getEntrepriseSocietes());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("etatVente","id", criteria.getEtatVente()==null?null:criteria.getEtatVente().getId());
        addPredicateFk("etatVente","id", criteria.getEtatVentes());
        addPredicateFk("etatVente","code", criteria.getEtatVente()==null?null:criteria.getEtatVente().getCode());
    }

    public VenteSpecification(VenteCriteria criteria) {
        super(criteria);
    }

    public VenteSpecification(VenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
