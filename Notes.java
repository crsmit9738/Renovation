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

public class Notes extends JFrame {

	private JPanel contentPane;

	/**
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

	/**
	 * Create the frame.
	 */
	public Notes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreateNewNote = new JMenuItem("Create New Note");
		mnFile.add(mntmCreateNewNote);
		
		JMenuItem menuItem = new JMenuItem("< Back");
		mnFile.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setForeground(Color.BLUE);
		lblNotes.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNotes.setBounds(193, 11, 76, 26);
		contentPane.add(lblNotes);
		
		JLabel lblKeepTrackOf = new JLabel("Keep track of your home ideas.");
		lblKeepTrackOf.setForeground(Color.BLUE);
		lblKeepTrackOf.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblKeepTrackOf.setBounds(116, 48, 196, 26);
		contentPane.add(lblKeepTrackOf);
		setResizable(false);
	}
}
