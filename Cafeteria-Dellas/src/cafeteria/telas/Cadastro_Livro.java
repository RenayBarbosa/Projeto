package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cafeteria.negocio.Bebida;
import cafeteria.negocio.Livro;
import cafeteria.repositorio.repositorioBebida;
import cafeteria.repositorio.repositorioLivro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cadastro_Livro extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField genero;
	private JTextField preco;
	private JTable table;
	private DefaultTableModel m;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Livro frame = new Cadastro_Livro();
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
	public Cadastro_Livro() {
		setTitle("Cadastra Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(370, 265, 186, 212);
		contentPane.add(scrollPane);
		
		repositorioLivro b = new repositorioLivro();
		ArrayList<Livro> be = b.all();
		
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome"
			}
		));
		table.setBounds(0, 0, 1, 1);
		contentPane.add(table);
		scrollPane.setViewportView(table);
		
		m = (DefaultTableModel)table.getModel();
		for (int i = 0; i < be.size(); i++) {
			String[] linha = {be.get(i).getNome()};
			m.addRow(linha);
		}
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNome.setBounds(104, 265, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblGnero.setBounds(104, 320, 46, 14);
		contentPane.add(lblGnero);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblPreo.setBounds(104, 368, 46, 17);
		contentPane.add(lblPreo);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Cadastro_Livro.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		logo.setBounds(192, 0, 300, 200);
		contentPane.add(logo);
		
		nome = new JTextField();
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nome.setText(nome.getText().replaceAll("[^a-z ^A-Z]", ""));
			}
		});
		nome.setBounds(160, 264, 133, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		genero = new JTextField();
		genero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				genero.setText(genero.getText().replaceAll("[^a-z ^A-Z]", ""));
			}
		});
		genero.setBounds(160, 319, 133, 20);
		contentPane.add(genero);
		genero.setColumns(10);
		
		preco = new JTextField();
		preco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				preco.setText(preco.getText().replaceAll("[^0-9 ^.]", ""));
			}
		});
		preco.setBounds(160, 368, 133, 20);
		contentPane.add(preco);
		preco.setColumns(10);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				repositorioLivro l = new repositorioLivro();
				Livro o = new Livro(nome.getText(), genero.getText(), Double.parseDouble (preco.getText()));
				l.inseri(o);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
				nome.setText("");
				genero.setText("");
				preco.setText("");
				
			}
		});
		btnFinalizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinalizar.setIcon(new ImageIcon(Cadastro_Livro.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnFinalizar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnFinalizar.setBounds(10, 510, 143, 40);
		contentPane.add(btnFinalizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Produto c = new Cadastro_Produto();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setIcon(new ImageIcon(Cadastro_Livro.class.getResource("/cafeteria/imagens/br/Voltar-icon-1.png")));
		btnVoltar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnVoltar.setBounds(551, 510, 123, 40);
		contentPane.add(btnVoltar);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Cadastro_Livro.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}

}
