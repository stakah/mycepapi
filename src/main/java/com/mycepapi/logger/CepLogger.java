package com.mycepapi.logger;

import com.mycepapi.model.CepInfo;
import com.mycepapi.model.CepLog;
import com.mycepapi.repository.CepLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class CepLogger {


    private Class<?> clazz;
    private CepLogRepository cepLogRepository;

    public CepLogger(Class<?> clazz, CepLogRepository cepLogRepository) {
        this.clazz = clazz;
        this.cepLogRepository = cepLogRepository;
    }
    public void info(CepInfo cepInfo) {
        info(cepInfo, "");
    }

    public void info(CepInfo cepInfo, String message) {
        log(cepInfo, "info", message);
    }
    public void warn(CepInfo cepInfo) {
        warn(cepInfo, "");
    }

    public void warn(CepInfo cepInfo, String message) {
        log(cepInfo, "warn", message);
    }

    public void log(CepInfo cepInfo, String level, String message) {
        CepLog log = new CepLog(LocalDateTime.now(), null, clazz.getName(), level, message, cepInfo);
        cepLogRepository.save(log);

    }
}
