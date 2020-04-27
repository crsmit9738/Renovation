package Code;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;

public class Items extends JFrame {
	public Items() {
		getContentPane().setBackground(Color.WHITE);
		
	}

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items frame = new Items();
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
	static Connection conn = null;
	public Items(String userInput) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setTitle(userInput.toUpperCase());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Item");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItem name = new AddItem(userInput);
				name.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete Item");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteItem name = new DeleteItem(userInput);
				name.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Delete Table");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTable name = new DeleteTable(userInput);
				name.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("< Back");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel(userInput.toUpperCase());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 21, 111, 14);
		getContentPane().add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 102, 430, 186);
		contentPane.add(scrollPane);
		JLabel lblNewLabel_1 = new JLabel("Total Price:");
		lblNewLabel_1.setBounds(273, 214, 64, 14);
		getContentPane().add(lblNewLabel_1);
		String sql = "Select SUM(Price)"
				    + "FROM " + userInput +";";
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
	            java.sql.Statement statement = conn.createStatement()) {
	            ResultSet price = statement.executeQuery(sql);
	            while (price.next()) {
	        	String sum = price.getString(1);
	    		JLabel lblNewLabel_2 = new JLabel(sum);
	    		lblNewLabel_2.setBounds(341, 214, 64, 14);
	    		getContentPane().add(lblNewLabel_2);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		table = new JTable();
		scrollPane.setViewportView(table);
		String sqlCommand = "Select * FROM " + userInput;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
	            java.sql.Statement statement = conn.createStatement()) {
	            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sqlCommand);
	            ResultSet rs = pst.executeQuery();
	            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
