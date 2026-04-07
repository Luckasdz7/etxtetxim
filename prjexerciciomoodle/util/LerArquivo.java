/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjexerciciomoodle.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

       
        
        
     
 
public class LerArquivo {
    
    public BufferedReader ler (String arquivo)
    {
        BufferedReader br = null;
        
        try
        {
            /*Define o caminho do arquivo que sera
            utilizado para leitura ou escrita*/
            
            File f = new File ( arquivo );
            
            /*Cria uma instancia do arquivo que sera lido*/
            
            if ( f.exists() )
            {
                FileReader fr = new FileReader(f);
                 /*Armazena o conteudo do arquivo para a leitura*/
                 
                 br = new BufferedReader (fr);
                 
            }
        }
        
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return br;
    }
    
}
