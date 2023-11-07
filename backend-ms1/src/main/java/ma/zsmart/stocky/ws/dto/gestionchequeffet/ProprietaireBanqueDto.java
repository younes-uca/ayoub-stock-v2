package  ma.zsmart.stocky.ws.dto.gestionchequeffet;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProprietaireBanqueDto  extends AuditBaseDto {


    private ProprietaireDto proprietaire ;
    private BanqueDto banque ;
    private CompteDto compte ;



    public ProprietaireBanqueDto(){
        super();
    }




    public ProprietaireDto getProprietaire(){
        return this.proprietaire;
    }

    public void setProprietaire(ProprietaireDto proprietaire){
        this.proprietaire = proprietaire;
    }
    public BanqueDto getBanque(){
        return this.banque;
    }

    public void setBanque(BanqueDto banque){
        this.banque = banque;
    }
    public CompteDto getCompte(){
        return this.compte;
    }

    public void setCompte(CompteDto compte){
        this.compte = compte;
    }






}