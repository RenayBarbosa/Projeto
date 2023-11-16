package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cafeteria.negocio.Acompanhamento;
import cafeteria.negocio.Bebida;
import cafeteria.negocio.Cliente;
import cafeteria.negocio.Livro;
import cafeteria.negocio.Pedido;
import cafeteria.repositorio.repositorioAcompanhamento;
import cafeteria.repositorio.repositorioBebida;
import cafeteria.repositorio.repositorioCliente;
import cafeteria.repositorio.repositorioLivro;
import cafeteria.repositorio.repositorioPedido;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class PedidoRapido extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Cliente cliente;
	private Pedido pedido;
	private DefaultTableModel m;
	private JTextField total;
	private double total_s;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedidoRapido frame = new PedidoRapido();
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
	public PedidoRapido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PedidoRapido.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Pedidos Rapidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		repositorioCliente rc = new repositorioCliente();
		this.cliente =  rc.busca("Dellas Cafeteria");
		pedido = new Pedido();
		pedido.setCliente(cliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 192, 311, 254);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Lista" }));
		m = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);

		JButton btnCaf = new JButton("Caf\u00E9");
		btnCaf.setHorizontalAlignment(SwingConstants.LEFT);
		btnCaf.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		btnCaf.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnCaf.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				String b = JOptionPane.showInputDialog("Digite o Tipo de Café");
				repositorioBebida a = new repositorioBebida();
				
				Bebida ac = a.busca(b);
				
				pedido.addBebida(ac);
				total_s += ac.getPreco();
				total.setText(total_s+"");
				String[] linha = {ac.getNome()};
				m.addRow(linha);
				

			}
		});
		btnCaf.setBounds(81, 198, 150, 50);
		contentPane.add(btnCaf);

		JButton btnAcompanhamento = new JButton("Lanche");
		btnAcompanhamento.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcompanhamento.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/4558-200-2.png")));
		btnAcompanhamento.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnAcompanhamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b = JOptionPane.showInputDialog("Digite o Tipo de Acompanhamento");
				
				repositorioAcompanhamento a = new repositorioAcompanhamento();
				Acompanhamento ac = a.busca(b);
				pedido.addAcompanhamento(ac);
				pedido.getAcompanhamento().get(0);
				total_s += ac.getPreco();
				total.setText(total_s+"");
				String[] linha = {ac.getNome()};
				m.addRow(linha);
				
			}
		});
		btnAcompanhamento.setBounds(81, 272, 150, 50);
		contentPane.add(btnAcompanhamento);

		JButton btnLivro = new JButton("Livro");
		btnLivro.setHorizontalAlignment(SwingConstants.LEFT);
		btnLivro.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/icon_1009-1.png")));
		btnLivro.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String b = JOptionPane.showInputDialog("Digite o Nome do Livro");
				
				repositorioLivro a = new repositorioLivro();
				Livro ac = a.busca(b);
				pedido.addLivro(ac);
				pedido.getLivro().get(0);
				total_s += ac.getPreco();
				total.setText(total_s +"");
				String[] linha = {ac.getNome()};
				m.addRow(linha);
			}
		});
		btnLivro.setBounds(81, 344, 150, 50);
		contentPane.add(btnLivro);

		JButton btnNewButton = new JButton("FINALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repositorioPedido p = new repositorioPedido();
				repositorioAcompanhamento a;
				repositorioBebida b;
				repositorioLivro l;
				pedido.setTotal(total_s);
				pedido.setMesa(0);
				
				p.inseri(pedido);
				p = new repositorioPedido();
			    int id_pedido = p.maxId();
			    //id_pedido = id_pedido - 1;
			    
			    System.out.println(id_pedido);
			
				 for (int i = 0; i < pedido.getAcompanhamento().size(); i++) {
					a = new repositorioAcompanhamento();
					a.iserirAcompanhamentoPedido(pedido.getAcompanhamento().get(i).getCodigo(), id_pedido);
					//System.out.println(pedido.getAcompanhamento().get(i).getCodigo());
				}
				 
				 for (int j = 0; j < pedido.getBebida().size(); j++) {
					b = new repositorioBebida();
					b.inserirBebidaPedido(pedido.getBebida().get(j).getCodigo(),id_pedido);
					//System.out.println(pedido.getBebida().get(j).getCodigo());
				}
			
				 for (int k = 0; k < pedido.getLivro().size(); k++) {
					l= new repositorioLivro();
					l.inseriLivroPedido(pedido.getLivro().get(k).getCodigo(),id_pedido);
					//System.out.println(pedido.getLivro().get(k).getCodigo());
				}
					
				JOptionPane.showMessageDialog(null, "Pedido Efetuado!");
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnNewButton.setBounds(10, 510, 143, 40);
		contentPane.add(btnNewButton);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/Voltar-icon-1.png")));
		btnVoltar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(551, 510, 123, 40);
		contentPane.add(btnVoltar);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblTotal.setBounds(357, 452, 46, 26);
		contentPane.add(lblTotal);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(403, 457, 86, 20);
		contentPane.add(total);
		total.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				String nome =  table.getValueAt(row, 0).toString();
				
				for (int i = 0; i < pedido.getAcompanhamento().size(); i++) {
					if(nome.equals(pedido.getAcompanhamento().get(i).getNome())){
						total_s -= pedido.getAcompanhamento().get(i).getPreco();
						pedido.getAcompanhamento().remove(i);
						
					}
				}
				
				for (int i = 0; i < pedido.getBebida().size(); i++) {
					if(nome.equals(pedido.getBebida().get(i).getNome())){
						total_s -= pedido.getBebida().get(i).getPreco();
						pedido.getBebida().remove(i);
						
					}
				}
				
				for (int i = 0; i < pedido.getLivro().size(); i++) {
					if(nome.equals(pedido.getLivro().get(i).getNome())){
						total_s -= pedido.getLivro().get(i).getPreco();
						pedido.getLivro().remove(i);
						
					}
				}

				m.removeRow(row);
				total.setText(total_s+"");
				
			}
		});
		btnRemover.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnRemover.setBounds(540, 457, 86, 26);
		contentPane.add(btnRemover);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.2.png")));
		logo.setBounds(233, 0, 217, 170);
		contentPane.add(logo);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(PedidoRapido.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}
}
