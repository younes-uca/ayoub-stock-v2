package  ma.zsmart.stocky.dao.criteria.core.gestionchequeffet;



import ma.zsmart.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProprietaireCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;



    public ProprietaireCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }


}
