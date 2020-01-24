package challenge.soniq.taheri.spo.controllers;

import challenge.soniq.taheri.spo.models.OptimalStaffsResponse;
import challenge.soniq.taheri.spo.models.WorkforceInfoRequest;
import challenge.soniq.taheri.spo.services.OptimiseStaffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/api/spo"})
public class SPOController {
    @Autowired
    private OptimiseStaffs optimiseStaffs;

    @PostMapping
    public ResponseEntity<OptimalStaffsResponse[]> getWorkforceInfo
            (@Valid @RequestBody WorkforceInfoRequest request) {
        return new ResponseEntity<>(optimiseStaffs.optimiseStaffs(request), HttpStatus.OK);
    }

}
