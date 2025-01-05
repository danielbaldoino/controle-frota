package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelos.Viagem;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnRelatorios = new JMenu("Relatórios");
		menuBar.add(mnRelatorios);

		JMenuItem mntmCaminhao = new JMenuItem("Caminhão");
		mntmCaminhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaminhaoTela tela = new CaminhaoTela();
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});
		mnRelatorios.add(mntmCaminhao);

		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mntmEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpresaTela tela = new EmpresaTela();
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});
		mnRelatorios.add(mntmEmpresa);

		JMenuItem mntmMotorista = new JMenuItem("Motorista");
		mntmMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaTela tela = new MotoristaTela();
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});
		mnRelatorios.add(mntmMotorista);

		JMenuItem mntmReboque = new JMenuItem("Reboque");
		mntmReboque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReboqueTela tela = new ReboqueTela();
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});
		mnRelatorios.add(mntmReboque);

		JMenu nmMais = new JMenu("Mais");
		menuBar.add(nmMais);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre tela = new Sobre();
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});
		nmMais.add(mntmSobre);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		JLabel lblNewLabel = new JLabel("Viagens Programadas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		verticalBox.add(lblNewLabel);

		JButton btnListar = new JButton("Listar todas");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viagem viagem = new Viagem();
				viagem.listar();
			}
		});
		verticalBox.add(btnListar);

		JButton btnDeletar = new JButton("Deletar Viagem");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código:"));

				if (codigo > 0) {
					Viagem viagem = new Viagem();
					viagem.setId(codigo);
					viagem.deletar();
				} else {
					JOptionPane.showMessageDialog(null, "Informe o código para deletar.");
				}
			}
		});
		verticalBox.add(btnDeletar);

		JButton btnAdd = new JButton("Add ou Ajustar Viagem");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViagemTela tela = new ViagemTela();
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tela.setVisible(true);
			}
		});
		verticalBox.add(btnAdd);
	}

}
