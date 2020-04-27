package Code;
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
	public Notes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setTitle("Notes");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCreateNewNote = new JMenuItem("Create New Note");
		mntmCreateNewNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleNamer title = new TitleNamer();
				title.setVisible(true);
			}
		});
		mnFile.add(mntmCreateNewNote);
		
		JMenuItem menuItem = new JMenuItem("< Back");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mnFile.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setForeground(Color.BLUE);
		lblNotes.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNotes.setBounds(225, 11, 76, 26);
		contentPane.add(lblNotes);
		
		JLabel lblKeepTrackOf = new JLabel("Keep track of your home ideas.");
		lblKeepTrackOf.setForeground(Color.BLUE);
		lblKeepTrackOf.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblKeepTrackOf.setBounds(142, 37, 196, 26);
		contentPane.add(lblKeepTrackOf);
		setResizable(false);
		try {
			NoteTitleButtons();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public static void NoteTitleButtons() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","root","!Crs12345");
	    java.sql.Statement statement = conn.createStatement();
	    ResultSet title = statement.executeQuery("Show Tables");
	    int x = 0, y = 165, wide = 483, height = 39;
	    for(; title.next(); y+=39) {
	    	String noteTitle = title.getString(1);
			JButton btnNewButton = new JButton(noteTitle.toUpperCase());
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new TextArea(noteTitle).setVisible(true);
				}
			});
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBackground(Color.BLUE);
			btnNewButton.setBounds(x, y, wide, height);
			contentPane.add(btnNewButton);
	    }
}
}
