package ma.zsmart.stocky.bean.core.gestionchequeffet;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "proprietaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="proprietaire_seq",sequenceName="proprietaire_seq",allocationSize=1, initialValue = 1)
public class Proprietaire   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String nom;



    public Proprietaire(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="proprietaire_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietaire proprietaire = (Proprietaire) o;
        return id != null && id.equals(proprietaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

