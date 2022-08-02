package com.baratieri.dsmeta.resources;

import com.baratieri.dsmeta.dto.SalesDTO;
import com.baratieri.dsmeta.services.SalesService;
import com.baratieri.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "sales")
public class SalesResource {

    @Autowired
    private SalesService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    private ResponseEntity<Page<SalesDTO>> pageSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        Page<SalesDTO> page = service.pageSale(minDate, maxDate, pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
