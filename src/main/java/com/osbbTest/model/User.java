package com.osbbTest.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;
    
    @Column(name = "lastname", nullable = false)
    private String lastname;   

	@Column(name = "password", nullable = false)
    private String password;
   
	@Column(name = "email", nullable = false,unique=true)
    private String email;
	
	/*@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)	
	  @JoinColumn(name="house_ID")*/
	//@JoinTable(name="houses", joinColumns =@JoinColumn(name = "house_id"))*/
//		inverseJoinColumns=@JoinColumn(name="house_id",insertable=false, updatable=false) )
/*	private House house;	*/

	 
	 @Column(name = "enabled", nullable = false)
	private boolean enabled;
		

	@Column(name = "room", nullable = false)
	private int roomNumber;	

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<Role> roles;
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Counter.class)
	@JoinTable(name = "user_counter", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "counter_id") })
	private Set<Counter> counters;	
*/
	public User(){	}
	
	public User(String firstname, String lastname, String password, String email, boolean enabled,
			int roomNumber) {
		super();		
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.roomNumber = roomNumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
   
    /*public Set<Counter> getCounters() {
		return counters;
	}

	public void setCounters(Set<Counter> counters) {
		this.counters = counters;
	}*/
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb
				.append("User: { name: ").append(firstname).append(" ").append(lastname).append(", ")				
				.append("email: ").append(email).append(", ")
				.append("roles: ").append(roles).append(" }");
		return sb.toString();
		}
}
