package Customer.example.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Customerrepository extends JpaRepository<Customerentity, Long> {
	
	
	    Optional<Customerentity> findByCustomerId(Long customerId);
	
}
