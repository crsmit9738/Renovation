package Code;
/*This set of code is designated for updating
 *the body to the specific notes table. It sends the
 *information to the updateNote method in ConnectNotes
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
import javax.swing.JTextPane;

public class UpdateNote extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateNote dialog = new UpdateNote();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UpdateNote(){
		
	}

	/*
	 * Creates the gui outline of the dialogue
	 * box.
	 * */
	public UpdateNote(String userInput) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Update Text:");
			lblNewLabel.setBounds(10, 111, 103, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(87, 57, 265, 135);
		contentPanel.add(textPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{//end gui design
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {//Takes the title and body from the textpanes and
					public void actionPerformed(ActionEvent e) { //sends it to the updatNote method.
						String Title = userInput;
						String Body = textPane.getText();
						ConnectNotes.UpdateNote(Title, Body);
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
