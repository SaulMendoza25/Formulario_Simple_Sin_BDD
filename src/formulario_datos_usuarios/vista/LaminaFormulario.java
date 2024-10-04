package formulario_datos_usuarios.vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import formulario_datos_usuarios.controladores.GuardarUsuario;

public class LaminaFormulario extends JPanel {

	private static final long serialVersionUID = 844521755703011758L;
	private static JTextField cedula = new JTextField(), nombres = new JTextField(), apellidos = new JTextField(),
			edad = new JTextField(), direccion = new JTextField(), email = new JTextField(),
			telefono = new JTextField();
	private JButton botonGuardar = new JButton();
	private JButton botonLimpiar = new JButton();

	public LaminaFormulario() {
		setLayout(new BorderLayout());
		estiloBotones();
		add(LaminaSuperior(), BorderLayout.NORTH);
		JScrollPane miPanelFormulario = new JScrollPane(LaminaCentral());
//		miPanelFormulario.setBackground(Color.white);
		miPanelFormulario.setBorder(BorderFactory.createEmptyBorder());
		add(miPanelFormulario, BorderLayout.CENTER);

	}

	private JPanel LaminaSuperior() {
		JLabel formularioTitle = new JLabel("Crear Usuario");
		formularioTitle.setFont(new Font("Serial", Font.BOLD, 32));
		JPanel LaminaTitulo = new JPanel();
//		LaminaTitulo.setBackground(new Color(245, 245, 220));
		LaminaTitulo.add(formularioTitle, FlowLayout.LEFT);
		return LaminaTitulo;
	}

	private JPanel LaminaCentral() {
		JPanel laminaCentral = new JPanel();
		JPanel laminaFormulario = new JPanel();
		laminaFormulario.setBackground(Color.WHITE);
		laminaFormulario.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		laminaFormulario.setLayout(new MyLayoutFormulario());

		JLabel formularioTitle = new JLabel("Crear Usuario");
		formularioTitle.setFont(new Font("Serial", Font.BOLD, 32));

		String[] camposTexto = { "Cédula:", "Nombres:", "Apellidos:", "Edad:", "Dirección:", "Email:", "Telefóno:" };
		for (int i = 0; i < camposTexto.length; i++) {
			JLabel campoTexto = new JLabel(camposTexto[i]);
			campoTexto.setFont(new Font("Serial", Font.BOLD, 18));
			laminaFormulario.add(campoTexto);
			switch (i) {
			case 0 -> laminaFormulario.add(cedula);
			case 1 -> laminaFormulario.add(nombres);
			case 2 -> laminaFormulario.add(apellidos);
			case 3 -> laminaFormulario.add(edad);
			case 4 -> laminaFormulario.add(direccion);
			case 5 -> laminaFormulario.add(email);
			case 6 -> laminaFormulario.add(telefono);

			}

		}

		botonGuardar.addActionListener(new GuardarUsuario(this, botonGuardar));

		botonLimpiar.addActionListener(new GuardarUsuario());
		Box grupoBotones = Box.createHorizontalBox();
		grupoBotones.add(Box.createHorizontalStrut(200));
		grupoBotones.add(botonGuardar);
		grupoBotones.add(Box.createHorizontalStrut(50));
		grupoBotones.add(botonLimpiar);

		laminaFormulario.add(grupoBotones);
		laminaCentral.add(laminaFormulario);

		return laminaCentral;
	}

	private void estiloBotones() {
		JLabel textoCrear = new JLabel("Crear Usuario");
		botonGuardar.setFont(new Font("Serial", Font.BOLD, 13));
		botonGuardar.setForeground(Color.BLACK);
		botonGuardar.add(textoCrear);
		JLabel textoLimipar = new JLabel("Limpiar");
		botonLimpiar.setFont(new Font("Serial", Font.BOLD, 13));
		botonLimpiar.setForeground(Color.BLACK);
		botonLimpiar.add(textoLimipar);
	}

	private class MyLayoutFormulario implements LayoutManager {

		@Override
		public void addLayoutComponent(String name, Component comp) {
			// TODO Auto-generated method stub

		}

		@Override
		public void layoutContainer(Container e) {

			int x = 50;
			int y = 50;
			int contador = 0;
			int n = e.getComponentCount();
			for (int i = 0; i < n; i++) {
				contador++;
				Component c = e.getComponent(i);
				c.setBounds(x, y, 450, 30);
				x += 150;

				if (i == (n - 1)) {
					c.setSize(2000, 30);

				}
				if (contador % 2 == 0) {
					x += 500;
				}
				if (contador % 4 == 0) {
					x = 50;
					y += 120;

				}
			}

		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			// Calcular el tamaño preferido según el contenido
			int width = 1500;
			int height = parent.getComponentCount() * 40;
			return new Dimension(width, height);

		}

		@Override
		public void removeLayoutComponent(Component comp) {
			// TODO Auto-generated method stub

		}

	}

	public static ArrayList<JTextField> listaCampo() {
		ArrayList<JTextField> camposFormulario = new ArrayList<JTextField>();
		camposFormulario.add(cedula);
		camposFormulario.add(nombres);
		camposFormulario.add(apellidos);
		camposFormulario.add(edad);
		camposFormulario.add(direccion);
		camposFormulario.add(email);
		camposFormulario.add(telefono);
		return camposFormulario;
	}

}
