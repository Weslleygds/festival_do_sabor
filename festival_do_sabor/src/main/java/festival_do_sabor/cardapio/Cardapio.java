package festival_do_sabor.cardapio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cardapio")
@Entity(name = "cardapio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String imagem;
    private String preço;

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public String getPreço() {
        return preço;
    }

    public Cardapio(CardapioRequestDTO data){
        this.imagem = data.imagem();
        this.preço = data.preço();
        this.titulo = data.titulo();
    }
}


