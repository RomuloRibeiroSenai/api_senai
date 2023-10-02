package com.api_senai.api.entities;

import lombok.Data;

//import org.apache.http.client.methods.HttpGet;
@Data
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco getEnderecoByCep(String cep){
        Endereco endereco = new Endereco();
        /* mandar o cep pro via cep
        tratar a resposta
        montar o endereço
         */
        HttpGet request = new HttpGet("http://viacep.com.br/ws/"+ cep + "/json/");

        return endereco;
    }
}
