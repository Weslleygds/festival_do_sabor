package festival_do_sabor.controller;

import festival_do_sabor.cliente.Cliente;
import festival_do_sabor.cliente.DadosAutenticacao;
import festival_do_sabor.security.DadosTokenJWT;
import festival_do_sabor.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var  authentication = manager.authenticate(authenticationTokentoken);

        var tokenJWT = tokenService.gerartoken((Cliente) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}