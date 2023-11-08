package com.api_senai.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Conta {
    @Id
    Long id;
    int numero;
    double saldo;
    Cliente cliente;
    //Funcionario gerente;
}
