package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cafeteria.negocio.Pedido;
import cafeteria.repositorio.repositorioPedido;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JInternalFrame novo_pedido;
	private ArrayList<Pedido> pedidos;
	private DefaultTableModel m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(new ArrayList<>());
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
	public Principal(ArrayList<Pedido> p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.pedidos = new ArrayList<>();
		
		if(p.size() > 0){
			for (int i = 0; i < p.size(); i++) {
				pedidos.add(p.get(i));
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(161, 268, 613, 217);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Codigo", "Cliente", "Mesa"
			}
		));
		m = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);
		
		if(this.pedidos != null){
			for (int i = 0; i < this.pedidos.size(); i++) {
				String[] linha = {this.pedidos.get(i).getCliente().getCodigo()
						+"",this.pedidos.get(i).getCliente().getNome(),this.pedidos.get(i).getMesa()+""};
				m.addRow(linha);
			}
		}
		

		
		JButton btnNovoCliente = new JButton("Novo Pedido");
		btnNovoCliente.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novo_pedido.setVisible(true);
			}
		});
		btnNovoCliente.setBounds(10, 277, 119, 30);
		contentPane.add(btnNovoCliente);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repositorioPedido a = new repositorioPedido();
				
				
				
				int row = table.getSelectedRow();
				String cod = (String) table.getValueAt(row, 0);
				
				for (int i = 0; i < pedidos.size(); i++) {
					if(pedidos.get(i).getCliente().getCodigo() == Integer.parseInt(cod)){	
						Finalizar_Pedido b = new Finalizar_Pedido(pedidos.get(i));
						b.setVisible(true);
						m.removeRow(row);
						break;
					}
				}
				
			}
		});
		btnFinalizar.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnFinalizar.setBounds(10, 334, 119, 30);
		contentPane.add(btnFinalizar);
		
		
		//redimencionando para a tela de cadastro de cliente
		
		JButton btnNovoCliente_1 = new JButton("Novo Cliente");
		btnNovoCliente_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnNovoCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro a = new Cadastro();
				a.setVisible(true);
				
			}
		});
		btnNovoCliente_1.setBounds(10, 392, 119, 30);
		contentPane.add(btnNovoCliente_1);
		
		//voltar a tela de login
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login c = new Login();
				c.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(685, 514, 89, 23);
		contentPane.add(btnSair);
		
		//tela com os tipos de pedido 
		
	    novo_pedido = new JInternalFrame("Tipos de Pedidos");
		novo_pedido.setBounds(223, 62, 338, 162);
		novo_pedido.getContentPane().setLayout(null);
		novo_pedido.setVisible(false);
		novo_pedido.setClosable(true);
		contentPane.add(novo_pedido);
		
		//ir para a tela de pedido rapido
		
		JButton btnPedidoRapido = new JButton("Pedido Rapido");
		btnPedidoRapido.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnPedidoRapido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoRapido p = new PedidoRapido();
				p.setVisible(true);

			}
		});
		btnPedidoRapido.setBounds(89, 27, 144, 35);
		novo_pedido.getContentPane().add(btnPedidoRapido);
		
		//ir para a tela de pedido rapido
		
		JButton btnNewButton = new JButton("Pedido Vip");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(pedidos.size() > 0){
					PedidoVip v = new PedidoVip(pedidos);
					v.setVisible(true);
					dispose();
				}else{
					PedidoVip v = new PedidoVip(new ArrayList<>());
					v.setVisible(true);
					dispose();
				}
				

			}
		});
		btnNewButton.setBounds(89, 73, 144, 31);
		novo_pedido.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Principal.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		label_1.setBounds(0, 0, 332, 132);
		novo_pedido.getContentPane().add(label_1);
		
		
		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Produto p = new Cadastro_Produto();
				p.setVisible(true);
			}
		});
		btnNovoProduto.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnNovoProduto.setBounds(10, 455, 119, 30);
		contentPane.add(btnNovoProduto);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Principal.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		logo.setBounds(235, 11, 313, 200);
		contentPane.add(logo);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Principal.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 784, 561);
		contentPane.add(fundo);
	
	}
	
	
}

