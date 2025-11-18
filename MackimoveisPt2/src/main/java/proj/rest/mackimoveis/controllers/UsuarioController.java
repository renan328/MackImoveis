package proj.rest.mackimoveis.controllers;

import proj.rest.mackimoveis.models.Inquilino;
import proj.rest.mackimoveis.models.Proprietario;
import proj.rest.mackimoveis.models.Usuario;
import proj.rest.mackimoveis.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/proprietario")
    public Proprietario criarProprietario(@RequestBody Proprietario p) {
        return usuarioRepository.save(p);
    }

    @PostMapping("/inquilino")
    public Inquilino criarInquilino(@RequestBody Inquilino i) {
        return usuarioRepository.save(i);
    }

    @PostMapping("/auth/login")
    public boolean login(@RequestBody Usuario u) {
        Usuario usuario = usuarioRepository.findByEmail(u.getEmail());
        return usuario != null && usuario.getSenha().equals(u.getSenha());
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNome(u.getNome());
            usuario.setEmail(u.getEmail());
            usuario.setSenha(u.getSenha());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
