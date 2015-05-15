package es.iesazarquiel.biblioteca.models.entidades;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Socio {
	public SimpleLongProperty id=new SimpleLongProperty();
    public SimpleStringProperty email=new SimpleStringProperty();
    public SimpleStringProperty nombre=new SimpleStringProperty();
    public SimpleStringProperty direccion=new SimpleStringProperty();
    public SimpleStringProperty clave=new SimpleStringProperty();

	public Socio() {
    }

    public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email); 
	}

	public void setId(long idsocio) {
        this.id.set(idsocio);
    }

    public long getId() {
        return id.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getDireccion() {
        return direccion.get();
    }
    public String getClave() {
		return clave.get();
	}

	public void setClave(String clave) {
		this.clave.set(clave);
	}    
}
