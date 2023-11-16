package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cafeteria.negocio.Bebida;
import cafeteria.negocio.Pedido;
import cafeteria.repositorio.repositorioBebida;
import cafeteria.repositorio.repositorioPedido;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Finalizar_Pedido extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel m;
	private JTextField total;
	private double total_s;
	private Pedido pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finalizar_Pedido frame = new Finalizar_Pedido(null);
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
	public Finalizar_Pedido(Pedido p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Finalizar_Pedido.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Finaliza\u00E7\u00E3o do Pedido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 293, 263, 150);
		contentPane.add(scrollPane);
		
		//tabela com os campos de valor produto e codigo
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Valor", "Produto", "C\u00F3digo"
			}
		));
		m = (DefaultTableModel)table.getModel();
		
		for (int i = 0; i < p.getAcompanhamento().size(); i++) {
			String[] linha ={p.getAcompanhamento().get(i).getPreco()+"",p.getAcompanhamento().get(i).getNome(),p.getAcompanhamento().get(i).getCodigo()+""};
			m.addRow(linha);
		}
		
		for (int i = 0; i < p.getBebida().size(); i++) {
			String[] lin ={p.getBebida().get(i).getPreco()+"",p.getBebida().get(i).getNome(),p.getBebida().get(i).getCodigo()+""};
			m.addRow(lin);
		}
		
		for (int i = 0; i < p.getLivro().size(); i++) {	
			String[] linh ={p.getLivro().get(i).getPreco()+"",p.getLivro().get(i).getNome(),p.getLivro().get(i).getCodigo()+""};
			m.addRow(linh);
		}
		
		
		
		JLabel lblNome = new JLabel("Nome: "+p.getCliente().getNome());
		lblNome.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNome.setBounds(210, 243, 305, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:"+p.getCliente().getCpf());
		lblCpf.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCpf.setBounds(210, 268, 226, 14);
		contentPane.add(lblCpf);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repositorioPedido s = new repositorioPedido();
				s.inseri(p);
				
				JOptionPane.showMessageDialog(null, "Finalizado");
				dispose();
			}
		});
		btnFinalizar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnFinalizar.setIcon(new ImageIcon(Finalizar_Pedido.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnFinalizar.setBounds(277, 482, 129, 40);
		contentPane.add(btnFinalizar);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblTotal.setBounds(421, 455, 46, 14);
		contentPane.add(lblTotal);
		
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(463, 454, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Finalizar_Pedido.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		logo.setBounds(177, 11, 329, 188);
		contentPane.add(logo);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Finalizar_Pedido.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}
}
