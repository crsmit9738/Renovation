package Code;
/*Projects, when button is clicked in main, will display
 * the list of project table names, each on name on a button
 * to display which table you want to view and edit. It is a great way
 * to organize your table names so the consumer can clearly see them
 * and choose which one they want to edit easily.
 * */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JButton;

public class Projects extends JFrame {

	private static JPanel contentPane;

	/*Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projects frame = new Projects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*Sets up the design of the page
	 * */
	public Projects() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreateNewProject = new JMenuItem("Create New Project");
		mntmCreateNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//opens the TableNamer dialogue box
				TableNamer name = new TableNamer();
				name.setVisible(true);
			}
		});
		mnFile.add(mntmCreateNewProject);
		
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
		
		JLabel lblProjects = new JLabel("Projects");//creates the label saying Projects
		lblProjects.setForeground(Color.BLUE);
		lblProjects.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblProjects.setBounds(232, 22, 76, 26);
		contentPane.add(lblProjects);
		
		JLabel lblPlanOutYour = new JLabel("Plan out your perfect home!");//creates the label saying Plan out your perfect home!
		lblPlanOutYour.setForeground(Color.BLUE);
		lblPlanOutYour.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblPlanOutYour.setBounds(163, 44, 186, 26);
		contentPane.add(lblPlanOutYour);
		try {
			TableNameButtons();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public static void TableNameButtons() throws Exception {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","username","password");//connects to database.
		    java.sql.Statement statement = conn.createStatement();
		    ResultSet project = statement.executeQuery("Show Tables");//executes query to bring back all table names
		    int x = 0, y = 165, wide = 483, height = 39;//sets button dimensions
		    for(; project.next(); y+=39) {//loops through until it gets all the title names
		    	String tableName = project.getString(1);//sets string to table name
				JButton btnNewButton = new JButton(tableName.toUpperCase());//adds name to button 
				btnNewButton.addActionListener(new ActionListener() {//on click, will take to text area page that 
					public void actionPerformed(ActionEvent e) {//will list items in button that was pressed.
						new Items(tableName).setVisible(true);
					}
				});
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setBackground(Color.BLUE);
				btnNewButton.setBounds(x, y, wide, height);
				contentPane.add(btnNewButton);
		    }
	}
}
