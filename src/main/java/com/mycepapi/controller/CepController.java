package com.mycepapi.controller;

import com.mycepapi.exception.ItemNotExistException;
import com.mycepapi.logger.CepLogger;
import com.mycepapi.model.CepInfo;
import com.mycepapi.service.CepService;
import com.mycepapi.repository.CepLogRepository;
import feign.FeignException;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    private CepLogRepository cepLogRepository;

    private CepLogger cepLogger;

    @Autowired
    public CepController(CepLogRepository cepLogRepository) {
        this.cepLogRepository = cepLogRepository;
        this.cepLogger = new CepLogger(CepController.class, cepLogRepository);
    }

    @GetMapping("/{cep}")
    public CepInfo getCepInfo(@PathVariable String cep) throws  ItemNotExistException{
        try {
            CepInfo cepInfo = cepService.getCepInfo(cep);
            cepLogger.info(cepInfo);
            return cepInfo;
        } catch (FeignException.NotFound | FeignException.BadRequest ex) {
            CepInfo noCep = new CepInfo(cep);
            cepLogger.warn(noCep, "CEP não encontrado");
            throw (new ItemNotExistException("CEP não encontrado"));
        }

    }


    public static class Error {
        private String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    // Controller specific exception handler, not central like @ControllerAdvice
    @ExceptionHandler(ItemNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Error itemNotExistExceptionHandler(ItemNotExistException ex) {
        return new Error(ex.getMessage()); // example
    }
}
