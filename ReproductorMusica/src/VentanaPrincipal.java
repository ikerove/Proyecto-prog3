
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
import javax.swing.ImageIcon;
import javax.swing.JList;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class VentanaPrincipal extends JFrame {
 //prueba
	private JPanel contentPane;
	private JFrame frame;
	private JButton btnPlaypausa = new JButton("Play/Pausa");
	private JMenuBar menuBar = new JMenuBar();
	private JLabel lblLogo_1 = new JLabel("Logo");
	

	private JPanel panel_1 = new JPanel((new GridLayout(2,1)));
	private JPanel p1Arriba = new JPanel();
	private JPanel p1Abajo = new JPanel();
	/**
	 * @wbp.nonvisual location=340,391
	 */
	private JPanel panel_2 = new JPanel((new GridLayout(2,1)));
	private JPanel p2Arriba = new JPanel();
	private JPanel p2Abajo = new JPanel();
	/**
	 * @wbp.nonvisual location=480,371
	 */
	private JPanel panel_3 = new JPanel((new GridLayout(2,1)));
	private JPanel p3Arriba = new JPanel();
	private JPanel p3Abajo = new JPanel();
	
	
	private JLabel lblUnidad = new JLabel("Unidad");
	private JLabel lblPlaylist = new JLabel("Playlist");
	private JLabel lblAmigos = new JLabel("Amigos");
	/**
	 * @wbp.nonvisual location=40,391
	 */
	private JLabel lblCancion = new JLabel("Cancion");
	/**
	 * @wbp.nonvisual location=340,391
	 */
	private JPanel panel_4 = new JPanel((new GridLayout(2,1)));
	private JPanel p4Arriba = new JPanel();
	private JLabel lblCaratula = new JLabel("Caratula");
	private JButton btnAtras = new JButton("Atras");
	private JButton btnSiguiente = new JButton("Siguiente");
	private JPanel p4Abajo = new JPanel();
	
	private JProgressBar pb = new JProgressBar();
	private JMenu mnNombre = new JMenu("Nombre");
	private JMenu mnArchivo = new JMenu("Archivo");
	private JMenu mnEdicion = new JMenu("Edicion");
	private JMenu mnVisualizacion = new JMenu("Visualizacion");
	private JMenu mnReproduccion = new JMenu("Reproduccion");
	private JMenu mnVentana = new JMenu("Ventana");
	private JMenu mnAcercaDeProg = new JMenu("Acerca de prog");
	private final JList listaCanciones = new JList();
	
	private final BasicPlayer Audio = new BasicPlayer();
	private File archivo= null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
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
		
		setBounds(100, 100, 573, 329);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo (null);
		
		setJMenuBar(menuBar);
		
		menuBar.add(lblLogo_1);
		
		menuBar.add(mnNombre);
		
		mnNombre.add(mnAcercaDeProg);
		
		menuBar.add(mnArchivo);
		
		menuBar.add(mnEdicion);
		
		menuBar.add(mnVisualizacion);
		
		menuBar.add(mnReproduccion);
		
		menuBar.add(mnVentana);
		getContentPane().setLayout(new BorderLayout());
		
		panel_1.add(p1Arriba);
		panel_1.add(p1Abajo);
		
		
		p1Arriba.add(lblUnidad);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		
		panel_2.add(p2Arriba);
		panel_2.add(p2Abajo);
		
		p2Abajo.add(listaCanciones);
		
		
		
		
		p2Arriba.add(lblPlaylist);
		//panel_2.setBorder(new EmptyBorder(5, 5, 5, 200));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		
		panel_3.add(p3Arriba);
		panel_3.add(p3Abajo);
		
		p3Arriba.add(lblAmigos);
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel_3, BorderLayout.EAST);
		
		panel_4.add(p4Arriba);
		
		p4Arriba.add(lblCaratula);
		
		p4Arriba.add(btnAtras);
	//	btnPlaypausa.setIcon(new ImageIcon("/Users/ikerrodriguez/Downloads/Unknown"));
		p4Arriba.add(btnPlaypausa);
		
		p4Arriba.add(btnSiguiente);
		panel_4.add(p4Abajo);
		lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
		p4Abajo.add(lblCancion);
		p4Abajo.add(pb);
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		
		btnPlaypausa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int indice = listaCanciones.getSelectedIndex();
				if (archivo!=null & Audio.getStatus()!=0 & indice!=-1){
			           //System.out.println(Audio.getSleepTime());
			           String ReproduceCancion = datos.get(indice);
			           //System.out.println(ReproduceCancion);
			           archivo = new File(ReproduceCancion);
			           jSliderBalance.setEnabled(true);
			           jSliderProgresoMp3.setEnabled(true);
				
			           CaratulaCancion(archivo.toString());
			           try {
			               Audio.open(new File(ReproduceCancion));
			               Audio.play();
			               Audio.setGain(volumen);
			               Audio.setPan(balance);
			               int pista = jListListaCanciones.getAnchorSelectionIndex()+1;
			               new JLaTexto(fuente1, "Pista: "+ pista, jLabelPista, Color.WHITE, 15);
			           } catch (BasicPlayerException ex) {
			               System.out.println(ex);
			               System.out.println("El contenido de caratula mp3 es demasiado grande....Borrela!!!");
			           }  
			}
				
				 if (Audio.getStatus()==1){
			            try {
			                Audio.resume();
			            } catch (BasicPlayerException ex) {
			                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			            }       
			        }else  if (Audio.getStatus()==0){
			            try {
			                Audio.pause();
			            } catch (BasicPlayerException ex) {
			                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			            }
			        }
			}
		});
		
		}

		}
		
		//btnPlaypausa.setBounds(168,183,97,22);
		
	




/*
public VentanaPrincipal() {
	
	frame = new JFrame();
	frame.setBounds(100, 100, 573, 329);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(700, 500);
	setLocationRelativeTo (null);
	
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
	
}*/

