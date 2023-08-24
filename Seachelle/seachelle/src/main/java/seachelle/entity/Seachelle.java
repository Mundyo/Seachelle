package seachelle.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Seachelle {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long seachelleId;
	private String SeachelleName;
	private String SeachelleAddress;
	private String SeachelleCity;
	private String SeachelleState;
	private String SeachelleZip;
	private String SeachellePhone;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "seachelle_customer",
	     joinColumns = @JoinColumn( name = "seachelle_id"),
	     inverseJoinColumns = @JoinColumn(name = "customer_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Customer> customers = new HashSet<>();
	
	@OneToMany(mappedBy = "seachelle", cascade = CascadeType.ALL,
			orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Employee> employees = new HashSet<>();
	

}
