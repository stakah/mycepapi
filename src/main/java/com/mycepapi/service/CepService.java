package com.mycepapi.service;

import com.mycepapi.model.CepInfo;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cepService", url = "${openfeign.client.url}")
public interface CepService {
    @GetMapping(value = "/{cep}/json")
    @Headers("Accept: application/json")
    CepInfo getCepInfo(@PathVariable("cep") String cep);
}
