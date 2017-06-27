# cadastrar-aluno - Adição, alteração e remoção de alunos com Apache Derby
Laboratório de Desenvolvimento de Software para a Web de 2017/1.

## Obtendo o projeto

`git clone https://github.com/pedlop/cadastrar-aluno`

## Executando a aplicação

`mvn org.apache.tomcat.maven:tomcat7-maven-plugin:run -Dmaven.tomcat.port=9090`

ou

`./mvnw tomcat7:run`

## Acessando a aplicação

Acesse `http://localhost:9090/cadastrando-aluno` em qualquer navegador.

## Como o projeto foi construído

### "Embutindo" o Maven

Para que não seja necessário instalar e configurar o Maven, ele foi embutido no projeto com o seguinte comando:

`mvn io.takari:maven:0.3.3:wrapper -Dmaven=3.3.9`
