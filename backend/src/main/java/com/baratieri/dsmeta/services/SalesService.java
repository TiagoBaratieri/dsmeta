package com.baratieri.dsmeta.services;

import com.baratieri.dsmeta.dto.SalesDTO;
import com.baratieri.dsmeta.entities.Sale;
import com.baratieri.dsmeta.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SalesService {

    @Autowired
    private SalesRepository repository;

    @Transactional(readOnly = true)
    public Page<SalesDTO> pageSale(String minDate, String maxDate,Pageable pageable){

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max =  maxDate.equals("") ? today : LocalDate.parse(maxDate);
        Page<Sale> obj = repository.findSales(min,max, pageable);
        return obj.map(x -> new SalesDTO(x));

    }
}
