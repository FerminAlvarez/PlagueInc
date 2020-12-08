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
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 806, 480);
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

		lblVida = new JLabel("Vida: ");
		lblVida.setHorizontalAlignment(SwingConstants.CENTER);
		lblVida.setBackground(Color.WHITE);
		lblVida.setForeground(Color.BLACK);
		lblVida.setBounds(448, 15, 96, 14);
		contentPane.add(lblVida);
		
		JLabel lblMovimientoDelJugador = new JLabel("Movimiento");
		lblMovimientoDelJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovimientoDelJugador.setBounds(602, 77, 178, 30);
		contentPane.add(lblMovimientoDelJugador);
		
		JLabel lblDisparodeljugador = new JLabel("Disparo");
		lblDisparodeljugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisparodeljugador.setBounds(602, 200, 178, 30);
		contentPane.add(lblDisparodeljugador);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/escena/FlechaIzquierda.png")));
		lblNewLabel.setBounds(632, 103, 46, 42);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/escena/FlechaDerecha.png")));
		label.setBounds(708, 103, 46, 42);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(GUI.class.getResource("/imagenes/escena/LetraZ.png")));
		label_1.setBounds(668, 225, 46, 42);
		contentPane.add(label_1);

		InputMap im = contentPane.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = contentPane.getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "PressRightArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "ReleaseRightArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "PressLeftArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "ReleaseLeftArrow");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, false), "PressFire");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, true), "ReleaseFire");

		am.put("PressRightArrow", new Action("Press", "RightArrow", juego));
		am.put("ReleaseRightArrow", new Action("Release", "RightArrow", juego));
		am.put("PressLeftArrow", new Action("Press", "LeftArrow", juego));
		am.put("ReleaseLeftArrow", new Action("Release", "LeftArrow", juego));
		am.put("PressFire", new Action("Press", "Fire", juego));
		am.put("ReleaseFire", new Action("Release", "Fire", juego));

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
		lblVida.setText("Vida: " + vida + "%");
	}
	

	public void establecerNivel(int nivel) {
		lblNivel.setText("Nivel: " + nivel);
	}

	public void victoria() {
		JOptionPane.showMessageDialog(null, "¡Felicidades, usted ha ganado!");
		System.exit(0);
	}
	
	public void derrota() {
		JOptionPane.showMessageDialog(null, "¡UPS! Usted se ha contagiado, realice cuarentena obligatoria");
		System.exit(0);
	}
}
