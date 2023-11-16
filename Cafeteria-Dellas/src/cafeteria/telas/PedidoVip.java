package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
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

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class PedidoVip extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Pedido pedido;
	private double total;
	private DefaultTableModel m;
	private double total_s;
	private ArrayList<Pedido> pedidos;
	private JTextField nomeDoCliente;
	private JTextField codigoCliente;
	private JSpinner numeroMesa;
	private JTextField mesaNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedidoVip frame = new PedidoVip(null);
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
	public PedidoVip(ArrayList<Pedido> p) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PedidoVip.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setTitle("Pedido Para Clientes Cadastrados ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		pedido = new Pedido();
		pedidos = new ArrayList<>();
		
		if(p.size() > 0){
			for (int i = 0; i < p.size(); i++) {
				addLista(p.get(i));
			}
		}


		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(432, 251, 242, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Lista"
			}
		));
		m = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);
		
		JButton btnCaf = new JButton("Caf\u00E9");
		btnCaf.setHorizontalAlignment(SwingConstants.LEFT);
		btnCaf.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnCaf.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		btnCaf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String busca = JOptionPane.showInputDialog("Digite o Tipo de Café");
				repositorioBebida b = new repositorioBebida();
				Bebida be = b.busca(busca);
				
				pedido.addBebida(be);
				total_s += be.getPreco();
				String[] linha = {be.getNome()};
				m.addRow(linha);

				
				
				
			}
		});
		btnCaf.setBounds(82, 147, 177, 50);
		contentPane.add(btnCaf);
		
		JButton btnAcompanhamento = new JButton("Lanche");
		btnAcompanhamento.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcompanhamento.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnAcompanhamento.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/4558-200-2.png")));
		btnAcompanhamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String busca = JOptionPane.showInputDialog("Digite o Tipo de Acompanhamento");
			repositorioAcompanhamento a = new repositorioAcompanhamento();
			Acompanhamento lc = a.busca(busca);
			
			pedido.addAcompanhamento(lc);
			total_s += lc.getPreco();
			String[] linha = {lc.getNome()};
			m.addRow(linha);
			
			
			
				
			}
		});
		btnAcompanhamento.setBounds(82, 235, 177, 50);
		contentPane.add(btnAcompanhamento);
		
		JButton btnLivro = new JButton("Livro");
		btnLivro.setHorizontalAlignment(SwingConstants.LEFT);
		btnLivro.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnLivro.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/icon_1009-1.png")));
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String busca =	JOptionPane.showInputDialog("Digite o Nome do Livro");
			repositorioLivro c = new repositorioLivro();
			Livro li = c.busca(busca);
			
			pedido.addLivro(li);
			total_s += li.getPreco();
			String[] linha ={li.getNome()};
			m.addRow(linha);
			
			
			
			}
		});
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.2.png")));
		logo.setBounds(229, 0, 230, 140);
		contentPane.add(logo);
		btnLivro.setBounds(82, 321, 177, 50);
		contentPane.add(btnLivro);
		
		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pedido.setMesa(Integer.parseInt(mesaNumero.getText()));
				pedido.setTotal(total_s);
				
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				Date data = new Date();
				pedido.setData(f.format(data));	
				addLista(pedido);
				
				/*
				System.out.println(pedido.getData());
				System.out.println(pedido.getMesa());
				System.out.println(pedido.getTotal());
				System.out.println(pedido.getAcompanhamento().get(0).getNome());
				System.out.println(pedido.getBebida().get(0).getNome());
				System.out.println(pedido.getLivro().get(0).getNome());
				*/
				
				System.out.println(pedidos.get(0).getMesa());
				
				Principal p = new Principal(pedidos);
				p.setVisible(true);
				dispose();
				
			}
		});
		btnFinalizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinalizar.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnFinalizar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnFinalizar.setBounds(57, 509, 145, 41);
		contentPane.add(btnFinalizar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/Voltar-icon-1.png")));
		btnVoltar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal p = new Principal(pedidos);
				p.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(508, 509, 145, 41);
		contentPane.add(btnVoltar);
		
		JButton btnAdicionarCliente = new JButton("Add Cliente");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String busca = JOptionPane.showInputDialog("Digite o Nome do Cliente!");
			repositorioCliente r = new repositorioCliente(); 
			Cliente c = r.busca(busca); 
			
			pedido.setCliente(c);
			nomeDoCliente.setText(c.getNome());
			codigoCliente.setText(c.getCodigo()+"");
			
			System.out.println(pedido.getCliente().getNome());
			
			}
		});
		btnAdicionarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdicionarCliente.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/icon_mais-1.png")));
		btnAdicionarCliente.setFont(new Font("Agency FB", Font.BOLD, 23));
		btnAdicionarCliente.setBounds(82, 403, 177, 50);
		contentPane.add(btnAdicionarCliente);
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblMesa.setBounds(442, 448, 49, 14);
		contentPane.add(lblMesa);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblCliente.setBounds(540, 142, 46, 14);
		contentPane.add(lblCliente);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel.setBounds(432, 168, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo\r\n:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNewLabel_1.setBounds(432, 194, 46, 30);
		contentPane.add(lblNewLabel_1);
		
		nomeDoCliente = new JTextField();
		nomeDoCliente.setFont(new Font("Agency FB", Font.BOLD, 15));
		nomeDoCliente.setEditable(false);
		nomeDoCliente.setBounds(484, 167, 190, 20);
		contentPane.add(nomeDoCliente);
		nomeDoCliente.setColumns(10);
		
		codigoCliente = new JTextField();
		codigoCliente.setFont(new Font("Agency FB", Font.BOLD, 15));
		codigoCliente.setEditable(false);
		codigoCliente.setBounds(484, 201, 190, 20);
		contentPane.add(codigoCliente);
		codigoCliente.setColumns(10);
		
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
			}
		});
		btnRemover.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnRemover.setBounds(564, 447, 89, 23);
		contentPane.add(btnRemover);
		
		mesaNumero = new JTextField();
		mesaNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				mesaNumero.setText(mesaNumero.getText().replaceAll("[^0-9]", ""));
			}
		});
		mesaNumero.setBounds(473, 447, 62, 20);
		contentPane.add(mesaNumero);
		mesaNumero.setColumns(10);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(PedidoVip.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 684, 561);
		contentPane.add(fundo);
	}
	
	public void addLista(Pedido p){
		this.pedidos.add(p);
	}
}
