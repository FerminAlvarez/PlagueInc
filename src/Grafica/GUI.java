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
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Campo Fondo;
	private JLabel lblVida;
	private JLabel lblNivel;

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

		logica juego = new logica(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.iniciar();
			}
		});
		btnIniciar.setBounds(30, 11, 89, 23);
		contentPane.add(btnIniciar);

		Fondo = new Campo(juego);
		Fondo.setBounds(30, 45, 562, 385);
		contentPane.add(Fondo);
		
		lblNivel = new JLabel("Nivel: 1");
		lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivel.setBounds(262, 15, 46, 14);
		contentPane.add(lblNivel);
		
		lblVida = new JLabel("100%");
		lblVida.setHorizontalAlignment(SwingConstants.CENTER);
		lblVida.setBackground(Color.WHITE);
		lblVida.setForeground(Color.BLACK);
		lblVida.setBounds(448, 15, 46, 14);
		contentPane.add(lblVida);

		InputMap im = contentPane.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = contentPane.getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "PressRightArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "ReleaseRightArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "PressLeftArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "ReleaseLeftArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, false), "PressFire");

		am.put("PressRightArrow", new Action("Press", "RightArrow", juego));
		am.put("ReleaseRightArrow", new Action("Release", "RightArrow", juego));
		am.put("PressLeftArrow", new Action("Press", "LeftArrow", juego));
		am.put("ReleaseLeftArrow", new Action("Release", "LeftArrow", juego));
		am.put("PressFire", new Action("Press", "Fire", juego));

	}

	public void establecerFondo(String direccionFondo) {
		Fondo.establecerFondo(direccionFondo);
	}

	public JPanel obtenerCampo() {
		return Fondo;
	}
	
	public void actualizarGrafica() {
		Fondo.repaint();
	}
	
	public void establecerVida(int vida) {
		lblVida.setText(vida+"%");
	}
	public void establecerNivel(int nivel) {
		lblNivel.setText("Nivel: " + nivel);
	}
}
