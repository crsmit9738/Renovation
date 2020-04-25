package Code;
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

	/**
	 * Launch the application.
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

	/**
	 * Create the frame.
	 */
	public Projects() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreateNewProject = new JMenuItem("Create New Project");
		mntmCreateNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableNamer name = new TableNamer();
				name.setVisible(true);
			}
		});
		mnFile.add(mntmCreateNewProject);
		
		JMenuItem menuItem = new JMenuItem("< Back");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mnFile.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjects = new JLabel("Projects");
		lblProjects.setForeground(Color.BLUE);
		lblProjects.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblProjects.setBounds(232, 22, 76, 26);
		contentPane.add(lblProjects);
		
		JLabel lblPlanOutYour = new JLabel("Plan out your perfect home!");
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
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
		    java.sql.Statement statement = conn.createStatement();
		    ResultSet project = statement.executeQuery("Show Tables");
		    int x = 0, y = 165, wide = 483, height = 39;
		    for(; project.next(); y+=39) {
				JButton btnNewButton = new JButton(project.getString(1).toUpperCase());
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							new Items(project.getString(1)).setVisible(true);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setBackground(Color.BLUE);
				btnNewButton.setBounds(x, y, wide, height);
				contentPane.add(btnNewButton);
		    }
	}
}
