package ma.zsmart.stocky.bean.core.commun;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zsmart.stocky.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "ville")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="ville_seq",sequenceName="ville_seq",allocationSize=1, initialValue = 1)
public class Ville   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;



    public Ville(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="ville_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return id != null && id.equals(ville.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

