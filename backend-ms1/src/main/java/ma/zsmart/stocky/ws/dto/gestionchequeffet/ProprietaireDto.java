package  ma.zsmart.stocky.ws.dto.gestionchequeffet;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProprietaireDto  extends AuditBaseDto {

    private String nom  ;




    public ProprietaireDto(){
        super();
    }



    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }








}
