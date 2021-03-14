package swing_study.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JComboBoxEx02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> cmb;
	private JLabel lblcmb;
	private String[] fruits = { "Apple", "pear", "cherry" };
	private String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	private ImageIcon[] icons = { 
			new ImageIcon(imgPath + "apple.jpg"), 
			new ImageIcon(imgPath + "pear.jpg"),
			new ImageIcon(imgPath + "cherry.jpg") 
			};
	private Map<String, ImageIcon> map = new HashMap<String, ImageIcon>();
	

	
	public JComboBoxEx02() {
		for(int i = 0; i < icons.length; i++) {
			map.put(fruits[i], icons[i]);
		}
		initialize();
		
	}

	

	private void initialize() {
		setTitle("JCombo 이벤트 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		cmb = new JComboBox<>();
		cmb.setModel(new DefaultComboBoxModel<String>(fruits));	//fruits 배열을 model로 추가
		cmb.setSelectedIndex(-1);//선택 초기화
		cmb.addActionListener(this);
		contentPane.add(cmb);

		lblcmb = new JLabel("");
		lblcmb.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblcmb);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmb) {
			actionPerformedCmb(e);
		}
	}

	protected void actionPerformedCmb(ActionEvent e) {
		Object obj = cmb.getSelectedItem();
		lblcmb.setIcon(map.get(obj));
	}
}
