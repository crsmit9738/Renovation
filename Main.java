package Code;
/*Hello, and Welcome to my Senior Project
 * Renovation was made to help keep track of
 * your ideas and project items.  It uses
 * database queries to help find what you need
 * and store useful information you need later. The
 * main menu is the most basic function call as it only calls
 * two buttons and a picture to be used.
 * */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Main extends JFrame {

	private JPanel contentPane;
	/*What the next few lines of code will do is launch the application.
	 * On launch, 2 buttons will appear directing you to either
	 * the projects page or the notes page.
	 * By clicking, they launch the frame of the other two options
	 * where you can make your choice of which to pick.
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Renovation");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Renovation_Logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(logo));
		lblNewLabel.setBounds(26, 107, 215, 225);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Projects");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projects project = new Projects();
				project.setVisible(true);//Sets the frame Projects to visible
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(329, 107, 145, 65);
		contentPane.add(btnNewButton);
		
		JButton btnProjects = new JButton("Notes");
		btnProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notes note = new Notes();
				note.setVisible(true);//Sets the frame Notes to visible
			}
		});
		btnProjects.setForeground(Color.WHITE);
		btnProjects.setBackground(Color.BLUE);
		btnProjects.setBounds(329, 276, 145, 65);
		contentPane.add(btnProjects);

	}
}
