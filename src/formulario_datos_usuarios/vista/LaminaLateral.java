package formulario_datos_usuarios.vista;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaminaLateral extends JPanel {

	private static final long serialVersionUID = 5608294718338291103L;
	private static int widthWest = 150;
	private JButton botonCrearUsuario;
	private JButton botonBuscarUsuario;

	public LaminaLateral(CardLayout grupoLaminas, JPanel panelPrincipale) {
		setLayout(new MyLayoutLateral());
		setPreferredSize(new Dimension(widthWest, 400));
		setBackground(new Color(47, 47, 47));
		botonCrearUsuario = new JButton();
		botonBuscarUsuario = new JButton();
		emptyBorderAndColor(botonCrearUsuario, botonBuscarUsuario);
		ButtonGroup grupoBotones = new ButtonGroup();
		grupoBotones.add(botonBuscarUsuario);
		grupoBotones.add(botonBuscarUsuario);
		botonCrearUsuario.addActionListener(new CambiarLaminaBoton(grupoLaminas, panelPrincipale));
		botonBuscarUsuario.addActionListener(new CambiarLaminaBoton(grupoLaminas, panelPrincipale));
		add(botonCrearUsuario);
		add(botonBuscarUsuario);

	}

	public static void setWidthWest(int widthWest) {
		LaminaLateral.widthWest = widthWest;
	}

	public static int getWidthWest() {
		return widthWest;
	}

	private void emptyBorderAndColor(JButton botonCrear, JButton botonBuscar) {
		botonCrear.setBorder(BorderFactory.createEmptyBorder());
		botonBuscar.setBorder(BorderFactory.createEmptyBorder());
		botonCrear.setForeground(Color.white);
		botonBuscar.setForeground(Color.white);
		JLabel textoBotonCrear = new JLabel("Crear Usuario");
		textoBotonCrear.setFont(new Font("Serial", Font.BOLD, 13));
		textoBotonCrear.setForeground(Color.WHITE);
		JLabel textoBotonBuscar = new JLabel("Buscar Usuario");
		textoBotonBuscar.setFont(new Font("Serial", Font.BOLD, 13));
		textoBotonBuscar.setForeground(Color.WHITE);
		botonCrear.add(textoBotonCrear);
		botonBuscar.add(textoBotonBuscar);
		botonCrear.setBackground(null);
		botonBuscar.setBackground(null);
	}

	private class MyLayoutLateral implements LayoutManager {

		@Override
		public void addLayoutComponent(String arg0, Component arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void layoutContainer(Container e) {
			int x = (e.getWidth() / 2);
			int y = e.getHeight() / 2;
			int n = e.getComponentCount();
			for (int i = 0; i < n; i++) {
				Component c = e.getComponent(i);
				c.setBounds(x - 50, y - 50, 100, 20);
				y += 30;

			}

		}

		@Override
		public Dimension minimumLayoutSize(Container arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Dimension preferredLayoutSize(Container arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void removeLayoutComponent(Component arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class CambiarLaminaBoton implements ActionListener {
		public CambiarLaminaBoton(CardLayout grupoLaminas, JPanel panelPrincipale) {

			this.grupoLaminas = grupoLaminas;
			this.panelPrincipale = panelPrincipale;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obtenerBoton = e.getSource();
			if (obtenerBoton == botonCrearUsuario) {
				grupoLaminas.show(panelPrincipale, "laminaFormulario");
			} else {
				grupoLaminas.show(panelPrincipale, "laminaBuscar");

			}

		}

		private CardLayout grupoLaminas;
		private JPanel panelPrincipale;
	}
}
