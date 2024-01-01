package Customer.example.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class Customerservice {
	@Autowired
	    private Customerrepository customerRepository;

	    public String registerCustomer(Customerentity customer) {
	        Optional<Customerentity> existingCustomer = customerRepository.findByCustomerId(customer.getCustomerId());
	        if (existingCustomer.isPresent()) {
	            return "Customer already registered";
	        }

	        try {
	            customer.setInsertedTime(new Date());
	            customerRepository.save(customer);
	            return "Success";
	        } catch (Exception e) {
	            return "Failed";
	        }
	    }

	    public Customerentity getCustomerDetails(Long customerId) {
	        Optional<Customerentity> customer = customerRepository.findByCustomerId(customerId);
	        return customer.orElse(null);
	    }
	    /*     @Autowired
	    private Customerrepository customerRepository;
		 public String registerCustomer(Customerentity customer) {
		        Optional<Customerentity> existingCustomer = customerRepository.findById(customer.getCustomerId());
		        if (existingCustomer.isPresent()) {
		            return "Customer already registered";
		        }

		        try {
		            customer.setInsertedTime((Timestamp) new Date());
		            customerRepository.save(customer);
		            return "Success";
		        } catch (Exception e) {
		            return "Failed";
		        }
		    }

		 public ResponseEntity<?> getCustomerDetails(Long customerId) {
		        Optional<Customerentity> customerOptional = customerRepository.findByCustomerId(customerId);

		        if (customerOptional.isPresent()) {
		            Customerentity customer = customerOptional.get();
		            return ResponseEntity.ok().body(customer);
		        } else {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer does not exist");
		        }
		    }
*/
		

}