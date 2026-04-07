/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjexerciciomoodle.models;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author carlos
 */
public class Pessoa {
    private UUID id;
    private String nome;
    private String data_nascimento;
    private String cpf;
    private List<Veiculo> lstVeiculos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

 public List<Veiculo> getLstVeiculos() {
    return lstVeiculos;
}

public void setLstVeiculos(List<Veiculo> lstVeiculos) {
    this.lstVeiculos = lstVeiculos;
}

}
