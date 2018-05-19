/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author h
 */
public class TextReader {
    private String fileName;
    private FileReader fRe;
    private BufferedReader br;
    
    
    public TextReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.fRe = new FileReader(fileName);
        this.br = new BufferedReader(fRe);
    }
    
    public ArrayList<String> getData() throws IOException{
        ArrayList<String> result = new ArrayList<>();
        String para,query = "" ;
        while((para = br.readLine()) != null){
            query += para + "\n";
            if(!para.equals("") && para.charAt(para.length()-1) == ';'){
                result.add(query);
                query = "";
            }

        }
        return result;
    }
}
