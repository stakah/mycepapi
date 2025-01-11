package com.mycepapi.controller;

import com.mycepapi.model.CepInfo;
import com.mycepapi.service.CepService;
import com.mycepapi.model.CepLog;
import com.mycepapi.repository.CepLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CepControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CepService cepService;

    @Mock
    private CepLogRepository cepLogRepository;

    @InjectMocks
    private CepController cepController;

    public CepControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(cepController).build();
    }

    @Test
    public void testGetCepInfo() throws Exception {
        CepInfo info = new CepInfo("01001000");
        CepLog log = new CepLog(LocalDateTime.now(),
                "test", "test", "info", "", info);
        when(cepService.getCepInfo("01001000")).thenReturn(info);

        mockMvc.perform(get("/api/cep/01001000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
