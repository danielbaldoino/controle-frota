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

import Modelos.Empresa;
import java.awt.Font;

@SuppressWarnings("serial")
public class EmpresaTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtDocumento;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpresaTela frame = new EmpresaTela();
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
	public EmpresaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		JLabel lblNewLabel = new JLabel("Empresa");
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

		Box enderecoBox = Box.createHorizontalBox();
		verticalBox.add(enderecoBox);

		JLabel lblEndereco = new JLabel("Endereço:");
		enderecoBox.add(lblEndereco);

		txtEndereco = new JTextField();
		lblEndereco.setLabelFor(txtEndereco);
		enderecoBox.add(txtEndereco);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().isEmpty() || txtDocumento.getText().isEmpty()
						|| txtEndereco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
				} else {
					Empresa empresa = new Empresa();
					empresa.setNome(txtNome.getText());
					empresa.setDocumento(txtDocumento.getText());
					empresa.setEndereco(txtEndereco.getText());

					if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == "0") {
						empresa.inserir();
					} else {
						empresa.setId(Integer.parseInt(txtCodigo.getText()));
						empresa.atualizar();
					}

					txtCodigo.setText("");
					txtNome.setText("");
					txtDocumento.setText("");
					txtEndereco.setText("");
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
					Empresa empresa = new Empresa();
					empresa.setId(Integer.parseInt(txtCodigo.getText()));
					empresa.deletar();

					txtCodigo.setText("");
					txtNome.setText("");
					txtDocumento.setText("");
					txtEndereco.setText("");
				}
			}
		});
		verticalBox.add(btnDeletar);

		JButton btnListar = new JButton("Listar todos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa empresa = new Empresa();
				empresa.listar();
			}
		});
		verticalBox.add(btnListar);
	}

}
