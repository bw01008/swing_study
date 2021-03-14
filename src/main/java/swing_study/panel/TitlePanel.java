package swing_study.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class TitlePanel extends JPanel {
	private JTextField tfTno;
	private JTextField tfTname;

	/**
	 * Create the panel.
	 */
	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 20, 20));
		
		JLabel lblTno = new JLabel("직책번호");
		lblTno.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblTno);
		
		tfTno = new JTextField();
		add(tfTno);
		tfTno.setColumns(10);
		
		JLabel lblTname = new JLabel("직책이름");
		lblTname.setHorizontalAlignment(SwingConstants.TRAILING);
		add(lblTname);
		
		tfTname = new JTextField();
		tfTname.setColumns(10);
		add(tfTname);
	}
	
	public void setTitle(Title title) {
		tfTno.setText(title.getTno() + "");
		tfTname.setText(title.getTname());
	}
	
	public Title getTitle() {
		int tno = Integer.parseInt(tfTno.getText().trim());
		String tname = tfTname.getText().trim();
		return new Title(tno, tname);
	}
	
	public void clearTf() {
		tfTno.setText("");
		tfTname.setText("");
	}

}
