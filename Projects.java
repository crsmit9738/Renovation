import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Projects extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreateNewProject = new JMenuItem("Create New Project");
		mnFile.add(mntmCreateNewProject);
		
		JMenuItem menuItem = new JMenuItem("< Back");
		mnFile.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjects = new JLabel("Projects");
		lblProjects.setForeground(Color.BLUE);
		lblProjects.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblProjects.setBounds(205, 22, 76, 26);
		contentPane.add(lblProjects);
		
		JLabel lblPlanOutYour = new JLabel("Plan out your perfect home!");
		lblPlanOutYour.setForeground(Color.BLUE);
		lblPlanOutYour.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblPlanOutYour.setBounds(137, 45, 186, 26);
		contentPane.add(lblPlanOutYour);
		setResizable(false);
	}

}
