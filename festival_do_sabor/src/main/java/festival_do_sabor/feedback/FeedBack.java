package festival_do_sabor.feedback;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "feedback")
@Entity(name = "FeedBack")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String texto;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public String getTexto() {
        return texto;
    }

    public FeedBack(FeedBackRequestDTO data){
        this.nome = data.nome();
        this.texto = data.texto();
    }
}
