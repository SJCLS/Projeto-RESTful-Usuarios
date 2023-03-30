package br.com.projeto.aula3.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.com.projeto.aula3.model.Usuario;

@Repository // Indica essa classe como um repositório
public class UsuarioRepository {
    
    // Definição dos atributos estáticos da classe
    private static String SELECT_ALL = "SELECT * FROM USUARIO";
    private static String INSERT = "INSERT INTO USUARIO (nome,email,senha) VALUES(?,?,?)";
    private static String DELETE = "DELETE FROM USUARIO WHERE id = ?";
    private static String UPDATE = "UPDATE USUARIO SET nome = ?, email = ?, senha = ? WHERE id = ?";
    private static String AUTENTICATE = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";

    // Injeção de dependência JDBCTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Métodos

    // Insere um usuário na tabela
    public Usuario inserir(Usuario usuario) {
        // O método "update" executa uma instrução SQL que não retorna resultados, neste caso, a inserção de um novo usuário na tabela
        jdbcTemplate.update(INSERT, new Object[] {
                usuario.getNome(), usuario.getEmail(), usuario.getSenha()
        });
        return usuario;
    }

    // Seleciona todos os usuários da tabela
    public List<Usuario> obterTodos() {
        // O método "query" executa uma instrução SQL que retorna resultados em forma de lista,  neste caso, retorna todos os usuários da tabela
        return jdbcTemplate.query(SELECT_ALL,
                Usuario.getRowMapper());
    }

    // Remove um usuário da tabela com base em seu ID
    public void remover(int idUsuario){
        // O método "update" executa uma instrução SQL que não retorna resultados, neste caso, remove um usuário da tabela com base em seu ID
        jdbcTemplate.update(DELETE, idUsuario);
    }

    // Remove um dado usuário da tabela
    public void remover(Usuario usuario){
        // O método "update" executa uma instrução SQL que não retorna resultados, neste caso, remove um usuário da tabela com base em um objeto de usuário
        jdbcTemplate.update(DELETE, usuario.getId());
    }

    // Edita um usuário
    public Usuario editar(Usuario usuario){
        // O método "update" executa uma instrução SQL que não retorna resultados, neste caso, atualiza as informações de um usuário na tabela com base em um objeto de usuário
        jdbcTemplate.update(UPDATE, new Object[]{
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getId()
        });
        return usuario;
    }

    // Autentica a existência de um usuário e sua senha
    public boolean autenticar(String email, String senha){
        // O método "query" executa uma instrução SQL que retorna resultados em forma de lista, neste caso, verifica se há um usuário na tabela com o email e senha informados
        List<Usuario> listaAutenticacao = jdbcTemplate.query(AUTENTICATE,Usuario.getRowMapper(), new Object[]{
            email,
            senha
        });

        return listaAutenticacao.size() > 0;
    }
}
