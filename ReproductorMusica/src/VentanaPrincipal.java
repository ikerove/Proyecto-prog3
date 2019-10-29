import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;

public class VentanaPrincipal {
 //prueba
	private JFrame frame;
	private final JButton btnPlaypausa = new JButton("Play/Pausa");
	private final JMenuBar menuBar = new JMenuBar();
	private final JLabel lblLogo_1 = new JLabel("Logo");
	
	
	
	private final JPanel panel_1 = new JPanel((new GridLayout(2,1)));
	private final JPanel p1Arriba = new JPanel();
	private final JPanel p1Abajo = new JPanel();
	/**
	 * @wbp.nonvisual location=340,391
	 */
	private final JPanel panel_2 = new JPanel((new GridLayout(2,1)));
	private final JPanel p2Arriba = new JPanel();
	private final JPanel p2Abajo = new JPanel();
	/**
	 * @wbp.nonvisual location=480,371
	 */
	private final JPanel panel_3 = new JPanel((new GridLayout(2,1)));
	private final JPanel p3Arriba = new JPanel();
	private final JPanel p3Abajo = new JPanel();
	
	
	private final JLabel lblUnidad = new JLabel("Unidad");
	private final JLabel lblPlaylist = new JLabel("Playlist");
	private final JLabel lblAmigos = new JLabel("Amigos");
	/**
	 * @wbp.nonvisual location=40,391
	 */
	private final JLabel lblCancion = new JLabel("Cancion");
	/**
	 * @wbp.nonvisual location=340,391
	 */
	private final JPanel panel_4 = new JPanel((new GridLayout(2,1)));
	private final JPanel p4Arriba = new JPanel();
	private final JLabel lblCaratula = new JLabel("Caratula");
	private final JButton btnAtras = new JButton("Atras");
	private final JButton btnSiguiente = new JButton("Siguiente");
	private final JPanel p4Abajo = new JPanel();
	
	private final JProgressBar pb = new JProgressBar();
	private final JMenu mnNombre = new JMenu("Nombre");
	private final JMenu mnArchivo = new JMenu("Archivo");
	private final JMenu mnEdicion = new JMenu("Edicion");
	private final JMenu mnVisualizacion = new JMenu("Visualizacion");
	private final JMenu mnReproduccion = new JMenu("Reproduccion");
	private final JMenu mnVentana = new JMenu("Ventana");
	private final JMenu mnAcercaDeProg = new JMenu("Acerca de prog");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(menuBar);
		
		menuBar.add(lblLogo_1);
		
		menuBar.add(mnNombre);
		
		mnNombre.add(mnAcercaDeProg);
		
		menuBar.add(mnArchivo);
		
		menuBar.add(mnEdicion);
		
		menuBar.add(mnVisualizacion);
		
		menuBar.add(mnReproduccion);
		
		menuBar.add(mnVentana);
		frame.getContentPane().setLayout(new BorderLayout());
		
		panel_1.add(p1Arriba);
		panel_1.add(p1Abajo);
		
		
		p1Arriba.add(lblUnidad);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		
		panel_2.add(p2Arriba);
		panel_2.add(p2Abajo);
		
		
		
		
		p2Arriba.add(lblPlaylist);
		//panel_2.setBorder(new EmptyBorder(5, 5, 5, 200));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		
		panel_3.add(p3Arriba);
		panel_3.add(p3Abajo);
		
		p3Arriba.add(lblAmigos);
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		
		panel_4.add(p4Arriba);
		
		p4Arriba.add(lblCaratula);
		
		p4Arriba.add(btnAtras);
		p4Arriba.add(btnPlaypausa);
		
		p4Arriba.add(btnSiguiente);
		panel_4.add(p4Abajo);
		lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
		p4Abajo.add(lblCancion);
		p4Abajo.add(pb);
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		
	}

}
