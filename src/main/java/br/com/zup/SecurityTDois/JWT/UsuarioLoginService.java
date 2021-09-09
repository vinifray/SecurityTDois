package br.com.zup.SecurityTDois.JWT;

import br.com.zup.SecurityTDois.user.Usuario;
import br.com.zup.SecurityTDois.user.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UsuarioLoginService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(username);

        usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        Usuario usuario = usuarioOptional.get();
        return new UsuarioLogin(usuario.getId(), usuario.getEmail(), usuario.getSenha());
    }
}
