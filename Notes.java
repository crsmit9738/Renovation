package Code;
/*Notses when button is clicked in main, will display
 * the list of note table names, each on name on a button
 * to display which note they want to view and edit. It is a great way
 * to organize your table names so the consumer can clearly see them
 * and choose which one they want to edit easily.
 * */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Notes extends JFrame {

	private static JPanel contentPane;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notes frame = new Notes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*Sets up the design of the page
	 * */
	public Notes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setTitle("Notes");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");//Menu allowed me to not use buttons and clutter up the page with unnecessary buttons.
		menuBar.add(mnFile);
		
		JMenuItem mntmCreateNewNote = new JMenuItem("Create New Note");
		mntmCreateNewNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleNamer title = new TitleNamer();//opens Titlenamer dialogue box.
				title.setVisible(true);
			}
		});
		mnFile.add(mntmCreateNewNote);
		
		JMenuItem menuItem = new JMenuItem("< Back");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//closes the current window and goes to previous window before it.
				setVisible(false);
			}
		});
		mnFile.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotes = new JLabel("Notes");//creates the label saying notes
		lblNotes.setForeground(Color.BLUE);
		lblNotes.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNotes.setBounds(225, 11, 76, 26);
		contentPane.add(lblNotes);
		
		JLabel lblKeepTrackOf = new JLabel("Keep track of your home ideas.");//creates the label saying Keep track of your home ideas.
		lblKeepTrackOf.setForeground(Color.BLUE);
		lblKeepTrackOf.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblKeepTrackOf.setBounds(142, 37, 196, 26);
		contentPane.add(lblKeepTrackOf);
		setResizable(false);
		try {
			NoteTitleButtons();//executes notetitlebuttons function below.
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public static void NoteTitleButtons() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","username","password");//connects to database.
	    java.sql.Statement statement = conn.createStatement();
	    ResultSet title = statement.executeQuery("Show Tables");//executes query to bring back all table names
	    int x = 0, y = 165, wide = 483, height = 39;//sets button dimensions
	    for(; title.next(); y+=39) {//loops through until it gets all the title names
	    	String noteTitle = title.getString(1);//sets string to table name
			JButton btnNewButton = new JButton(noteTitle.toUpperCase());//adds name to button 
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//on click, will take to text area page that 
					new TextArea(noteTitle).setVisible(true);//will list items in button that was pressed.
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.BLUE);
			btnNewButton.setBounds(x, y, wide, height);
			contentPane.add(btnNewButton);
	    }
}
}
