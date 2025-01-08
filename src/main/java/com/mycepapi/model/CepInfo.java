package com.mycepapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CepInfo {

    @JsonProperty
    String cep; //: "06726-370",
    @JsonProperty
    String logradouro; //": "Rua Jari",
    @JsonProperty
    String complemento; //": "",
    @JsonProperty
    String unidade; //": "",
    @JsonProperty
    String bairro; //": "Jardim Ana Cristina (Caucaia do Alto)",
    @JsonProperty
    String localidade; //": "Cotia",
    @JsonProperty
    String uf; //": "SP",
    @JsonProperty
    String estado; //": "São Paulo",
    @JsonProperty
    String regiao; //": "Sudeste",
    @JsonProperty
    String ibge; //": "3513009",
    @JsonProperty
    Integer gia; //": "2781",
    @JsonProperty
    Integer ddd; //": "11",
    @JsonProperty
    Integer siafi; //": "6361"

}
