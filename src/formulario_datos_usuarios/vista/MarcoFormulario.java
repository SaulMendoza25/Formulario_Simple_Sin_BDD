package formulario_datos_usuarios.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoFormulario extends JFrame {
	private LaminaLateral laminaLateral;
	private LaminaFormulario laminaForm;
	private LaminaBuscar laminaBusc;
	private CardLayout grupoLaminas;
	private JPanel panelPrincipal;
	private static final long serialVersionUID = -1119517095496770373L;

	public MarcoFormulario() {
		setLayout(new BorderLayout());

		setBounds(getDefaultScreen().width / 4, getDefaultScreen().height / 4, getDefaultScreen().width,
				getDefaultScreen().height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Formulario de usuarios");
		setIconImage(new ImageIcon("resources/icons/IconoFormulario.png").getImage());
		grupoLaminas = new CardLayout();
		laminaForm = new LaminaFormulario();
		laminaBusc = new LaminaBuscar();
		panelPrincipal = new JPanel(grupoLaminas);
		panelPrincipal.add(laminaForm, "laminaFormulario");
		panelPrincipal.add(laminaBusc, "laminaBuscar");
		laminaLateral = new LaminaLateral(grupoLaminas, panelPrincipal);
		add(laminaLateral, BorderLayout.WEST);
		add(panelPrincipal, BorderLayout.CENTER);
		this.addComponentListener(new SetSizeWindowWest());
		this.addWindowListener(new SetSizeWindowWest());
	}

	private Dimension getDefaultScreen() {
		Toolkit getDefaultToolkit = Toolkit.getDefaultToolkit();
		return getDefaultToolkit.getScreenSize();
	}

	private class SetSizeWindowWest extends WindowAdapter implements ComponentListener {

		@Override
		public void windowStateChanged(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowStateChanged(e);
		}

		@Override
		public void componentHidden(ComponentEvent arg0) {

		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			LaminaLateral.setWidthWest(150);
			laminaLateral.setPreferredSize(new Dimension(LaminaLateral.getWidthWest(), 0));

		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			LaminaLateral.setWidthWest(getSize().width / 6);
			if (LaminaLateral.getWidthWest() > 160) {
				laminaLateral.setPreferredSize(new Dimension(LaminaLateral.getWidthWest(), 0));
			}
		}

		@Override
		public void componentShown(ComponentEvent arg0) {

		}

	}
}
