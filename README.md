<h1>Projeto Aula 3</h1>
<h2>Sobre o projeto</h2>
<p>Esse é um projeto de exemplo para a aula 3 do curso de Spring Boot. O objetivo do projeto é demonstrar como criar uma API RESTful utilizando o Spring Boot e o banco de dados H2 Database .</p>
<h2>Tecnologias utilizadas</h2>
<ul>
  <li>Java</li>
  <li>Spring Boot</li>
  <li>H2 Database</li>
  <li>Java Persistence API</li>
</ul>
<h2>Como rodar o projeto</h2>
<ol>
  <li>Clone o repositório do projeto</li>
  <li>Crie um banco de dados MySQL com o nome "aula3"</li>
  <li>Configure as credenciais do banco de dados no arquivo "application.properties" localizado em "src/main/resources"</li>
  <li>Rode o projeto utilizando o comando "mvn spring-boot:run" na raiz do projeto</li>
  <li>Acesse a API em "http://localhost:8080"</li>
</ol>
<h2>Rotas disponíveis</h2>
<ul>
  <li>GET /testar - Teste simples para verificar se a API está funcionando</li>
  <li>GET /visualizar - Retorna todos os usuários cadastrados</li>
  <li>POST /cadastrar - Cadastra um novo usuário</li>
  <li>PUT /editar - Edita um usuário existente</li>
  <li>DELETE /deletar/{id} - Deleta um usuário pelo seu ID</li>
  <li>DELETE /deletar - Deleta um usuário</li>
  <li>POST /autenticar - Autentica um usuário pelo email e senha</li>
</ul>
<h2>Contribuições</h2>
<p>Contribuições são sempre bem-vindas! Sinta-se livre para criar um pull request ou abrir uma issue.</p>
