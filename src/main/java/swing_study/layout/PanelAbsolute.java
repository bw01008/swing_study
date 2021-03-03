package swing_study.layout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAbsolute extends JPanel {
	private JTextField textField;

	public PanelAbsolute() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("앱솔루뜨~~~");
		lblNewLabel.setBounds(44, 98, 124, 32);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(166, 142, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(307, 142, 97, 23);
		add(btnNewButton);
	}
}
