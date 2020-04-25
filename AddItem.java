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

public class AddItem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

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

	/**
	 * Create the dialog.
	 */
	public AddItem() {
		setBounds(100, 100, 526, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Picture:");
			lblNewLabel.setBounds(10, 23, 70, 23);
			contentPanel.add(lblNewLabel);
		}
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
		
		Button button = new Button("Upload");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser photo = new JFileChooser();
				photo.showOpenDialog(null);
				File file = photo.getSelectedFile();
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setBounds(178, 11, 113, 102);
				contentPanel.add(lblNewLabel_1);
				lblNewLabel_1.setIcon(new ImageIcon(photo.toString()));
				try {
					FileInputStream inputStream = new FileInputStream(file);
				} catch (FileNotFoundException e1) { 
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(79, 23, 70, 22);
		contentPanel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FileInputStream inputStream = (FileInputStream) getIconImages();
						String userInput = textField.getText();
						String userInput2 = textPane.getText();
						String userInput3 = textField_1.getText();
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
