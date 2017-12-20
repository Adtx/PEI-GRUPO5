LexicalDensity
====================

Antes de utilizar transferir o ficheiro <a href="http://opennlp.sourceforge.net/models-1.5/">en-pos-maxent.bin</a> para a máquina local
e substituir o PATH na linha 25 do ficheiro LexicalDensity.java, pelo PATH correspondente.

E acrescentar:

\<dependencies\><br />
        <pre>&#9</pre>\<dependency\><br />
            <pre>&#9</pre>\<groupId\>org.apache.opennlp\</groupId\><br />
            <pre>&#9</pre>\<artifactId\>opennlp-tools\</artifactId\><br />
            <pre>&#9</pre>\<version\>1.8.3\</version\><br />
            <pre>&#9</pre>\<type\>jar\</type\><br />
        <pre>&#9</pre>\</dependency\><br />
\</dependencies\><br />

ao ficheiro pom.xml
