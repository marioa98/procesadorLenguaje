
package procesadordelenguaje;

import java.io.*;

public class usaProcesador {
    
    public static void main(String[] args)throws IOException{
        
        ProcesadorDeLenguaje p = new ProcesadorDeLenguaje();
        
        File file = new File("C:\\Users\\mario\\OneDrive\\Escritorio\\archivo1.txt");
        File file2 = new File("C:\\Users\\mario\\OneDrive\\Escritorio\\archivo2.txt");
        File file3 = new File("C:\\Users\\mario\\OneDrive\\Escritorio\\archivo3.txt");
        
        System.out.println("======= Palabras repetidas en los escritos =======");
        System.out.println(p.totalPalabras(file));
        System.out.println(p.totalPalabras(file2));
        System.out.println(p.totalPalabras(file3));
        
        System.out.println("\n======= Palabras sin repetir en cada escrito =======");
        System.out.println(p.palabrasSinRepetir(file));
        System.out.println(p.palabrasSinRepetir(file2));
        System.out.println(p.palabrasSinRepetir(file3));
        
        System.out.println("\n======= Sílabas en cada escrito =======");
        System.out.println(p.totalSilabas(file));
        System.out.println(p.totalSilabas(file2));
        System.out.println(p.totalSilabas(file3));
        
        System.out.println("\n======= Caracteres en cada escrito =======");
        System.out.println(p.totalCaracteres(file));
        System.out.println(p.totalCaracteres(file2));
        System.out.println(p.totalCaracteres(file3));
        
        File[] files ={file, file2, file3};
        
        System.out.println("\n======= Palabras sin repetir en "+files.length+" escritos =======");
        p.totalPalabrasSinRepetir(files);
        
    }
}
