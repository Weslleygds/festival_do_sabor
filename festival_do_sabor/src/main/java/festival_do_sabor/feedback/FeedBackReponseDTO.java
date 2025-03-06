package festival_do_sabor.feedback;

import festival_do_sabor.cliente.Cliente;

public record FeedBackReponseDTO(long id, String nome, String texto) {

    public FeedBackReponseDTO(FeedBack feedBack){
        this(feedBack.getId(), feedBack.getNome(), feedBack.getTexto());
    }
}
