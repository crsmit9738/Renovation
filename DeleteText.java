package Code;
/*This set of code is designated for deleting
 *text to the specified table. It sends the
 *information to the deleteText method in ConnectNotes
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

public class DeleteText extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteText dialog = new DeleteText();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DeleteText() {
		getContentPane().setBackground(Color.WHITE);
		
	}

	/*
	 * Creates the gui outline of the dialogue
	 * box.
	 * */
	public DeleteText(String userInput) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Enter text You Would Like to Delete:");
			lblNewLabel.setBounds(10, 109, 236, 14);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(238, 106, 168, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{//end gui design
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {//takes the title and note and sends it
					public void actionPerformed(ActionEvent e) { //to the deleteText method in ConnectNotes.
						String title = userInput;
						String body = textField.getText();
						ConnectNotes.deleteText(title, body);
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