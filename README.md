LexicalDensity
====================

Antes de utilizar transferir o ficheiro <a href="http://opennlp.sourceforge.net/models-1.5/">en-pos-maxent.bin</a> para a máquina local
e substituir o PATH na linha 25 do ficheiro LexicalDensity.java, pelo PATH correspondente.

E acrescentar:

&ltdependencies&gt
        <div style="margin-left:3em">&ltdependency&gt</div>
            <div style="margin-left:6em">&ltgroupId&gtorg.apache.opennlp&lt/groupId&gt</div>
            <div style="margin-left:6em">&ltartifactId&gtopennlp-tools&lt/artifactId&gt</div>
            <div style="margin-left:6em">&ltversion&gt1.8.3&lt/version&gt</div>
            <div style="margin-left:6em">&lttype&gtjar&lt/type&gt</div>
        <div style="margin-left:3em">&lt/dependency&gt</div>
&lt/dependencies&gt<br /><br />

ao ficheiro pom.xml
