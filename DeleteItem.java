package Code;
/*This set of code is designated for deleting
 *an item in a specific project table. It sends the
 *information to the deleteTable method in ConnectProjects
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

public class DeleteItem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteItem dialog = new DeleteItem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DeleteItem() {
		getContentPane().setBackground(Color.WHITE);
		
	}

	/*
	 * The next few lines creates the design of
	 * the dialogue box
	 * */
	public DeleteItem(String userInput) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Enter Name of Item You Would Like to Delete:");
			lblNewLabel.setBounds(10, 109, 254, 14);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(262, 106, 168, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			//End design of dialogue box
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {//On button click, sends the two fields to
					public void actionPerformed(ActionEvent e) { //deleteItem to execute the sql command
						String title = userInput;                //to remove the specific item.
						String Name = textField.getText();
						ConnectProjects.deleteItem(title, Name);
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
