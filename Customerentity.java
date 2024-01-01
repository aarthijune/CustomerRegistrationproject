package Customer.example.Registration;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerMaster")
public class Customerentity {
	
	
	    @Id
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "customer_id")
	    private Long customerId;

	    @Column(name = "customer_name")
	    private String customerName;

	    @Column(name = "phone")
	    private String phone;

	    @Column(name = "address")
	    private String address;

	    @Column(name = "date_of_birth")
	    private Date dateOfBirth;

	    @Column(name = "inserted_time")
	    private Date insertedTime;
	    

		public Customerentity() {
			
		}

		public Customerentity(Long customerId, String customerName, String phone, String address, Date dateOfBirth,
				Date insertedTime) {
			
			this.customerId = customerId;
			this.customerName = customerName;
			this.phone = phone;
			this.address = address;
			this.dateOfBirth = dateOfBirth;
			this.insertedTime = insertedTime;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Date getInsertedTime() {
			return insertedTime;
		}

		public void setInsertedTime(Date insertedTime) {
			this.insertedTime = insertedTime;
		}
}
