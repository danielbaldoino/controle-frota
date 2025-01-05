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

import Modelos.Viagem;
import java.awt.Font;

@SuppressWarnings("serial")
public class ViagemTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtMotoristaId;
	private JTextField txtCaminhaoId;
	private JTextField txtReboqueId;
	private JTextField txtEmpresaOrigemId;
	private JTextField txtEmpresaDestinoId;
	private JTextField txtDataPartida;
	private JTextField txtDataChegada;
	private JTextField txtCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViagemTela frame = new ViagemTela();
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
	public ViagemTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		JLabel lblNewLabel = new JLabel("Viagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		verticalBox.add(lblNewLabel);

		Box codigoBox = Box.createHorizontalBox();
		verticalBox.add(codigoBox);

		JLabel lblCodigo = new JLabel("Código:");
		codigoBox.add(lblCodigo);

		txtCodigo = new JTextField();
		lblCodigo.setLabelFor(txtCodigo);
		codigoBox.add(txtCodigo);

		Box motoristaBox = Box.createHorizontalBox();
		verticalBox.add(motoristaBox);

		JLabel lblMotorista = new JLabel("Motorista Id:");
		motoristaBox.add(lblMotorista);

		txtMotoristaId = new JTextField();
		lblMotorista.setLabelFor(txtMotoristaId);
		motoristaBox.add(txtMotoristaId);

		Box caminhaoBox = Box.createHorizontalBox();
		verticalBox.add(caminhaoBox);

		JLabel lblCaminhao = new JLabel("Caminhão Id:");
		caminhaoBox.add(lblCaminhao);

		txtCaminhaoId = new JTextField();
		lblCaminhao.setLabelFor(txtCaminhaoId);
		caminhaoBox.add(txtCaminhaoId);

		Box reboqueBox = Box.createHorizontalBox();
		verticalBox.add(reboqueBox);

		JLabel lblReboque = new JLabel("Reboque Id:");
		reboqueBox.add(lblReboque);

		txtReboqueId = new JTextField();
		lblReboque.setLabelFor(txtReboqueId);
		reboqueBox.add(txtReboqueId);

		Box empresaOrigemBox = Box.createHorizontalBox();
		verticalBox.add(empresaOrigemBox);

		JLabel lblEmpresaOrigem = new JLabel("Empresa Origem Id:");
		empresaOrigemBox.add(lblEmpresaOrigem);

		txtEmpresaOrigemId = new JTextField();
		lblEmpresaOrigem.setLabelFor(txtEmpresaOrigemId);
		empresaOrigemBox.add(txtEmpresaOrigemId);

		Box empresaDestinoBox = Box.createHorizontalBox();
		verticalBox.add(empresaDestinoBox);

		JLabel lblEmpresaDestino = new JLabel("Empresa Destino Id:");
		empresaDestinoBox.add(lblEmpresaDestino);

		txtEmpresaDestinoId = new JTextField();
		lblEmpresaDestino.setLabelFor(txtEmpresaDestinoId);
		empresaDestinoBox.add(txtEmpresaDestinoId);

		Box dataPartidaBox = Box.createHorizontalBox();
		verticalBox.add(dataPartidaBox);

		JLabel lblDataPartida = new JLabel("Data Partida:");
		dataPartidaBox.add(lblDataPartida);

		txtDataPartida = new JTextField();
		lblDataPartida.setLabelFor(txtDataPartida);
		dataPartidaBox.add(txtDataPartida);

		Box dataChegadaBox = Box.createHorizontalBox();
		verticalBox.add(dataChegadaBox);

		JLabel lblDataChegada = new JLabel("Data Chegada:");
		dataChegadaBox.add(lblDataChegada);

		txtDataChegada = new JTextField();
		lblDataChegada.setLabelFor(txtDataChegada);
		dataChegadaBox.add(txtDataChegada);

		Box cargaBox = Box.createHorizontalBox();
		verticalBox.add(cargaBox);

		JLabel lblCarga = new JLabel("Carga:");
		cargaBox.add(lblCarga);

		txtCarga = new JTextField();
		lblCarga.setLabelFor(txtCarga);
		cargaBox.add(txtCarga);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDataPartida.getText().isEmpty() || txtDataChegada.getText().isEmpty()
						|| txtCarga.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
				} else {
					Viagem viagem = new Viagem();
					viagem.setMotoristaId(Integer.parseInt(txtMotoristaId.getText()));
					viagem.setCaminhaoId(Integer.parseInt(txtCaminhaoId.getText()));
					viagem.setReboqueId(Integer.parseInt(txtReboqueId.getText()));
					viagem.setEmpresaOrigemId(Integer.parseInt(txtEmpresaOrigemId.getText()));
					viagem.setEmpresaDestinoId(Integer.parseInt(txtEmpresaDestinoId.getText()));
					viagem.setDataPartida(txtDataPartida.getText());
					viagem.setDataChegada(txtDataChegada.getText());
					viagem.setCarga(txtCarga.getText());

					if (txtCodigo.getText().isEmpty() || txtCodigo.getText() == "0") {
						viagem.inserir();
					} else {
						viagem.setId(Integer.parseInt(txtCodigo.getText()));
						viagem.atualizar();
					}

					dispose();
				}
			}
		});
		verticalBox.add(btnSalvar);
	}

}
