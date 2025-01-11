package com.mycepapi.logger;

import com.mycepapi.model.CepInfo;
import com.mycepapi.model.CepLog;
import com.mycepapi.repository.CepLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public class CepLogger {

    private Logger logger;
    private Class<?> clazz;
    private CepLogRepository cepLogRepository;

    public CepLogger(Class<?> clazz, CepLogRepository cepLogRepository) {
        this.clazz = clazz;
        this.cepLogRepository = cepLogRepository;
        this.logger = LoggerFactory.getLogger(clazz);
    }
    public void info(CepInfo cepInfo) {
        info(cepInfo, "");
    }

    public void info(CepInfo cepInfo, String message) {
        logger.info(msg(cepInfo, message));
        log(cepInfo, "info", message);
    }
    public void warn(CepInfo cepInfo) {
        warn(cepInfo, "");
    }

    public void warn(CepInfo cepInfo, String message) {
        logger.warn(msg(cepInfo, message));
        log(cepInfo, "warn", message);
    }

    public void log(CepInfo cepInfo, String level, String message) {
        CepLog log = new CepLog(LocalDateTime.now(), null, clazz.getName(), level, message, cepInfo);
        cepLogRepository.save(log);

    }

    private String msg(CepInfo cepInfo, String message) {
        String msg = String.format("%s - %s", message, cepInfo.toString());
        return msg;
    }
}
