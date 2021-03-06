package Code;
/*This set of code is designated for creating
 *an new to the projects by creating a new table. It sends the
 *information to the createProject method in ConnectProjects
 *and executes an sql statement to make the command.
 * */
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TableNamer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TableNamer dialog = new TableNamer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Creates the gui outline of the dialogue
	 * box.
	 * */
	public TableNamer() {
		setBounds(100, 100, 450, 188);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of New Project:");
		lblNewLabel.setBounds(30, 53, 112, 14);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(152, 50, 151, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{//end gui design
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {//takes the user input and sends it to createProject
					public void actionPerformed(ActionEvent e) { //to make the new table
						String userInput = textField.getText();
						ConnectProjects.createProject(userInput);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {//Just sets the frame visibility to false and closes the window.
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
