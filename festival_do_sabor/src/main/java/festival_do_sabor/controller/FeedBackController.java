package festival_do_sabor.controller;

import festival_do_sabor.cardapio.Cardapio;
import festival_do_sabor.cardapio.CardapioRequestDTO;
import festival_do_sabor.cardapio.CardapioResponseDTO;
import festival_do_sabor.feedback.FeedBack;
import festival_do_sabor.feedback.FeedBackReponseDTO;
import festival_do_sabor.feedback.FeedBackRepository;
import festival_do_sabor.feedback.FeedBackRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedBackController {
    @Autowired
    private FeedBackRepository repository;
    @GetMapping
    public List<FeedBackReponseDTO>getAll(){
        List<FeedBackReponseDTO> feedBackList = repository.findAll().stream().map(FeedBackReponseDTO::new).toList();
        return feedBackList;
    }

    @PostMapping
    public void salvarComida(@RequestBody FeedBackRequestDTO data){
        FeedBack FeedBackDados = new FeedBack(data);
        repository.save(FeedBackDados);
        return;
    }
}
