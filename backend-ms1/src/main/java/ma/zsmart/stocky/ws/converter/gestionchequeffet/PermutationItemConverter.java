package  ma.zsmart.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.stocky.ws.converter.gestionchequeffet.PermutationConverter;
import ma.zsmart.stocky.ws.converter.commun.DepotConverter;
import ma.zsmart.stocky.ws.converter.stock.ProduitConverter;

import ma.zsmart.stocky.bean.core.stock.Produit;
import ma.zsmart.stocky.bean.core.gestionchequeffet.Permutation;


import ma.zsmart.stocky.zynerator.util.StringUtil;
import ma.zsmart.stocky.zynerator.converter.AbstractConverter;
import ma.zsmart.stocky.zynerator.util.DateUtil;
import ma.zsmart.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zsmart.stocky.ws.dto.gestionchequeffet.PermutationItemDto;

@Component
public class PermutationItemConverter extends AbstractConverter<PermutationItem, PermutationItemDto> {

    @Autowired
    private PermutationConverter permutationConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean depotOrigine;
    private boolean depotDestination;
    private boolean permutation;

    public  PermutationItemConverter(){
        super(PermutationItem.class, PermutationItemDto.class);
    }

    @Override
    public PermutationItem toItem(PermutationItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        PermutationItem item = new PermutationItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(this.depotOrigine && dto.getDepotOrigine()!=null &&  dto.getDepotOrigine().getId() != null)
                item.setDepotOrigine(depotConverter.toItem(dto.getDepotOrigine())) ;

            if(this.depotDestination && dto.getDepotDestination()!=null &&  dto.getDepotDestination().getId() != null)
                item.setDepotDestination(depotConverter.toItem(dto.getDepotDestination())) ;

            if(dto.getPermutation() != null && dto.getPermutation().getId() != null){
                item.setPermutation(new Permutation());
                item.getPermutation().setId(dto.getPermutation().getId());
                item.getPermutation().setId(dto.getPermutation().getId());
            }




        return item;
        }
    }

    @Override
    public PermutationItemDto toDto(PermutationItem item) {
        if (item == null) {
            return null;
        } else {
            PermutationItemDto dto = new PermutationItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.depotOrigine && item.getDepotOrigine()!=null) {
            dto.setDepotOrigine(depotConverter.toDto(item.getDepotOrigine())) ;
        }
        if(this.depotDestination && item.getDepotDestination()!=null) {
            dto.setDepotDestination(depotConverter.toDto(item.getDepotDestination())) ;
        }
        if(this.permutation && item.getPermutation()!=null) {
            dto.setPermutation(permutationConverter.toDto(item.getPermutation())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.depotOrigine = value;
        this.depotDestination = value;
        this.permutation = value;
    }


    public PermutationConverter getPermutationConverter(){
        return this.permutationConverter;
    }
    public void setPermutationConverter(PermutationConverter permutationConverter ){
        this.permutationConverter = permutationConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isDepotOrigine(){
        return this.depotOrigine;
    }
    public void  setDepotOrigine(boolean depotOrigine){
        this.depotOrigine = depotOrigine;
    }
    public boolean  isDepotDestination(){
        return this.depotDestination;
    }
    public void  setDepotDestination(boolean depotDestination){
        this.depotDestination = depotDestination;
    }
    public boolean  isPermutation(){
        return this.permutation;
    }
    public void  setPermutation(boolean permutation){
        this.permutation = permutation;
    }
}
