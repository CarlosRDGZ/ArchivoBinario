/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivobinario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20126293
 */
public class ArchivoBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArchivoBinario prueba = new ArchivoBinario();
        
  /*      prueba.escribir(3, 50);
        prueba.escribir(1, 300);
        
        System.out.println(prueba.leer(3));
        System.out.println(prueba.leer(1));
        // TODO code application logic here
        
  */
        prueba.escribirString("Hola");
        
        System.out.println(prueba.leerString());
    }
    
    public String getString(byte b[]) {
        String s = new String(b);
        
        int pos = s.indexOf('\0');
        return s.substring(0, pos);
    }
    
    public String leerString(){
        try {
            RandomAccessFile archivo =
                    new RandomAccessFile("prueba4.bin", "rw");
            
            byte[] b = new byte[10];
            archivo.read(b);
            
            String s = new String(b);
            
            return s;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void escribirString(String s) {
        try {
            RandomAccessFile archivo =
                    new RandomAccessFile("prueba4.bin", "rw");
            archivo.seek(archivo.length());
            archivo.writeBytes(getString(s, 10));
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getString(String s, int len){
        StringBuilder sb = new StringBuilder(s);
        
        sb.setLength(len);
        return sb.toString();
    }
    
    public int leer(int numReg) {
        int tReg = 4;
        
        try {
            RandomAccessFile archivo =
                    new RandomAccessFile("prueba3.bin", "rw");
            int pos = numReg * tReg;
            
            archivo.seek(pos);
            
            return archivo.readInt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
    public void escribir(int numReg, int valor) {
        try {
            int tReg = 4;
            
            RandomAccessFile archivo = new RandomAccessFile("Prueba3.bin","rw");
            
            int pos = numReg * tReg;
            archivo.seek(pos);
            archivo.writeInt(valor);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribir(){
        
        
        try {
            RandomAccessFile archivo = new RandomAccessFile("Prueba3.bin","rw");
            
            archivo.writeInt(1);
            archivo.writeInt(10);
            archivo.writeInt(100);
            archivo.writeInt(1000);
            archivo.writeInt(10000);
            /*archivo.writeFloat(100.5f);
            archivo.writeInt(1000);
            archivo.writeDouble(1000.56);
            archivo.writeLong(10000);*/
            
            archivo.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void leer(){
        RandomAccessFile archivo;
        try {
            archivo = new RandomAccessFile("Prueba3.bin","rw");
            int i;
            i = archivo.readInt();
            System.out.println(i);
            
            i = archivo.readInt();
            System.out.println(i);
            
            i = archivo.readInt();
            System.out.println(i);
            
            i = archivo.readInt();
            System.out.println(i);
            
            i = archivo.readInt();
            System.out.println(i);
        
            /*float f = archivo.readFloat();
            System.out.println(f);
           
            i = archivo.readInt();
            System.out.println(i);
            
            double d= archivo.readDouble();
            System.out.println(d);
           
            long l = archivo.readLong();
            System.out.println(l);*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
