package Code;
/*TextArea will list the current items in the button that was clicked in the previous page.
 * the button sends the name to this page and then uses this name to execute an SQL
 * command to populate the table with items found in the table name given.
 * */
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
import java.awt.Color;

public class TextArea extends JFrame {
	public TextArea() {
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
	public TextArea(String userInput) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setTitle(userInput.toUpperCase());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();//Allows a menu bar be put in place to save the window from getting 
		setJMenuBar(menuBar);            //cluttered with buttons.
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//opens the update note dialogue box to allow for body to be changed.
				UpdateNote name = new UpdateNote(userInput);//sends title of current note.
				name.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delete Note");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//opens deleteNote dialogue box.
				DeleteNote name = new DeleteNote(userInput);//sends title of current note.
				name.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("< Back");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//closes the current window and goes to previous window before it.
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
		table = new JTable();//allows for information to be filled from database.
		scrollPane.setViewportView(table);//puts a scroll pane around the table.
		String sqlCommand = "Select * FROM " + userInput;//makes sql command that will get all info from table name.
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","username","password");//connect to database
	            java.sql.Statement statement = conn.createStatement()) {
	            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sqlCommand);//makes statement be the sql command.
	            ResultSet rs = pst.executeQuery();//executes sql command in database.
	            table.setModel(DbUtils.resultSetToTableModel(rs));//fills the database table with information. Needs rs2xlr.jar
        } catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
