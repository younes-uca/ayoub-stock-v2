package  ma.zsmart.stocky.ws.facade.admin.stock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zsmart.stocky.bean.core.stock.Achat;
import ma.zsmart.stocky.dao.criteria.core.stock.AchatCriteria;
import ma.zsmart.stocky.service.facade.admin.stock.AchatAdminService;
import ma.zsmart.stocky.ws.converter.stock.AchatConverter;
import ma.zsmart.stocky.ws.dto.stock.AchatDto;
import ma.zsmart.stocky.zynerator.controller.AbstractController;
import ma.zsmart.stocky.zynerator.dto.AuditEntityDto;
import ma.zsmart.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zsmart.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zsmart.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/achat/")
public class AchatRestAdmin  extends AbstractController<Achat, AchatDto, AchatCriteria, AchatAdminService, AchatConverter> {



    @Operation(summary = "upload one achat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple achats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all achats")
    @GetMapping("")
    public ResponseEntity<List<AchatDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a achat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @Operation(summary = "Saves the specified  achat")
    @PostMapping("")
    public ResponseEntity<AchatDto> save(@RequestBody AchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  achat")
    @PutMapping("")
    public ResponseEntity<AchatDto> update(@RequestBody AchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of achat")
    @PostMapping("multiple")
    public ResponseEntity<List<AchatDto>> delete(@RequestBody List<AchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified achat")
    @DeleteMapping("")
    public ResponseEntity<AchatDto> delete(@RequestBody AchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified achat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple achats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by entrepriseSociete id")
    @GetMapping("entrepriseSociete/id/{id}")
    public List<AchatDto> findByEntrepriseSocieteId(@PathVariable Long id){
        return findDtos(service.findByEntrepriseSocieteId(id));
    }
    @Operation(summary = "delete by entrepriseSociete id")
    @DeleteMapping("entrepriseSociete/id/{id}")
    public int deleteByEntrepriseSocieteId(@PathVariable Long id){
        return service.deleteByEntrepriseSocieteId(id);
    }
    @Operation(summary = "find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public List<AchatDto> findByFournisseurId(@PathVariable Long id){
        return findDtos(service.findByFournisseurId(id));
    }
    @Operation(summary = "delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public int deleteByFournisseurId(@PathVariable Long id){
        return service.deleteByFournisseurId(id);
    }
    @Operation(summary = "find by etatAchat id")
    @GetMapping("etatAchat/id/{id}")
    public List<AchatDto> findByEtatAchatId(@PathVariable Long id){
        return findDtos(service.findByEtatAchatId(id));
    }
    @Operation(summary = "delete by etatAchat id")
    @DeleteMapping("etatAchat/id/{id}")
    public int deleteByEtatAchatId(@PathVariable Long id){
        return service.deleteByEtatAchatId(id);
    }
    @Operation(summary = "Finds a achat and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<AchatDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds achats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AchatDto>> findByCriteria(@RequestBody AchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated achats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports achats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets achat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AchatRestAdmin (AchatAdminService service, AchatConverter converter) {
        super(service, converter);
    }




}
