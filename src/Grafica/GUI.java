package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import Logica.logica;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Campo Fondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		logica logica = new logica(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logica.iniciar();
			}
		});
		btnIniciar.setBounds(30, 11, 89, 23);
		contentPane.add(btnIniciar);
		
		Fondo = new Campo(logica);
		Fondo.setBounds(30, 45, 562, 385);
		contentPane.add(Fondo);
		
	    InputMap im = contentPane.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap am = contentPane.getActionMap();

	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "PressRightArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "ReleaseRightArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "PressLeftArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "ReleaseLeftArrow");

	    logica juego = new logica(this);
	    
	    am.put("PressRightArrow", new ArrowAction("Press", "RightArrow", juego));
	    am.put("ReleaseRightArrow", new ArrowAction("Release", "RightArrow", juego));
	    am.put("PressLeftArrow", new ArrowAction("Press", "LeftArrow", juego));
	    am.put("ReleaseLeftArrow", new ArrowAction("Release", "LeftArrow", juego));
		
	}
	
	public void establecerFondo(String direccionFondo) {
		Fondo.establecerFondo(direccionFondo);
	}
	
}
