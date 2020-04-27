package Code;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;

public class AddItem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddItem dialog = new AddItem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public AddItem() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
	}

	/**
	 * Create the dialog.
	 * @param userInput 
	 */
	public AddItem(String userInput) {
		setBounds(100, 100, 526, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(10, 136, 70, 23);
			contentPanel.add(lblName);
		}
		{
			JLabel lblIdea = new JLabel("Idea:");
			lblIdea.setBounds(10, 186, 70, 23);
			contentPanel.add(lblIdea);
		}
		{
			JLabel lblPrice = new JLabel("Price:");
			lblPrice.setBounds(10, 240, 39, 23);
			contentPanel.add(lblPrice);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(79, 170, 185, 60);
		contentPanel.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(79, 137, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 241, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Title = userInput;
						String Name = textField.getText();
						String Idea = textPane.getText();
						String Price = textField_1.getText();
						ConnectProjects.addToTable(Title, Name, Idea, Price);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
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
