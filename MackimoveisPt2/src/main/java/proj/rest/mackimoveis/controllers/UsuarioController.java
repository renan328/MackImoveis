package proj.rest.mackimoveis.controllers;

import proj.rest.mackimoveis.models.Usuario;
import proj.rest.mackimoveis.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepo.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNome(u.getNome());
            usuario.setEmail(u.getEmail());
            usuario.setSenha(u.getSenha());
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepo.deleteById(id);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario login) {
        Usuario usuario = usuarioRepo.findByEmail(login.getEmail());
        return usuario != null && usuario.getSenha().equals(login.getSenha());
    }
}
