package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Banco_Dados.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Atualizar_Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField senha;
	private JTextField login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atualizar_Usuario frame = new Atualizar_Usuario();
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
	public Atualizar_Usuario() {
		setTitle("Atualizar Usu\u00E1rio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Atualizar_Usuario.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Atualizar_Usuario.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		label_1.setBounds(192, 28, 300, 200);
		contentPane.add(label_1);
		
		JLabel lblNomeDoNovo = new JLabel("Nome do novo usu\u00E1rio:");
		lblNomeDoNovo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNomeDoNovo.setBounds(116, 308, 130, 14);
		contentPane.add(lblNomeDoNovo);
		
		JLabel lblSenharDoNovo = new JLabel("Senhar do novo usu\u00E1rio:");
		lblSenharDoNovo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblSenharDoNovo.setBounds(116, 393, 130, 14);
		contentPane.add(lblSenharDoNovo);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao s = new Conexao();
				
				String sql = "Insert into usuario (nome,senha,login) values ('"+nome.getText()+"','"+senha.getText()+"','"+login.getText()+"')";
				s.executarSQL(sql);
				JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso!");
			}
		});
		btnFinalizar.setIcon(new ImageIcon(Atualizar_Usuario.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnFinalizar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnFinalizar.setBounds(277, 510, 129, 40);
		contentPane.add(btnFinalizar);
		
		nome = new JTextField();
		nome.setBounds(277, 307, 172, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(277, 392, 172, 20);
		contentPane.add(senha);
		senha.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblLogin.setBounds(116, 344, 46, 30);
		contentPane.add(lblLogin);
		
		login = new JTextField();
		login.setBounds(277, 351, 172, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Atualizar_Usuario.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		label.setBounds(10, 0, 684, 561);
		contentPane.add(label);
	}
}
