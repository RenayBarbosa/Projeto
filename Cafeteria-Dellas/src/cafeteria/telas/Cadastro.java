package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import cafeteria.negocio.Cliente;
import cafeteria.repositorio.repositorioCliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JFormattedTextField fone;
	private JTextField cidade;
	private JTextField PE;
	private JFormattedTextField cpf;
	private JTextField rua;
	private JFormattedTextField cep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNome.setBounds(10, 318, 46, 24);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCpf.setBounds(455, 323, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblTel = new JLabel("Fone:");
		lblTel.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblTel.setBounds(10, 358, 46, 14);
		contentPane.add(lblTel);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblEstado.setBounds(451, 358, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCidade.setBounds(227, 358, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblRua.setBounds(10, 396, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCep.setBounds(451, 396, 46, 14);
		contentPane.add(lblCep);
		
		nome = new JTextField();
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nome.setText(nome.getText().replaceAll("[^a-z ^A-Z ^ã ^á-ú]", ""));
			}
		});
		nome.setBounds(66, 320, 349, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		fone = new JFormattedTextField(Mascara("(##)#####-####"));
		fone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				fone.setText(fone.getText().replaceAll("[^0-9]", ""));
			}
		});
		fone.setBounds(67, 352, 134, 20);
		contentPane.add(fone);
		fone.setColumns(10);
		
		cidade = new JTextField();
		cidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cidade.setText(cidade.getText().replaceAll("[^a-z ^A-Z ^ã ^á-ú ]", ""));
			}
		});
		cidade.setBounds(292, 355, 124, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		PE = new JTextField();
		PE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PE.setText(PE.getText().replaceAll("[^a-z ^A-Z ^ã ^á-ú]", ""));
			}
		});
		PE.setBounds(508, 355, 143, 20);
		contentPane.add(PE);
		PE.setColumns(10);
		
		cpf = new JFormattedTextField(Mascara("###.###.###-##"));
		cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cpf.setText(cpf.getText().replaceAll("[^0-9]", ""));
			}
		});
		cpf.setBounds(507, 320, 141, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		rua = new JTextField();
		rua.setBounds(66, 390, 349, 20);
		contentPane.add(rua);
		rua.setColumns(10);
		
		cep = new JFormattedTextField(Mascara("##.###-###"));
		cep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cep.setText(cep.getText().replaceAll("[^0-9]", ""));
			}
		});
		cep.setBounds(508, 393, 143, 20);
		contentPane.add(cep);
		cep.setColumns(10);
		
		JButton btnFinalizarCadastro = new JButton("Finalizar Cadastro");
		btnFinalizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repositorioCliente r = new repositorioCliente();
				Cliente c = new Cliente(nome.getText(), cpf.getText(), fone.getText(), rua.getText(), cep.getText());
				r.inseri(c);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
				nome.setText("");
				fone.setText("");
				cpf.setText("");
				rua.setText("");
				cep.setText("");
				cidade.setText("");
				PE.setText("");
			}
		});
		btnFinalizarCadastro.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnFinalizarCadastro.setIcon(new ImageIcon(Cadastro.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnFinalizarCadastro.setBounds(24, 496, 191, 50);
		contentPane.add(btnFinalizarCadastro);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnVoltar.setIcon(new ImageIcon(Cadastro.class.getResource("/cafeteria/imagens/br/Voltar-icon-1.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(548, 500, 113, 50);
		contentPane.add(btnVoltar);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Cadastro.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		Logo.setBounds(183, 23, 318, 200);
		contentPane.add(Logo);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Cadastro.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}
	
	public MaskFormatter Mascara(String Mascara){
		MaskFormatter F_Mascara = new MaskFormatter();
		
		try {
			F_Mascara.setMask(Mascara);
			F_Mascara.setPlaceholderCharacter(' ');
			
		} catch (Exception excecao) {
			excecao.printStackTrace();
			
		}
		return F_Mascara;
		
	}
}
