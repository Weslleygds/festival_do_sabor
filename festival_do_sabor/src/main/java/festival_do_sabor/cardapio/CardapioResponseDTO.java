package festival_do_sabor.cardapio;

public record CardapioResponseDTO(long id, String titulo, String imagem, String preço) {

    public CardapioResponseDTO (Cardapio cardapio){
        this (cardapio.getId(), cardapio.getTitulo(), cardapio.getImagem(), cardapio.getPreço());
    }
}
