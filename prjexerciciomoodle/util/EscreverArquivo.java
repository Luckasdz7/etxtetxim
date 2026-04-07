/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjexerciciomoodle.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class EscreverArquivo {
    public void escrever ( String arquivo, String texto, boolean manter)
    {
        try
        {/*Vai definir o caminho do arquivo que sera utilizado
          para leitura ou escrita */
            File f = new File (arquivo);
            
            /*criar uma instancia do arquivo para escrita*/
            
            FileWriter fw = new FileWriter (f, manter);
            
            /*criar meio para escrever no arquivo
            instanciado na linha anterior*/
            
            PrintWriter pw = new PrintWriter (fw);
             // escreve no arquivo
             
             pw.println(texto);
             
             //por fim, conclui a escrita do arquivo
             
             fw.close();
             
           
        }catch(IOException ex){
            ex.printStackTrace();
        }
                
    }
    
}
