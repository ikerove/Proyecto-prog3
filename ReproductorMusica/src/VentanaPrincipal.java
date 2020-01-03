
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

import Musica.Cancion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

public class VentanaPrincipal extends JFrame {
 //prueba
	
	
		
	private JPanel contentPane;
	private JFrame frame;
	private JButton btnPlaypausa = new JButton("Play/Pausa");
	private JMenuBar menuBar = new JMenuBar();
	private JLabel lblLogo_1 = new JLabel("Viri");
	
	private JButton btnDirectorio = new JButton("Directorio");

	
	

	private JPanel panel_1 = new JPanel();
	private JPanel p1Arriba = new JPanel();
	private JPanel p1Abajo = new JPanel();
	/**
	 * @wbp.nonvisual location=340,391
	 */
	private JPanel panel_2 = new JPanel();
	private JPanel p2Arriba = new JPanel();
	private JPanel p2Abajo = new JPanel();
	
	/**
	 * @wbp.nonvisual location=480,371
	 */
	private JPanel panel_3 = new JPanel();
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
	private JPanel panel_4 = new JPanel();
	private JPanel p4Arriba = new JPanel();
	private JLabel lblCaratula = new JLabel("Caratula");
	private JButton btnAtras = new JButton("Atras");
	private JButton btnSiguiente = new JButton("Siguiente");
	private JPanel p4Abajo = new JPanel();
	
	private JProgressBar pb = new JProgressBar();
	private JSlider slider = new JSlider();
	private JMenu mnNombre = new JMenu("Nombre");
	private JMenu mnArchivo = new JMenu("Archivo");
	private JMenu mnEdicion = new JMenu("Edicion");
	private JMenu mnVisualizacion = new JMenu("Visualizacion");
	private JMenu mnReproduccion = new JMenu("Reproduccion");
	private JMenu mnVentana = new JMenu("Ventana");
	private JMenu mnAcercaDeProg = new JMenu("Acerca de prog");
	private JList listaCanciones = new JList();
	
	private final BasicPlayer Audio = new BasicPlayer();
	FileNameExtensionFilter filtrado = new FileNameExtensionFilter("Solo Mp3","mp3","jpg");
	
	private File archivo= null;
	private String agregaCanciones[]= new String[10];
	private final ArrayList<String> datos = new ArrayList<>();
	
	 private Tag tag; 
	 private  AudioFile audiofile = new AudioFile();
	 
	 private String ruta = "/Users/ikerrodriguez";
	 private final JFileChooser abrirFile  = new JFileChooser(new File(ruta));
	
	
	 private final String fuente1="Georgia";
	    private final String fuente2="Segoe Print";
	    private boolean mute=false;
	    private boolean bloquear=false;
	    private boolean repitaCancion=false;
	    private boolean siguiente=false;
	    private float balance=0.5f;
	    private float volumenM;
	    private float volumen=0.8f;
	   
	    private final JButton btnRuta = new JButton("Ruta");
	    private final JButton btnAgregar = new JButton("Agregar Canciones");


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
		setSize(795, 501);
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
		getContentPane().setLayout(null);
		panel_1.setBounds(0, 0, 53, 373);
		panel_1.setLayout(null);
		p1Arriba.setBounds(5, 5, 65, 181);
		
