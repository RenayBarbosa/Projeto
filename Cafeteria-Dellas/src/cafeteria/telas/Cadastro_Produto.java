package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafeteria.negocio.Pedido;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Cadastro_Produto extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Produto frame = new Cadastro_Produto();
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
	public Cadastro_Produto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_Produto.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Cadastramento de Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastraCaf = new JButton("Cadastra Caf\u00E9");
		btnCadastraCaf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Cafe c = new Cadastro_Cafe();
				c.setVisible(true);
				dispose();
			}
		});
		btnCadastraCaf.setFont(new Font("Agency FB", Font.BOLD, 22));
		btnCadastraCaf.setBounds(260, 237, 164, 50);
		contentPane.add(btnCadastraCaf);
		
		JButton btnCadastraLanche = new JButton("Cadastra Lanche");
		btnCadastraLanche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Lanche c = new Cadastro_Lanche();
				c.setVisible(true);
				dispose();
			}
		});
		btnCadastraLanche.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnCadastraLanche.setBounds(260, 314, 164, 50);
		contentPane.add(btnCadastraLanche);
		
		JButton btnCadastraLivro = new JButton("Cadastra Livro");
		btnCadastraLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Livro c = new Cadastro_Livro();
				c.setVisible(true);
				dispose();
			}
		});
		btnCadastraLivro.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnCadastraLivro.setBounds(260, 391, 164, 50);
		contentPane.add(btnCadastraLivro);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(Cadastro_Produto.class.getResource("/cafeteria/imagens/br/Voltar-icon-1.png")));
		btnVoltar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnVoltar.setBounds(551, 510, 123, 40);
		contentPane.add(btnVoltar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Cadastro_Produto.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		logo.setBounds(197, 0, 290, 200);
		contentPane.add(logo);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Cadastro_Produto.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}
}
