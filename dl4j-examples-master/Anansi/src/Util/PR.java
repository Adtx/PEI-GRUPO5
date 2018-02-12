import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PR {

        public static void main(String[] args) {
            Map<String,Integer> Hashpalavras =new HashMap<String,Integer>();

            //Usando uma string como exemplo
            String texto = "Para contar quantas isn't palavras existem no texto, primeiro temos que definir o que são palavras,";

            //Usando um ficheiro .txt, criar um ficheiro e indicar caminho
            /* final String FILENAME = "C:\\Users\\Stéphane\\Desktop\\teste.txt";
            String texto = null;
            try { texto = readFile(FILENAME); }
            catch (IOException e) { e.printStackTrace(); }
            */

            //Por tudo em  minusculo sem pontos e virgulas ou espaços no começo e fim
            texto = texto.replaceAll("[,.]", "");
            texto = texto.toLowerCase();
            texto = texto.trim();

            //separar as palavras
            String[] palavras = texto.split(" ");

            for (String palavra : palavras) {
                if(Hashpalavras.containsKey(palavra)){
                    Hashpalavras.replace(palavra,Hashpalavras.get(palavra)+1);
                }
                else Hashpalavras.put(palavra,1);
            }
            //imprimir palavras e numero de ocorrencias
            for (String key : Hashpalavras.keySet()) {
                System.out.println(key + " " + Hashpalavras.get(key));
            }
        }

        //função auxiliar para o caso de querer usar um ficheiro .txt
        static String readFile(String file) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader (file));
            String         line = null;
            StringBuilder  stringBuilder = new StringBuilder();
            String         ls = System.getProperty("line.separator");

            try {
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                return stringBuilder.toString();
            } finally {
                reader.close();
            }
        }

}

