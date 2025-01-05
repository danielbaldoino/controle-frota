package Telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelos.Caminhao;
import java.awt.Font;

@SuppressWarnings("serial")
public class CaminhaoTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtPlaca;
	private JTextField txtModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaminhaoTela frame = new CaminhaoTela();
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
	public CaminhaoTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		JLabel lblNewLabel = new JLabel("Caminhão");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		verticalBox.add(lblNewLabel);

		Box codigoBox = Box.createHorizontalBox();
		verticalBox.add(codigoBox);

		JLabel lblCodigo = new JLabel("Código:");
		codigoBox.add(lblCodigo);

		txtCodigo = new JTextField();
		lblCodigo.setLabelFor(txtCodigo);
		codigoBox.add(txtCodigo);

		Box placaBox = Box.createHorizontalBox();
		verticalBox.add(placaBox);

		JLabel lblPlaca = new JLabel("Placa:");
		placaBox.add(lblPlaca);

		txtPlaca = new JTextField();
		lblPlaca.setLabelFor(txtPlaca);
		placaBox.add(txtPlaca);

		Box modeloBox = Box.createHorizontalBox();
		verticalBox.add(modeloBox);

		JLabel lblModelo = new JLabel("Modelo:");
		modeloBox.add(lblModelo);

		txtModelo = new JTextField();
		lblModelo.setLabelFor(txtModelo);
		modeloBox.add(txtModelo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPlaca.getText().isEmpty() || txtModelo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
				} else {
					Caminhao caminhao = new Caminhao();
					caminhao.setPlaca(txtPlaca.getText());
					caminhao.setModelo(txtModelo.getText());

					if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == "0") {
						caminhao.inserir();
					} else {
						caminhao.setId(Integer.parseInt(txtCodigo.getText()));
						caminhao.atualizar();
					}

					txtCodigo.setText("");
					txtPlaca.setText("");
					txtModelo.setText("");
				}
			}
		});
		verticalBox.add(btnSalvar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == "0") {
					JOptionPane.showMessageDialog(null, "Informe o código para deletar.");
				} else {
					Caminhao caminhao = new Caminhao();
					caminhao.setId(Integer.parseInt(txtCodigo.getText()));
					caminhao.deletar();

					txtCodigo.setText("");
					txtPlaca.setText("");
					txtModelo.setText("");
				}
			}
		});
		verticalBox.add(btnDeletar);

		JButton btnListar = new JButton("Listar todos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caminhao caminhao = new Caminhao();
				caminhao.listar();
			}
		});
		verticalBox.add(btnListar);
	}

}
