
public class Persona {
	
	private String name;
	private String lastname;
	private boolean deleted;

	public Persona(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		
		return "Person{" + "nombre: "+ name + ", apellido: " + 
		lastname + ", borrado: " + deleted + '}';
		
	}

}
