package challenge.soniq.taheri.spo.controllers;

import challenge.soniq.taheri.spo.controllers.model.WorkforceInfoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/api/spi"})
public class SPOController {
//    @Autowired
//    private OrganizationService organizationService;

    @PostMapping
//    @Throws(ValidationException::class)
    public ResponseEntity getWorkforceInfo(@Valid @RequestBody WorkforceInfoRequest request) {
//        return (ResponseEntity) BankerController.this.bankerClient.getInvoiceExcelFormat(invoiceId);
        return null;
    }

}
