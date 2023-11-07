package  ma.zsmart.stocky.ws.dto.stock;

import ma.zsmart.stocky.zynerator.audit.Log;
import ma.zsmart.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


import ma.zsmart.stocky.ws.dto.commun.EtatCommandeDto;
import ma.zsmart.stocky.ws.dto.commun.FournisseurDto;
import ma.zsmart.stocky.ws.dto.commun.EntrepriseSocieteDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandeDto  extends AuditBaseDto {

    private String description  ;

    private EntrepriseSocieteDto entrepriseSociete ;
    private FournisseurDto fournisseur ;
    private EtatCommandeDto etatCommande ;

    private List<CommandeItemDto> commandeItems ;


    public CommandeDto(){
        super();
    }



    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public EntrepriseSocieteDto getEntrepriseSociete(){
        return this.entrepriseSociete;
    }

    public void setEntrepriseSociete(EntrepriseSocieteDto entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public FournisseurDto getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur){
        this.fournisseur = fournisseur;
    }
    public EtatCommandeDto getEtatCommande(){
        return this.etatCommande;
    }

    public void setEtatCommande(EtatCommandeDto etatCommande){
        this.etatCommande = etatCommande;
    }



    public List<CommandeItemDto> getCommandeItems(){
        return this.commandeItems;
    }

    public void setCommandeItems(List<CommandeItemDto> commandeItems){
        this.commandeItems = commandeItems;
    }



}
