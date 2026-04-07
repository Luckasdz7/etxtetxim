/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjexerciciomoodle.bo;
import com.mycompany.prjexerciciomoodle.dao.PessoaDAO;
import com.mycompany.prjexerciciomoodle.models.Pessoa;
import com.mycompany.prjexerciciomoodle.models.Veiculo;
import java.util.List;
import java.util.Map;

public class PessoaBO
{
    PessoaDAO pDAO;

    public PessoaBO() {
        pDAO = new PessoaDAO();
    }

    public void salvarPessoa(Pessoa p)
    {
        pDAO.salvarPessoa(p);
    }

    public List<Pessoa> buscarPessoa()
    {
        return pDAO.buscarPessoa();
    }

    public Pessoa buscarPessoa(String cpf)
    {
        return pDAO.buscarPessoa(cpf);
    }

    public void mostrarDados(List<Pessoa> lstP)
    {
        if (lstP.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        for (Pessoa p : lstP) {
            printDadosPessoa(p);
            System.out.println("**************************************************");
            for (Veiculo v : p.getLstVeiculos()) {
                printDadosVeiculo(v);
                System.out.println("-----------------");
            }
        }
    }

    public void mostrarDados(Pessoa p)
    {
        if (p == null) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        printDadosPessoa(p);
        System.out.println("**************************************************");
        if(!p.getLstVeiculos().isEmpty())
        {
            for (Veiculo v : p.getLstVeiculos()) {
                printDadosVeiculo(v);
                System.out.println("-----------------");
            }
        }
    }

    private void printDadosPessoa(Pessoa p)
    {
        System.out.println("ID: "+p.getId());
        System.out.println("Nome: "+p.getNome());
        System.out.println("CPF: "+p.getCpf());
        System.out.println("Data de Nascimento: "+p.getData_nascimento());
    }

    private void printDadosVeiculo(Veiculo v)
    {
        System.out.println("ID: "+ v.getId());
        System.out.println("Nome: "+ v.getNome());
        System.out.println("Modelo: "+v.getModelo());
        System.out.println("Marca: "+ v.getMarca());
        System.out.println("Placa: "+ v.getPlaca());
        System.out.println("Ano: "+v.getAno());
    }
}
