package formulario_datos_usuarios.modelado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Usuarios {

	public Usuarios(String cedula, String nombre, String apellido, int edad, String direccion, String email,
			String telefono) {
		getFechaIngreso();
		this.cedula = cedula;
		this.nombre = nombre;
		Apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}

	private void getFechaIngreso() {
		fechaIngreso[0] = String.valueOf(LocalDateTime.now().getYear());
		fechaIngreso[1] = String.valueOf(LocalDateTime.now().getMonth());
		fechaIngreso[2] = String.valueOf(LocalDateTime.now().getDayOfMonth());
		fechaIngreso[3] = String.valueOf(LocalDateTime.now().getHour());
		fechaIngreso[4] = String.valueOf(LocalDateTime.now().getMinute());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public static void setGenerarUsuario(Usuarios user) {
		listaDeUsuario.add(user);
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public static ArrayList<Usuarios> getListaDeUsuario() {
		return listaDeUsuario;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", Apellido=" + Apellido + ", edad=" + edad + ", direccion=" + direccion
				+ ", email=" + email + ", telefono=" + telefono + ", cedula=" + cedula + ", fechaIngreso="
				+ Arrays.toString(fechaIngreso) + "]";
	}

	private static ArrayList<Usuarios> listaDeUsuario = new ArrayList<Usuarios>();

	private String nombre;
	private String Apellido;
	private int edad;
	private String direccion;
	private String email;
	private String telefono;
	private String cedula;
	private String[] fechaIngreso = new String[5];
}
