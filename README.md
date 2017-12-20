LexicalDensity
====================

Antes de utilizar transferir o ficheiro <a href="http://opennlp.sourceforge.net/models-1.5/">en-pos-maxent.bin</a> para a máquina local
e substituir o PATH na linha 25 do ficheiro LexicalDensity.java, pelo PATH correspondente.

E acrescentar:

\<dependencies\>
         \<dependency\>
             \<groupId\>org.apache.opennlp\</groupId\>
             \<artifactId\>opennlp-tools\</artifactId\>
             \<version\>1.8.3\</version\>
             \<type\>jar\</type\>
         \</dependency\>
 \</dependencies\>

ao ficheiro pom.xml
