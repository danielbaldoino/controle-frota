package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);
		
		JLabel lblNewLabel = new JLabel("Controle de Frota");
		verticalBox.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Desenvolvido por:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		verticalBox.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Daniel Ribeiro Baldoino");
		verticalBox.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nicolas Ribeiro Baldoino");
		verticalBox.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Diovane Mota Mentes");
		verticalBox.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gabriel Izidoro Alves");
		verticalBox.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gabriel Leonardo de Souza Mendes");
		verticalBox.add(lblNewLabel_6);
	}

}
