package com.mycepapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class CepLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;
    private String cep; //: "06726-370",
    private String logradouro; //": "Rua Jari",
    private String complemento; //": "",
    private String unidade; //": "",
    private String bairro; //": "Jardim Ana Cristina (Caucaia do Alto)",
    private String localidade; //": "Cotia",
    private String uf; //": "SP",
    private String estado; //": "São Paulo",
    private String regiao; //": "Sudeste",
    private String ibge; //": "3513009",
    private Integer gia; //": "2781",
    private Integer ddd; //": "11",
    private Integer siafi; //": "6361"

    public CepLog() {}

    public CepLog(LocalDateTime timestamp, CepInfo response) {
        this.timestamp = timestamp;
        this.cep = response.cep;
        this.logradouro = response.logradouro;
        this.complemento = response.complemento;
        this.unidade = response.unidade;
        this.bairro = response.bairro;
        this.localidade = response.localidade;
        this.uf = response.uf;
        this.estado = response.estado;
        this.regiao = response.regiao;
        this.ibge = response.ibge;
        this.gia = response.gia;
        this.ddd = response.ddd;
        this.siafi = response.siafi;
    }

    // Getters and setters
}
