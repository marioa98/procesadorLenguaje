
package procesadordelenguaje;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProcesadorDeLenguaje {
   
    public static String totalPalabras(File file) throws IOException{
        
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        
        String line;
        int countWord=0;
        while((line = reader.readLine())!= null){
            
            if(!(line.equals(""))){
                
                //Sirve para delimitar los espacios en Java
                String[] wordList = line.split("\\s+");
                countWord += wordList.length;
            }
        }
        
        reader.close();
        
        return "Total de palabras en el archivo "+file.getName()+": "+countWord;
    }
    
    public static String palabrasSinRepetir(File file)throws IOException{
        
        Map<String, Integer> words = new HashMap<String, Integer>();
        
        String line = "";
        int countWord=0;
        
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        
        while((line = reader.readLine()) != null){
            line.replaceAll("[a-zA-Z09]+","");
            
            String[] wordLine = line.split("\\s+");
            for(String w : wordLine){
                if(!words.containsKey(w.toLowerCase()))
                    words.put(w.toLowerCase(), 1);
                else
                    words.put(w.toLowerCase(),words.get(w.toLowerCase()) +1);
            }
        }
        
        reader.close();
        
        for(Map.Entry<String, Integer> e : words.entrySet()){
            countWord += 1;
        }
        
        reader.close();
        
        return "Total de palabras sin repetir en el archivo "+file.getName()+": "+countWord;
                
    }
    
    public static void totalPalabrasSinRepetir(File[] files) throws IOException{
        
        int countWord = 0;
        String line = "";
        Map<String, Integer> words = new HashMap<String, Integer>();
        
        for(int i = 0; i<files.length; i++){
            FileInputStream fileStream = new FileInputStream(files[i]);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);
            
            while((line = reader.readLine()) != null){
                line.replaceAll("[a-zA-Z0-9]+","");
                
                String[] wordLine = line.split("\\s+");
                for(String w : wordLine){
                    if(!words.containsKey(w.toLowerCase()))
                        words.put(w.toLowerCase(), 1);
                    else
                        words.put(w.toLowerCase(),words.get(w.toLowerCase()) +1);
                }
            }
            
            reader.close();
        }
        
        for(Map.Entry<String, Integer> e : words.entrySet()){
            countWord += 1;
        }
        
        System.out.println("Total: "+countWord);
    }
    
    public static String totalCaracteres(File f) throws IOException{
        FileInputStream fs = new FileInputStream(f);
        InputStreamReader input = new InputStreamReader(fs);
        BufferedReader reader = new BufferedReader(input);
        
        String line;
        int characterCount = 0;
        
        while((line = reader.readLine()) != null){
            if(!(line.equals(""))){
                characterCount += line.length();
            }
        }
        
        String total = "Total de caracteres en el archivo "+ f.getName()
                +": "+characterCount;
        
        
        reader.close();
        return total;
    }
    
    public static String totalSilabas(File f)throws IOException{
        FileInputStream fs = new FileInputStream(f);
        InputStreamReader input = new InputStreamReader(fs);
        BufferedReader reader = new BufferedReader(input);

        int syllables = 0;
        String line;
        
        while((line = reader.readLine())!=null){
            syllables += contarSilabas(line);
        }
        
        String total = "Total de silabas en "+f.getName()+
                ": "+syllables;
        reader.close();
        return total;
    }
    
    public static int contarSilabas(String word){
        int count = 0;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '\"' || word.charAt(i) == '\'' || word.charAt(i) == '-' || word.charAt(i) == ',' || word.charAt(i) == ')' || word.charAt(i) == '(') {
                word = word.substring(0,i)+word.substring(i+1, word.length());
            }
        }
        boolean isPrevVowel = false;
        for (int j = 0; j < word.length(); j++) {
            if (word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")) {
                if (esVocal(word.charAt(j)) && !((word.charAt(j) == 'e') && (j == word.length()-1))) {
                    if (isPrevVowel == false) {
                        count++;
                        isPrevVowel = true;
                    }
                } else {
                    isPrevVowel = false;
                }
            } else {
                count++;
                break;
            }
        }
        return count;
    }
    
    public static boolean esVocal(char c){
        
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }
    
}
