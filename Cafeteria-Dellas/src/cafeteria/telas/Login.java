package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Banco_Dados.Conexao;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Login extends JFrame {


	private JPanel contentPane;
	private JTextField login;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Login do usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Login.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		Logo.setBounds(188, 36, 308, 203);
		contentPane.add(Logo);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblLogin.setBounds(182, 283, 71, 31);
		contentPane.add(lblLogin);
		
		login = new JTextField();
		login.setBounds(242, 292, 200, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblSenha.setBounds(198, 325, 71, 31);
		contentPane.add(lblSenha);
		
		senha = new JPasswordField();
		senha.setBounds(242, 334, 200, 20);
		contentPane.add(senha);
		
		JButton btnLogar = new JButton("Entra");
		btnLogar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao s = new Conexao();
				
				String sql = "Select * from usuario where login='"+login.getText()+"'";
				String h = new String(senha.getPassword());
				ResultSet rs = s.executaBusca(sql);
				
				try {
					while(rs.next()){
						if(login.getText().equals(rs.getString("login"))){
							if(h.equals(rs.getString("senha"))){
								Principal p = new Principal(new ArrayList<>());
								p.setVisible(true);
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "Senha ou longin incoreetos");
							}
						}else{
							    JOptionPane.showMessageDialog(null, "Senha ou longin incoreetos");
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnLogar.setBounds(288, 421, 107, 45);
		contentPane.add(btnLogar);
		
		JButton btnNovoUsurio = new JButton("Novo Usu\u00E1rio");
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atualizar_Usuario au = new Atualizar_Usuario();
				au.setVisible(true);
				dispose();
			}
		});
		btnNovoUsurio.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNovoUsurio.setBounds(288, 500, 107, 45);
		contentPane.add(btnNovoUsurio);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Login.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}
}
