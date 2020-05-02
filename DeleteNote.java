package Code;
/*This set of code is designated for deleting
 *the entire note. It sends the
 *information to the deleteNote method in ConnectNotes
 *and executes an sql statement to make the command.
 * */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DeleteNote extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteTable dialog = new DeleteTable();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DeleteNote() {
		
	}
	/*
	 * Creates the gui outline of the dialogue
	 * box.
	 * */
	public DeleteNote(String userInput) {
		setBounds(100, 100, 450, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to delete " + userInput + "?");
		lblNewLabel.setBounds(78, 52, 240, 14);
		contentPanel.add(lblNewLabel);
		{//end gui design
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {//Sends the String title to deleteNote
						public void actionPerformed(ActionEvent e) { //for the SQL command to be executed.
							String Title = userInput;
							ConnectNotes.deleteNote(Title);
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