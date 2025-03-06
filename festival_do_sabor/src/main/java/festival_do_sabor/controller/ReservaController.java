package festival_do_sabor.controller;

import festival_do_sabor.feedback.FeedBack;
import festival_do_sabor.reserva.ReservaDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class ReservaController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/reservas")
    public ResponseEntity<String> criarReserva(@Validated @RequestBody ReservaDTO reservaDTO) {
        // Verificar se o usuário está autenticado
        if (!usuarioAutenticado()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não autenticado");
        }

        // Enviar e-mails para o cliente e para o restaurante
        enviarEmailCliente(reservaDTO);
        enviarEmailRestaurante(reservaDTO);

        return ResponseEntity.ok("Reserva criada com sucesso!");
    }

    private boolean usuarioAutenticado() {
        // Obter o HttpServletRequest atual
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // Verificar se há um objeto de autenticação no contexto de segurança
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar se a autenticação não é nula e se o usuário está autenticado
        return authentication != null && authentication.isAuthenticated();
    }


    private void enviarEmailCliente(ReservaDTO reservaDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("weslleyg272@gmail.com"); // Substitua pelo e-mail do cliente
        message.setSubject("Confirmação de Reserva");
        message.setText("Sua reserva foi confirmada. Obrigado por escolher nosso restaurante!");
        emailSender.send(message);
    }

    private void enviarEmailRestaurante(ReservaDTO reservaDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("weslleygsilva17@gmail.com"); // Substitua pelo e-mail do restaurante
        message.setSubject("Nova Reserva");
        message.setText("Uma nova reserva foi feita. Detalhes:\n" +
                "Nome: " + reservaDTO.getNomeCompleto() + "\n" +
                "Data: " + reservaDTO.getData() + "\n" +
                "Horário: " + reservaDTO.getHorario() + "\n" +
                "Ambiente: " + reservaDTO.getAmbiente());
        emailSender.send(message);
    }
}
