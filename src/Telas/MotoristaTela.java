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

import Modelos.Motorista;
import java.awt.Font;

@SuppressWarnings("serial")
public class MotoristaTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDocumento;
	private JTextField txtTelefone;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MotoristaTela frame = new MotoristaTela();
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
	public MotoristaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		JLabel lblNewLabel = new JLabel("Motorista");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		verticalBox.add(lblNewLabel);

		Box codigoBox = Box.createHorizontalBox();
		verticalBox.add(codigoBox);

		JLabel lblCodigo = new JLabel("Código:");
		codigoBox.add(lblCodigo);

		txtCodigo = new JTextField();
		lblCodigo.setLabelFor(txtCodigo);
		codigoBox.add(txtCodigo);

		Box nomeBox = Box.createHorizontalBox();
		verticalBox.add(nomeBox);

		JLabel lblNome = new JLabel("Nome:");
		nomeBox.add(lblNome);

		txtNome = new JTextField();
		lblNome.setLabelFor(txtNome);
		nomeBox.add(txtNome);

		Box documentoBox = Box.createHorizontalBox();
		verticalBox.add(documentoBox);

		JLabel lblDocumento = new JLabel("Documento:");
		documentoBox.add(lblDocumento);

		txtDocumento = new JTextField();
		lblDocumento.setLabelFor(txtDocumento);
		documentoBox.add(txtDocumento);

		Box telefoneBox = Box.createHorizontalBox();
		verticalBox.add(telefoneBox);

		JLabel lblTelefone = new JLabel("Telefone:");
		telefoneBox.add(lblTelefone);

		txtTelefone = new JTextField();
		lblTelefone.setLabelFor(txtTelefone);
		telefoneBox.add(txtTelefone);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().isEmpty() || txtDocumento.getText().isEmpty()
						|| txtTelefone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
				} else {
					Motorista motorista = new Motorista();
					motorista.setNome(txtNome.getText());
					motorista.setDocumento(txtDocumento.getText());
					motorista.setTelefone(txtTelefone.getText());

					if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == "0") {
						motorista.inserir();
					} else {
						motorista.setId(Integer.parseInt(txtCodigo.getText()));
						motorista.atualizar();
					}

					txtCodigo.setText("");
					txtNome.setText("");
					txtDocumento.setText("");
					txtTelefone.setText("");
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
					Motorista motorista = new Motorista();
					motorista.setId(Integer.parseInt(txtCodigo.getText()));
					motorista.deletar();
					
					txtCodigo.setText("");
					txtNome.setText("");
					txtDocumento.setText("");
					txtTelefone.setText("");
				}
			}
		});
		verticalBox.add(btnDeletar);

		JButton btnListar = new JButton("Listar todos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Motorista motorista = new Motorista();
				motorista.listar();
			}
		});
		verticalBox.add(btnListar);
	}

}
