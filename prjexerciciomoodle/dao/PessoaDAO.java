/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjexerciciomoodle.dao;

import com.mycompany.prjexerciciomoodle.menu.Menu;
import com.mycompany.prjexerciciomoodle.models.Pessoa;
import com.mycompany.prjexerciciomoodle.models.Veiculo;
import com.mycompany.prjexerciciomoodle.util.EscreverArquivo;
import com.mycompany.prjexerciciomoodle.util.LerArquivo;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 *
 * @author carlos
 */
public class PessoaDAO {
    
    private final String ARQUIVO = "c:\\PessoaVeiculo.txt";
    
    private final boolean Manter = true;
    
    public void salvarPessoa(Pessoa p)
    {
        String dados = "" + p.getId() + ", " + p.getNome() + ", " + p.getCpf() + ", " + p.getData_nascimento();
        
        List<Veiculo> lstVeiculos = p.getLstVeiculos();
        
        for(Veiculo veiculo : lstVeiculos)
        {
            dados = dados + ";" + veiculo.getId() + ", " + veiculo.getNome() + ", " + veiculo.getModelo() + ", " + veiculo.getMarca() + ", " +  veiculo.getPlaca() + ", " +  veiculo.getAno();
        }
        new EscreverArquivo().escrever(ARQUIVO, dados, Manter);
    }
    public List<Pessoa> buscarPessoa()
    {
        BufferedReader br = new LerArquivo().ler(ARQUIVO);
        if(br == null)
        {
            return null;
        }
        List<Pessoa> lstP = new ArrayList<>();
        
        try
        {
            while(br.ready())
            {
                String itensString[] = br.readLine().split(";");
                
                if (itensString.length != 0){
                    Pessoa p = new Pessoa();
                    
                    String objPessoa[] = itensString[0].split(",");
                    p.setId(UUID.fromString(objPessoa[0].trim()));
                    p.setNome(objPessoa[1].trim());
                    p.setCpf(objPessoa[2].trim());
                    p.setData_nascimento(objPessoa[3].trim());
                    lstP.add(p);
                    
                    if(itensString.length != 1)
                    {
                        List<Veiculo> lstVeiculos = new LinkedList<>();
                        itensString = Arrays.copyOfRange(itensString, 1, itensString.length);
                        
                        
                        for(String item : itensString)
                        {
                            Veiculo v = new Veiculo();
                            String objVeiculo[] = item.split(",");
                            v.setId(UUID.fromString(objVeiculo[0].trim()));
                            v.setNome(objVeiculo[1].trim());
                            v.setModelo(objVeiculo[2].trim());
                            v.setMarca(objVeiculo[3].trim());
                            v.setPlaca(objVeiculo[4].trim());
                            v.setAno(Integer.parseInt(objVeiculo[5].trim()));
                            lstVeiculos.add(v);
                            
                        }
                        p.setLstVeiculos(lstVeiculos);
                                
                    }
                }
                
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return lstP;
    }
    public Pessoa buscarPessoa(String cpf){
        //String teste = "850bacd3-6877-4c03-8c5c-7a216d97eae3, Teste 1, 00011122233, 01/01/2025;c03ce164-5370-4e6a-a507-40d7c7654308, Gol, GSI, VW, AAA-1010, 2020;cd5a09e6-7d3b-4a92-b8ca-428ed831ae72, Uno, 1000, Fiat, BBB-0000, 2021";
        BufferedReader br = new LerArquivo().ler(ARQUIVO);
        if(br == null)
        {
            return null;
        }

        Map<String,Pessoa> map = new HashMap<>();

        try {
            while (br.ready()) {
                String itensString[] = br.readLine().split(";");

                if (itensString.length != 0) {
                    Pessoa p = new Pessoa();

                    String objPessoa[] = itensString[0].split(",");
                    p.setId(UUID.fromString(objPessoa[0].trim()));
                    p.setNome(objPessoa[1].trim());
                    p.setCpf(objPessoa[2].trim());
                    p.setData_nascimento(objPessoa[3].trim());

                    map.put(p.getCpf(), p);

                    if (itensString.length != 1) {
                        List<Veiculo> lstVeiculos = new LinkedList<>();
                        itensString = Arrays.copyOfRange(itensString, 1, itensString.length);

                        for (String item : itensString) {
                            Veiculo v = new Veiculo();
                            String objVeiculo[] = item.split(",");
                            v.setId(UUID.fromString(objVeiculo[0].trim()));
                            v.setNome(objVeiculo[1].trim());
                            v.setModelo(objVeiculo[2].trim());
                            v.setMarca(objVeiculo[3].trim());
                            v.setPlaca(objVeiculo[4].trim());
                            v.setAno(Integer.parseInt(objVeiculo[5].trim()));

                            lstVeiculos.add(v);
                        }
                        p.setLstVeiculos(lstVeiculos);
                    }
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return map.get(cpf);
     
        
      
        
    }
    
    
}
