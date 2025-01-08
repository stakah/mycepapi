package com.mycepapi.service;

import com.mycepapi.model.CepInfo;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cepService", url = "https://viacep.com.br/ws")
public interface CepService {
    @GetMapping(value = "/{cep}/json")
    @Headers("Accept: application/json")
    CepInfo getCepInfo(@RequestParam("cep") String cep);
}
