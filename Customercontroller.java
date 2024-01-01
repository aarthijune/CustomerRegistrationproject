package Customer.example.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/customer")
public class Customercontroller {
	
	
	@Autowired
    private Customerservice customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customerentity customer) {
        String result = customerService.registerCustomer(customer);
        if (result.equals("Success")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("Customer already registered")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
           
            }
         else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to perform the operation ");
        }
    }

    @GetMapping("/details/{customerId}")
    public ResponseEntity<?> getCustomerDetails(@PathVariable Long customerId) {
        Customerentity customer = customerService.getCustomerDetails(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer does not exist");
        }
    }
	    }

// or 

/*@Autowired
private Customerservice customerService;

@PostMapping("/register")
public String registerCustomer(@RequestBody Customerentity customer) {
    return customerService.registerCustomer(customer);
}

@GetMapping("/details/{customerId}")
public Object getCustomerDetails(@PathVariable Long customerId) {
    Customerentity customer = customerService.getCustomerDetails(customerId);
    if (customer != null) {
        return customer;
    } else {
        return "Customer does not exist";
    }}


@Autowired
	    private Customerservice customerService;

	    @PostMapping("/register")
	    public String registerCustomer(@RequestBody Customerentity customer) {
	        return customerService.registerCustomer(customer);
	    }

	    @GetMapping("/details/{customerId}")
	    
	    public ResponseEntity<?> getCustomer(@PathVariable String customerId) {
	        try {
	        	
	        	Long id=Long.parseLong(customerId);
	            return customerService.getCustomerDetails(id);
	        } catch (NumberFormatException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed,invalid customer Id format");
	        }
	        catch(Exception e) {
	       	 //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unable to perform the operation");
	        	 return new ResponseEntity<>("{\"status\": \"Unable to perform the operation\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	          
	       }
	 
	    
	       
	    }*/	  

