package festival_do_sabor.controller;

import festival_do_sabor.cardapio.Cardapio;
import festival_do_sabor.cardapio.CardapioRepository;
import festival_do_sabor.cardapio.CardapioRequestDTO;
import festival_do_sabor.cardapio.CardapioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardapio")
public class CardapioController {
    @Autowired
    private CardapioRepository repository;

    @PostMapping
    public void salvarComida(@RequestBody CardapioRequestDTO data){
        Cardapio cardapioDados = new Cardapio(data);
        repository.save(cardapioDados);
    }
    @GetMapping
    public List <CardapioResponseDTO> getAll(){
        List<CardapioResponseDTO> cardapio = repository.findAll().stream().map(CardapioResponseDTO::new).toList();
        return cardapio;
    }
}
