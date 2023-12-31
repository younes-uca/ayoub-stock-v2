package  ma.zsmart.stocky.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zsmart.stocky.bean.core.paiement.PaiementAchat;
import ma.zsmart.stocky.dao.criteria.core.paiement.PaiementAchatCriteria;
import ma.zsmart.stocky.service.facade.admin.paiement.PaiementAchatAdminService;
import ma.zsmart.stocky.ws.converter.paiement.PaiementAchatConverter;
import ma.zsmart.stocky.ws.dto.paiement.PaiementAchatDto;
import ma.zsmart.stocky.zynerator.controller.AbstractController;
import ma.zsmart.stocky.zynerator.dto.AuditEntityDto;
import ma.zsmart.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zsmart.stocky.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.zsmart.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/paiementAchat/")
public class PaiementAchatRestAdmin  extends AbstractController<PaiementAchat, PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService, PaiementAchatConverter> {


    @Operation(summary = "Import excel")
    @PostMapping("import-excel")
    public ResponseEntity<List<PaiementAchat>> importExcel(@RequestParam("file") MultipartFile file){
        return super.importExcel(file);
    }

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody PaiementAchatDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one paiementAchat")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiementAchats")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiementAchats")
    @GetMapping("")
    public ResponseEntity<List<PaiementAchatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all paiementAchats")
    @GetMapping("optimized")
    public ResponseEntity<List<PaiementAchatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a paiementAchat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementAchatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a paiementAchat by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<PaiementAchatDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new PaiementAchat(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  paiementAchat")
    @PostMapping("")
    public ResponseEntity<PaiementAchatDto> save(@RequestBody PaiementAchatDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiementAchat")
    @PutMapping("")
    public ResponseEntity<PaiementAchatDto> update(@RequestBody PaiementAchatDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiementAchat")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementAchatDto>> delete(@RequestBody List<PaiementAchatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiementAchat")
    @DeleteMapping("")
    public ResponseEntity<PaiementAchatDto> delete(@RequestBody PaiementAchatDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiementAchat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiementAchats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by achat id")
    @GetMapping("achat/id/{id}")
    public List<PaiementAchatDto> findByAchatId(@PathVariable Long id){
        return findDtos(service.findByAchatId(id));
    }
    @Operation(summary = "delete by achat id")
    @DeleteMapping("achat/id/{id}")
    public int deleteByAchatId(@PathVariable Long id){
        return service.deleteByAchatId(id);
    }
    @Operation(summary = "find by modePaiement id")
    @GetMapping("modePaiement/id/{id}")
    public List<PaiementAchatDto> findByModePaiementId(@PathVariable Long id){
        return findDtos(service.findByModePaiementId(id));
    }
    @Operation(summary = "delete by modePaiement id")
    @DeleteMapping("modePaiement/id/{id}")
    public int deleteByModePaiementId(@PathVariable Long id){
        return service.deleteByModePaiementId(id);
    }
    @Operation(summary = "Finds paiementAchats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementAchatDto>> findByCriteria(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiementAchats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiementAchats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiementAchat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementAchatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementAchatRestAdmin (PaiementAchatAdminService service, PaiementAchatConverter converter) {
        super(service, converter);
    }




}
