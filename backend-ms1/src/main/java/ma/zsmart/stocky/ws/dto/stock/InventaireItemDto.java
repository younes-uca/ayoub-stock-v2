package  ma.zsmart.stocky.ws.dto.stock;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventaireItemDto  extends AuditBaseDto {

    private BigDecimal quantiteEstime  ;
    private BigDecimal quantiteReelle  ;

    private ProduitDto produit ;
    private InventaireDto inventaire ;



    public InventaireItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantiteEstime(){
        return this.quantiteEstime;
    }
    public void setQuantiteEstime(BigDecimal quantiteEstime){
        this.quantiteEstime = quantiteEstime;
    }

    @Log
    public BigDecimal getQuantiteReelle(){
        return this.quantiteReelle;
    }
    public void setQuantiteReelle(BigDecimal quantiteReelle){
        this.quantiteReelle = quantiteReelle;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public InventaireDto getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(InventaireDto inventaire){
        this.inventaire = inventaire;
    }






}
