package br.com.projeto.aula3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.aula3.model.Usuario;
import br.com.projeto.aula3.repository.UsuarioRepository;

@RestController // Indica que essa classe é um controlador REST
// @RequestMapping("/usuarios") // Prefixo para as rotas definidas nesse controlador
public class UsuarioController {

    @Autowired // Injeção de dependência do objeto UsuarioRepository
    private UsuarioRepository usuarioRepository;

    // Mapeamento para a rota GET
    @GetMapping("/testar")
    public String teste() {
        return "Ola Mundo";
    }

    // Mapeamento para a rota GET /usuarios/visualizar
    @GetMapping("/visualizar")
    public List<Usuario> obterTodos() {
        return usuarioRepository.obterTodos();
    }

    // Mapeamento para a rota POST /usuarios/cadastrar
    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.inserir(usuario);
    }

    // Mapeamento para a rota PUT /usuarios/editar
    @PutMapping("/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.editar(usuario);
    }

    // Mapeamento para a rota DELETE /usuarios/deletar/{id}
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable int id) {
        usuarioRepository.remover(id);
    }

    // Mapeamento para a rota DELETE /usuarios/deletar
    @DeleteMapping("/deletar")
    public Usuario deletarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.remover(usuario);
        return usuario;
    }

    // Mapeamento para a rota POST /usuarios/autenticar
    @PostMapping("/autenticar")
    public boolean autenticarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.autenticar(usuario.getEmail(), usuario.getSenha());
    }
}


<main>
<h1>Projeto RESTful Usuarios</h1>
	<p>Este projeto é um exemplo de aplicação RESTful desenvolvido com o Spring Boot Framework.</p>
	
	<h2>Tecnologias Utilizadas</h2>
	<ul>
		<li>Java 11</li>
		<li>Spring Boot Framework</li>
		<li>MySQL Database</li>
		<li>Postman (para testar as rotas)</li>
	</ul>

	<h2>Como executar o projeto</h2>
	<ol>
		<li>Faça o download ou clone este repositório.</li>
		<li>Abra o projeto em sua IDE de preferência.</li>
		<li>Configure o arquivo application.properties com suas informações de conexão com o banco de dados MySQL.</li>
		<li>Execute a classe Aula3Application para iniciar a aplicação.</li>
		<li>Utilize o Postman para testar as rotas disponíveis.</li>
	</ol>

	<h2>Rotas Disponíveis</h2>
	<table>
		<thead>
			<tr>
				<th>Método HTTP</th>
				<th>URL</th>
				<th>Descrição</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>GET</td>
				<td>/testar</td>
				<td>Retorna uma mensagem de "Olá Mundo" para testar se a aplicação está funcionando corretamente.</td>
			</tr>
			<tr>
				<td>GET</td>
				<td>/visualizar</td>
				<td>Retorna uma lista com todos os usuários cadastrados no banco de dados.</td>
			</tr>
			<tr>
				<td>POST</td>
				<td>/cadastrar</td>
				<td>Cadastra um novo usuário no banco de dados.</td>
			</tr>
			<tr>
				<td>PUT</td>
				<td>/editar</td>
				<td>Edita as informações de um usuário já cadastrado no banco de dados.</td>
			</tr>
			<tr>
				<td>DELETE</td>
				<td>/deletar/{id}</td>
				<td>Deleta um usuário do banco de dados, utilizando seu ID como parâmetro.</td>
			</tr>
			<tr>
				<td>DELETE</td>
				<td>/deletar</td>
				<td>Deleta um usuário do banco de dados, utilizando o objeto Usuario como parâmetro.</td>
			</tr>
			<tr>
				<td>POST</td>
				<td>/autenticar</td>
				<td>Autentica um usuário no banco de dados, utilizando seu email e senha como parâmetros.</td>
			</tr>
		</tbody>
	</table>
</main>

<footer>
	<p>&copy; 2023 Projeto Aula 3</p>
</footer>
