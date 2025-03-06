package festival_do_sabor.feedback;

import festival_do_sabor.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long>{
}
