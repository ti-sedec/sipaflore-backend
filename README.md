# SIPAFLORE
Backend do Sistema de Pagamento da Taxa de Reposição Florestal.

## Descrição

O projeto SIPAFLORE é uma aplicação web desenvolvida em Java 17 utilizando o framework Spring Boot.
Esta aplicação oferece recursos para cadastro, manutenção e análises de documentos no contexto de reposição florestal do Estado do Mato Grosso.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- MySQL ou Postgres
- Maven
- Liquibase
- Hibernate Envers

## Pré-requisitos
Antes de começar, certifique-se de ter instalado em sua máquina:

- Java 17 SDK
- MySQL ou Postgres

## Instalação e Configuração
1. Clone este repositório: `git clone https://github.com/CityConnectBr/sedec-sipaflore-back.git`
2. Navegue até o diretório do projeto.
3. Configure o arquivo `application-dev.properties` localizado em src/main/resources com as configurações de conexão com seu banco de dados e porta da aplicação:
```
server.port={porta}
spring.datasource.username={seu_usuario}
spring.datasource.password={sua_senha}

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/sedec_sipaflore_mt

# Postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/sedec_sipaflore_mt
```
4. Crie um banco de dados com o nome `sedec_sipaflore_mt` no MySQL ou Postgres. Se utilizar o Postgres, em seguida deve criar um schema chamado `sedec_sipaflore_mt`. **Importante**: utilizar o encode UTF-8.
5. Este projeto utiliza o Hibernate Envers para auditoria de entidades de manutenção. Se optar pelo MySQL, crie um banco de dados com o nome `sedec_sipaflore_mt_aud`. Se utilizar o Postgres, crie um novo schema chamado `sedec_sipaflore_mt_aud` no banco de dados criado no passo anterior. **Importante**: utilizar o encode UTF-8.
6. Execute o comando para instalar as dependência e gerar o pacote do projeto: **mvn clean install**
6. Execute o projeto com o comando: **mvn spring-boot:run**

## Documentação
1. É possível acessar a documentação da aplicação presente no Swagger através do endereço: `http://localhost:{porta}/swagger-ui/index.html#/`
2. Clique no botão **Authorize**:
   ![Representação do botão Authorize](https://i.imgur.com/Z7ebPVl.png "Botão Authorize")
3. Insira o token de autenticação obtido do login no sistema mt-login:
   ![Inputs para inserção de Bearer token obtido através do mt-login.](https://i.imgur.com/9Kt5wbF.png "Campos para inserção de token")
4. Clique em **Authorize** para autorizar os endpoints privados.
5. Clique em **Close** e acesse os endpoints disponíveis na aplicação.

## Informações úteis
- O projeto utiliza o padrão de autenticação Bearer Token, onde o usuário deve inserir o token de autenticação obtido no sistema mt-login para acessar os endpoints privados.
- Este projeto utiliza o formato RSQL para filtragem de dados, o que facilita as consultas dos principais endpoints do projeto. Para mais informações sobre o formato, acesse o link: [RSQL Doc](https://github.com/jirutka/rsql-parser)
- Exemplo de consulta utilizando RSQL: `GET /municipios?search=nome==cuiab*` que equivale a `SELECT * FROM tb_municipio WHERE UPPER(nome) LIKE UPPER('cuiab%')`

## Contato
Se tiver alguma dúvida ou sugestão, entre em contato com a equipe de desenvolvimento da [City Connect](https://cityconnect.com.br/).