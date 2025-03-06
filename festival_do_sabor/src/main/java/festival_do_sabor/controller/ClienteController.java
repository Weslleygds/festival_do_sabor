package festival_do_sabor.controller;

import festival_do_sabor.cliente.Cliente;
import festival_do_sabor.cliente.ClienteRepository;
import festival_do_sabor.cliente.DadosCadastroCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id ){
    repository.deleteById(id);
    }


}
