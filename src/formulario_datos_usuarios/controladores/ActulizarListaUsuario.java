package formulario_datos_usuarios.controladores;

import formulario_datos_usuarios.vista.LaminaBuscar;

public class ActulizarListaUsuario {

	public static void update() {

		LaminaBuscar.getCajaPrincipal().removeAll();
		LaminaBuscar.generarBox().revalidate();
		LaminaBuscar.generarBox().removeAll();
		LaminaBuscar.generarBox();
		LaminaBuscar.getCajaPrincipal().revalidate();
		LaminaBuscar.getCajaPrincipal().repaint();

	}

}
