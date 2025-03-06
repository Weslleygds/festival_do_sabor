package festival_do_sabor.cliente;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

public record DadosCadastroCliente(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String senha,
        @Basic
        @Temporal(TemporalType.DATE)
         @DateTimeFormat(pattern = "dd/MM/yyyy")
        String data_de_nascimento,
        String regiao_onde_vive
){

}
