package formulario_datos_usuarios.controladores;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


	public class AccionesBotonesListaUsuarios extends JButton implements TableCellRenderer {
		    private static final long serialVersionUID = -8999264816966329037L;

			public AccionesBotonesListaUsuarios() {
		        setText("Ver");
		    }

			@Override
			public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
					int arg5) {
				 setText((arg1 == null) ? "Ver" : arg1.toString());
				return this;
			}
			
		}

