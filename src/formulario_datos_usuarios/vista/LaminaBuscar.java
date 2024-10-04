package formulario_datos_usuarios.vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import formulario_datos_usuarios.controladores.AccionesBotonesListaUsuarios;
import formulario_datos_usuarios.modelado.Usuarios;

public class LaminaBuscar extends JPanel {
	private static final long serialVersionUID = -3496535558475988386L;
	private static JPanel objetosArea;
	private JTextField buscarUsuario;
	private static JPanel cajaPrincipal = new JPanel();

	public LaminaBuscar() {

		setLayout(new BorderLayout());
		generarBox();
		buscarUsuario = new JTextField();
		JPanel laminaNorte = new JPanel();
		laminaNorte.setLayout(new BorderLayout());

		laminaNorte.add(buscarUsuario, BorderLayout.WEST);
		add(laminaNorte, BorderLayout.NORTH);
		objetosArea = new JPanel();
		objetosArea.setLayout(new MyLayout());
		objetosArea.setBackground(Color.white);
		JScrollPane scrollSiii = new JScrollPane(cajaPrincipal);
		objetosArea.add(scrollSiii);
		add(objetosArea, BorderLayout.CENTER);

	}

	public void generarLaminaDeDato() {
		for (int i = 0; i < Usuarios.getListaDeUsuario().size(); i++) {

		}
	}

	public static JPanel generarBox() {
		cajaPrincipal.setBorder(BorderFactory.createLineBorder(Color.black));
		cajaPrincipal.setLayout(new BorderLayout());
		String[] titulos = { "Cedula", "Nombres", "Apellidos", "Edad", "Dirección", "Email", "Telefóno" };
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(titulos);
		for (int i = 0; i < Usuarios.getListaDeUsuario().size(); i++) {
			String cedula = new String(Usuarios.getListaDeUsuario().get(i).getCedula());
			String nombres = new String(Usuarios.getListaDeUsuario().get(i).getNombre());
			String apellidos = new String(Usuarios.getListaDeUsuario().get(i).getApellido());
			String edad = new String(String.valueOf(Usuarios.getListaDeUsuario().get(i).getEdad()));
			String direccion = new String(Usuarios.getListaDeUsuario().get(i).getDireccion());
			String email = new String(Usuarios.getListaDeUsuario().get(i).getEmail());
			String telefono = new String(Usuarios.getListaDeUsuario().get(i).getTelefono());
			Object[][] datos = { { cedula, nombres, apellidos, edad, direccion, email, telefono } };

			for (Object[] fila : datos) {
				modelo.addRow(fila);
			}

		}
		JTable tabla = new JTable(modelo);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
//	    tabla.getColumnModel().getColumn(7).setCellEditor(new EditorBoton());
		tabla.setFont(new Font("Serif", Font.PLAIN, 14));
		tabla.setRowHeight(25);
		JTableHeader encabezado = tabla.getTableHeader();
		encabezado.setFont(new Font("SansSerif", Font.BOLD, 16));
		encabezado.setBackground(Color.BLACK);
		encabezado.setForeground(Color.WHITE);

		DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 6513290137410612837L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				if (row % 2 == 0) {
					c.setBackground(Color.LIGHT_GRAY);
				} else {
					c.setBackground(Color.WHITE);
				}
				if (isSelected) {
					c.setBackground(new Color(102, 187, 106));
				}

				return c;
			}
		};

		for (int i = 0; i < tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(renderizador);
		}
		JScrollPane scrollPane = new JScrollPane(tabla);
		cajaPrincipal.add(scrollPane, BorderLayout.CENTER);
		return cajaPrincipal;
	}

	public static JPanel getCajaPrincipal() {
		return cajaPrincipal;
	}

	private class MyLayout implements LayoutManager {

		@Override
		public void addLayoutComponent(String name, Component comp) {
			// TODO Auto-generated method stub

		}

		@Override
		public void layoutContainer(Container e) {
			Component c = e.getComponent(0);
			c.setBounds(50, 50, getSize().width - 100, 800);

		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			int width = 800;
			int height = parent.getComponentCount() * 30;
			return new Dimension(width, height);
		}

		@Override
		public void removeLayoutComponent(Component comp) {
			// TODO Auto-generated method stub

		}

	}

}
