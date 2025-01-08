package com.mycepapi.controller;

import com.mycepapi.model.CepInfo;
import com.mycepapi.service.CepService;
import com.mycepapi.model.CepLog;
import com.mycepapi.repository.CepLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @Autowired
    private CepLogRepository cepLogRepository;

    @GetMapping("/{cep}")
    public CepInfo getCepInfo(@PathVariable String cep) {
        CepInfo cepInfo = cepService.getCepInfo(cep);
        CepLog log = new CepLog(LocalDateTime.now(), cepInfo);
        cepLogRepository.save(log);
        return cepInfo;
    }
}
