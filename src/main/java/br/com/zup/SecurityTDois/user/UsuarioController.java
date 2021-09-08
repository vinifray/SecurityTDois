package br.com.zup.SecurityTDois.user;

import br.com.zup.SecurityTDois.user.dtos.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioObjeto = usuarioService.cadastrarUsuario(usuario);
        return modelMapper.map(usuarioObjeto, UsuarioDTO.class);
    }

    @GetMapping("/{idUsuario}")
    public UsuarioDTO pesquisarUsuarioPeloId(@PathVariable(name = "idUsuario") int id) {
        try {
            Usuario usuarioObjeto = usuarioService.buscarUsuarioPeloId(id);
            return modelMapper.map(usuarioObjeto, UsuarioDTO.class);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
