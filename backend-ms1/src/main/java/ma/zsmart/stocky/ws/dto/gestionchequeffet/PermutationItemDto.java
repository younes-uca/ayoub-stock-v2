package  ma.zsmart.stocky.ws.dto.gestionchequeffet;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zsmart.stocky.ws.dto.commun.DepotDto;
import ma.zsmart.stocky.ws.dto.stock.ProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermutationItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private DepotDto depotOrigine ;
    private DepotDto depotDestination ;
    private PermutationDto permutation ;



    public PermutationItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public DepotDto getDepotOrigine(){
        return this.depotOrigine;
    }

    public void setDepotOrigine(DepotDto depotOrigine){
        this.depotOrigine = depotOrigine;
    }
    public DepotDto getDepotDestination(){
        return this.depotDestination;
    }

    public void setDepotDestination(DepotDto depotDestination){
        this.depotDestination = depotDestination;
    }
    public PermutationDto getPermutation(){
        return this.permutation;
    }

    public void setPermutation(PermutationDto permutation){
        this.permutation = permutation;
    }






}
