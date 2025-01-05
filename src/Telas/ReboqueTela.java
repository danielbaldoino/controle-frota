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

import Modelos.Reboque;
import java.awt.Font;

@SuppressWarnings("serial")
public class ReboqueTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtPlaca;
	private JTextField txtPesoLimite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReboqueTela frame = new ReboqueTela();
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
	public ReboqueTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		JLabel lblReboque = new JLabel("Reboque");
		lblReboque.setFont(new Font("Tahoma", Font.BOLD, 10));
		verticalBox.add(lblReboque);

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

		Box pesoLimiteBox = Box.createHorizontalBox();
		verticalBox.add(pesoLimiteBox);

		JLabel lblPesoLimite = new JLabel("Peso Limite:");
		pesoLimiteBox.add(lblPesoLimite);

		txtPesoLimite = new JTextField();
		lblPesoLimite.setLabelFor(txtPesoLimite);
		pesoLimiteBox.add(txtPesoLimite);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPlaca.getText().isEmpty() || txtPesoLimite.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
				} else {
					Reboque rebouqe = new Reboque();
					rebouqe.setPlaca(txtPlaca.getText());
					rebouqe.setPesoLimite(Integer.parseInt(txtPesoLimite.getText()));

					if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == "0") {
						rebouqe.inserir();
					} else {
						rebouqe.setId(Integer.parseInt(txtCodigo.getText()));
						rebouqe.atualizar();
					}

					txtCodigo.setText("");
					txtPlaca.setText("");
					txtPesoLimite.setText("");
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
					Reboque rebouqe = new Reboque();
					rebouqe.setId(Integer.parseInt(txtCodigo.getText()));
					rebouqe.deletar();

					txtCodigo.setText("");
					txtPlaca.setText("");
					txtPesoLimite.setText("");
				}
			}
		});
		verticalBox.add(btnDeletar);

		JButton btnListar = new JButton("Listar todos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reboque rebouqe = new Reboque();
				rebouqe.listar();
			}
		});
		verticalBox.add(btnListar);
	}

}
