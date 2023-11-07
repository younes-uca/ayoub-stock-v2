package  ma.zsmart.stocky.ws.dto.stock;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zsmart.stocky.ws.dto.entree.SortieProduitDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SortieProduitItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;
    private String description  ;

    private ProduitDto produit ;
    private SortieProduitDto sortieProduit ;



    public SortieProduitItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public SortieProduitDto getSortieProduit(){
        return this.sortieProduit;
    }

    public void setSortieProduit(SortieProduitDto sortieProduit){
        this.sortieProduit = sortieProduit;
    }






}
