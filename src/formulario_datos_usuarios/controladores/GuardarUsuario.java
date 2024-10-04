package formulario_datos_usuarios.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import formulario_datos_usuarios.modelado.Usuarios;
import formulario_datos_usuarios.vista.LaminaBuscar;
import formulario_datos_usuarios.vista.LaminaFormulario;

public class GuardarUsuario implements ActionListener {
	private static int contador = 1;
	private JPanel laminaFormulario;
	private JButton botonGuardar;
	private int validacion = 0;

	public GuardarUsuario() {

	}

	public GuardarUsuario(JPanel laminaFormulario, JButton botonGuardar) {
		this.laminaFormulario = laminaFormulario;
		this.botonGuardar = botonGuardar;
	}

	private String[] mensajesErrores = { "El numereo telefonico es incorrecto intente otra vez",
			"El email es incorrecto intente otra vez",
			"La edad excede los limites de la vida humana actualmente intente otra vez",
			"La edad es incorrecta intente otra vez", "El usuario fue ingresado con exito!!!" };

	@Override
	public void actionPerformed(ActionEvent e) {

		Object tipoBoton = e.getSource();

		if (tipoBoton == botonGuardar) {
			String cedula = LaminaFormulario.listaCampo().get(0).getText();
			String nombres = LaminaFormulario.listaCampo().get(1).getText();
			String apellidos = LaminaFormulario.listaCampo().get(2).getText();

			int edad = 0;
			if (LaminaFormulario.listaCampo().get(3).getText().isEmpty()
					|| LaminaFormulario.listaCampo().get(3).getText() == null) {
				JOptionPane.showMessageDialog(laminaFormulario, "Ingrese un edad", "Error", JOptionPane.ERROR_MESSAGE);
			} else {

				if (LaminaFormulario.listaCampo().get(3).getText().matches("[0-9]*")) {
					if (Integer.parseInt(LaminaFormulario.listaCampo().get(3).getText()) < 150) {
						edad = Integer.parseInt(LaminaFormulario.listaCampo().get(3).getText());
						String direcion = LaminaFormulario.listaCampo().get(4).getText();
						if (LaminaFormulario.listaCampo().get(5).getText().contains("@")
								&& LaminaFormulario.listaCampo().get(5).getText().contains(".com")) {
							String email = LaminaFormulario.listaCampo().get(5).getText();
							if (LaminaFormulario.listaCampo().get(6).getText().matches("[0-9]*")) {
//							System.out.println(LaminaFormulario.listaCampo().get(6).getText().length());
								if (LaminaFormulario.listaCampo().get(6).getText().length() == 10) {

									String telefono = LaminaFormulario.listaCampo().get(6).getText();
									Usuarios.setGenerarUsuario(
											new Usuarios(cedula, nombres, apellidos, edad, direcion, email, telefono));
								} else {
									JOptionPane.showMessageDialog(laminaFormulario, mensajesErrores[0], "Error",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(laminaFormulario, mensajesErrores[0], "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(laminaFormulario, mensajesErrores[1], "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(laminaFormulario, mensajesErrores[2], "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(laminaFormulario, mensajesErrores[3], "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			if (Usuarios.getListaDeUsuario().size() == contador) {
				JOptionPane.showMessageDialog(laminaFormulario, mensajesErrores[4], "Ingreso exito",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon("resources/icons/realizado_con_exito.png"));
				ActulizarListaUsuario.update();
				contador++;

			}

		} else {
			for (JTextField campos : LaminaFormulario.listaCampo()) {
				campos.setText(null);
			}
		}

	}

}