		panel_1.add(p1Arriba);
		p1Abajo.setBounds(5, 186, 65, 181);
		panel_1.add(p1Abajo);
		p1Abajo.setLayout(null);
		p1Arriba.setLayout(null);
		lblUnidad.setBounds(5, 5, 54, 14);
		
		
		p1Arriba.add(lblUnidad);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel_1);
		panel_2.setBounds(53, 0, 577, 373);
		panel_2.setLayout(null);
		p2Arriba.setBounds(0, 0, 577, 186);
		
		
		panel_2.add(p2Arriba);
		p2Abajo.setBounds(0, 181, 577, 186);
		panel_2.add(p2Abajo);
		p2Abajo.setLayout(null);
		p2Arriba.setLayout(null);
		lblPlaylist.setBounds(48, 6, 264, 22);
		
		
		
		
		
		
		p2Arriba.add(lblPlaylist);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 40, 565, 140);
		p2Arriba.add(scrollPane);
		
		
		scrollPane.setViewportView(listaCanciones);
		getContentPane().add(panel_2);
		panel_3.setBounds(630, 0, 159, 373);
		panel_3.setLayout(null);
		p3Arriba.setBounds(5, 6, 154, 180);
		
		
		
		panel_3.add(p3Arriba);
		p3Abajo.setBounds(5, 186, 64, 181);
		panel_3.add(p3Abajo);
		p3Abajo.setLayout(null);
		p3Arriba.setLayout(null);
		lblAmigos.setBounds(5, 5, 53, 14);
		
		p3Arriba.add(lblAmigos);
		
		
		btnDirectorio.setBounds(5, 44, 149, 29);
		p3Arriba.add(btnDirectorio);
		btnRuta.setBounds(15, 85, 117, 29);
		
		p3Arriba.add(btnRuta);
		btnAgregar.setBounds(5, 126, 149, 29);
		
		p3Arriba.add(btnAgregar);
		
		
		
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel_3);
		panel_4.setBounds(0, 373, 684, 66);
		panel_4.setLayout(null);
		p4Arriba.setBounds(0, 0, 684, 33);
		
		panel_4.add(p4Arriba);
		p4Arriba.setLayout(null);
		lblCaratula.setBounds(113, 9, 92, 14);
		
		p4Arriba.add(lblCaratula);
		btnAtras.setBounds(205, 6, 59, 23);
		
		p4Arriba.add(btnAtras);
		btnPlaypausa.setBounds(291, 5, 107, 23);
	//	btnPlaypausa.setIcon(new ImageIcon("/Users/ikerrodriguez/Downloads/Unknown"));
		p4Arriba.add(btnPlaypausa);
		btnSiguiente.setBounds(403, 5, 120, 23);
		
		p4Arriba.add(btnSiguiente);
		p4Abajo.setBounds(0, 33, 684, 51);
		panel_4.add(p4Abajo);
		p4Abajo.setLayout(null);
		lblCancion.setBounds(6, 17, 269, 14);
		lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
		p4Abajo.add(lblCancion);
		slider.setBounds(280, 17, 232, 14);
		p4Abajo.add(slider);
		getContentPane().add(panel_4);
		
		
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
			         
			           slider.setEnabled(true);
				
			        //   CaratulaCancion(archivo.toString());
			           try {
			               Audio.open(new File(ReproduceCancion));
			               Audio.play();
			               Audio.setGain(volumen);
			               Audio.setPan(balance);
			               int pista = listaCanciones.getAnchorSelectionIndex()+1;
			              
			           } catch (BasicPlayerException ex) {
			               System.out.println(ex);
			               System.out.println("El contenido de caratula mp3 es demasiado grande....Borrela!!!");
			               
			               
			               try {
			                   
			                   Audio.stop();
			                   
			                   String RutaCancion = datos.get(indice);
			                   AudioFile file = AudioFileIO.read(new File(RutaCancion));
			                   Tag tager = file.getTag();
			                   tager.deleteField(FieldKey.COVER_ART);
			                   tager.deleteArtworkField();
			                   AudioFileIO.write(file);
			                   InputStream inputStream = new FileInputStream(ruta);
			                   OutputStream outputStream =  new FileOutputStream("Audio.mp3");
			                   
			                   byte[] buf = new byte[1024];
			                   int len;

			                   while ((len = inputStream.read(buf)) > 0) {
			                     outputStream.write(buf, 0, len);
			                    }
			                   inputStream.close();
			                   outputStream.close();
			                   
			              
			                    System.out.println();
			                    System.out.println("El contenido de caratula mp3 es de masiado grande....Borrela!!!"); 
			                   
			                } 
			               catch (IOException ex1) {System.out.println(ex1);} 
			               catch (TagException ex1) {System.out.println(ex1);} 
			               catch (ReadOnlyFileException ex1) {System.out.println(ex1);} 
			               catch (InvalidAudioFrameException ex1) {System.out.println(ex1);} 
			               catch (CannotWriteException ex1) {System.out.println(ex1);} 
			               catch (CannotReadException ex1) {System.out.println(ex1);} 
			               catch (BasicPlayerException ex1) {System.out.println(ex1);} 
			               
			           }  
			}
				
				 
			}
		});


		
		
	
			btnSiguiente.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 if (listaCanciones.getSelectedIndex()+1!=agregaCanciones.length){
				            bloquear=true;
				            Comprovacion(1);
				            bloquear=false;
				        }

				}
			});
			
			btnAtras.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (listaCanciones.getSelectedIndex()!=0){
			            bloquear=true;
			            Comprovacion(-1);
			            bloquear=false;
			        }
				}
			});
			
			
				
			listaCanciones.addMouseListener(new MouseListener() {
				
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
						 System.out.println(listaCanciones.getAnchorSelectionIndex());
			                
			                int indice = listaCanciones.getSelectedIndex();
			                
			                 if (indice!=-1){
			                    String ReproduceCancion = datos.get(indice);
			       
			                    File file = new File(ReproduceCancion);
			                    try {
			                    audiofile = AudioFileIO.read(file);                   
			                    tag=audiofile.getTag();
			                    
			                    } catch (CannotReadException | IOException | TagException | NullPointerException |
			                        ReadOnlyFileException | InvalidAudioFrameException ex) {
			                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex); }
			                    
			                    //Hace la llamada al metodo encargado de rellenar los JLbels....
			               //     JLaEtiquetas(file);
			        //            lblCaratula(file.toString());
			                    if (e.getClickCount()==2){
			                        try {
			                            bloquear=true;
			                            Audio.stop();
			                            bloquear=false;
			                        } catch (BasicPlayerException ex) {
			                            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);}
			                        btnPlaypausa.doClick();
			                        if (Audio.getStatus()==2){
			                            btnPlaypausa.doClick();
			                        }
			                    }
			                 }

					}
				});
		
			btnDirectorio.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					abrirFile.setDialogTitle("Ruta Absoluta Busqueda...");
			        abrirFile.setFileFilter(filtrado);
			        abrirFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        
			        
			        if (abrirFile.showOpenDialog(p3Arriba)==0){
			            File file = new File(""+abrirFile.getSelectedFile());        
			            
			            String argumento = file.getName();//Obtenemos el nombre del archivo...
			            argumento=argumento.substring(argumento.length()-3,argumento.length());//Obtenemos los tres ultimos caracteres de la cadena de nombre...
			            
			            //Evaluamos la condicion de que el archivo al que hacemos referencia exista....
			            //Evaluamos la condicion de que el archivo que hacemos referencia sea de extension mp3...
			            if (file.exists()& argumento.equals("mp3")){
			                
			                archivo = abrirFile.getSelectedFile();//Obtenemos la ruta del archivo..
			                                 
			                try {
			                    audiofile = AudioFileIO.read(archivo);
			                    tag =  audiofile.getTag();
			     
			                } catch (CannotReadException | IOException | TagException | 
			                        ReadOnlyFileException | InvalidAudioFrameException ex) {
			                    System.out.println("Error no hay archivo el argumento es "+archivo);
			                }                     
			                ruta = abrirFile.getCurrentDirectory().toString();
			              //  new JLaTexto(fuente1, "Ruta: "+ ruta,jLabelRuta , Color.WHITE, 15);
			              
			                datos.add(archivo.toString());
			                
			                agregaCanciones = new String[datos.size()];
			              
			                int x=0;
			                for (String cancion:datos){
			                    File introduce = new File(cancion);
			                    agregaCanciones[x] = introduce.getName();
			                    x++;
			                }
			                listaCanciones.setListData(agregaCanciones);
			              //  JLaEtiquetas(archivo);
			            }   
			            
			        }   

				}
			});
			
			
			btnRuta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					abrirFile.setDialogTitle("Directorio Agregar Canciones");
			        abrirFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//Accederemos solamente a directorios.
			        if (abrirFile.showOpenDialog(p3Arriba)==0){
			            ruta = abrirFile.getSelectedFile().toString();
			           // new JLaTexto(fuente1, "Ruta: "+ ruta,jLabelRuta , Color.WHITE, 15); 
				}
				}
				});
			
			
			btnAgregar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					 
			        if (ruta!=null & Audio.getStatus()!=1){
			            archivo = new File(ruta);
			            
			           Cancion agre = new Cancion(agregaCanciones, archivo, datos, listaCanciones);         
			         //  new JLaTexto(fuente1, "Total: "+datos.size(), jLabelTotal, Color.WHITE, 15);
			           agregaCanciones= agre.agregaGet();
			           if (archivo!=null){
			        	   listaCanciones.setSelectedIndex(0);
			              archivo = new File(datos.get(0));
			                  
			           }                    
			        }  
				}
			});
			
			
			
			
		}


	public void basic_playerlistener() {
		Audio.addBasicPlayerListener(new BasicPlayerListener() {
		
		@Override
		public void stateUpdated(BasicPlayerEvent bpe) {
			// TODO Auto-generated method stub
			if (!bloquear){
                if (Audio.getStatus()==2 & repitaCancion){
                	btnPlaypausa.doClick();
                }
                if (listaCanciones.getSelectedIndex()+1!=agregaCanciones.length){
                    if (Audio.getStatus()==2 & siguiente){
                        int pista = listaCanciones.getAnchorSelectionIndex();                            
                        listaCanciones.setSelectedIndex(pista+1);
                        repaint();
                        btnPlaypausa.doClick();
                    }
                }
            }                
        
		}
		
		@Override
		public void setController(BasicController arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void progress(int i, long l, byte[] bytes, Map propiedades) {
			// TODO Auto-generated method stub
			// CalculoSecundero(propiedades.get("mp3.position.microseconds").toString(), "Transcurrido: ", jLabelTranscurrido);

                Object bytesTranscurrido =  propiedades.get("mp3.position.byte");
                bytesTranscurrido= Integer.parseInt(bytesTranscurrido.toString());               
                pb.setValue((int)bytesTranscurrido);
		}
		
		@Override
		public void opened(Object o, Map map) {
			// TODO Auto-generated method stub
		//	 CalculoSecundero(map.get("duration").toString(), "Duracion: ", jLabelTiempo);
               
            //   new JLaTexto(fuente1, "Tasa de bits: "+map.get("bitrate"), jLabelBitrate, c, 15);
              // new JLaTexto(fuente1, "Velocidad Muestreo: "+map.get("mp3.frequency.hz"), jLabelFRate, c, 15);

               pb.setMaximum(Integer.parseInt(map.get("mp3.length.bytes").toString()));
               pb.setMinimum(0);
		}
		
			});
	}
		
		public void Comprovacion(int opera){
	        int indice = listaCanciones.getSelectedIndex();        
	        if (archivo!=null & indice!=-1 & Audio.getStatus()==0){
	            //El metodo getAnchotSelectionIndex obtenemos el numero de posicion en el que se encuentra el JList...
	            int pista = listaCanciones.getAnchorSelectionIndex();
	            listaCanciones.setSelectedIndex(pista+opera);
	            try {
	                Audio.stop();
	            } catch (BasicPlayerException ex) {
	                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
	            }
	            btnPlaypausa.doClick();
	        }
	    }
		
		
		
	
}

		

	


