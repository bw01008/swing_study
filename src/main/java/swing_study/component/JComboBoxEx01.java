package swing_study.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JComboBoxEx01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> cmb1;
	private JComboBox<String> cmb2;
	private JComboBox<String> cmb3;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	public JComboBoxEx01() {
		initialize();

		addDataCmb1();
		addDataCmb2(); // 모델을 활용한 추가
		addDataCmb3(); // ArrayList를 Vector로 감싸서 추가
	}

	private void addDataCmb1() {
		String[] fruits = { "Apple", "Banana", "Kiwi" };
		for (String f : fruits) {
			cmb1.addItem(f);
		}

	}

	private void addDataCmb2() {
		String[] fruits = { "Apple", "Banana", "Kiwi" };
		//리스트와 모델은 붙어있다. 모델에 데이터가 있으면 가져와라(getModel()) > 근데 없음
		DefaultComboBoxModel<String> cmb = (DefaultComboBoxModel<String>)cmb2.getModel();
		//여기서 넣어준다
		for (String f : fruits) {
			cmb.addElement(f);
		}
	}

	private void addDataCmb3() {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Kiwi");
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new Vector<>(fruits));
		cmb3.setModel(model);

	}

	private void initialize() {
		setTitle("JCombo 기본예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));

		JPanel pCmb1 = new JPanel();
		contentPane.add(pCmb1);

		cmb1 = new JComboBox<>();
		pCmb1.add(cmb1);

		tf1 = new JTextField();
		tf1.addActionListener(this);
		pCmb1.add(tf1);
		tf1.setColumns(10);

		JPanel pCmb2 = new JPanel();
		contentPane.add(pCmb2);

		cmb2 = new JComboBox<>();
		pCmb2.add(cmb2);

		tf2 = new JTextField();
		tf2.addActionListener(this);
		pCmb2.add(tf2);
		tf2.setColumns(10);

		JPanel pCmb3 = new JPanel();
		contentPane.add(pCmb3);

		cmb3 = new JComboBox<>();
		pCmb3.add(cmb3);

		tf3 = new JTextField();
		tf3.addActionListener(this);
		pCmb3.add(tf3);
		tf3.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf3) {
			actionPerformedTf3(e);
		}
		if (e.getSource() == tf2) {
			actionPerformedTf2(e);
		}
		if (e.getSource() == tf1) {
			actionPerformedTf1(e);
		}
	}

	protected void actionPerformedTf1(ActionEvent e) {
		String item = tf1.getText().trim();
		cmb1.addItem(item);
		tf1.setText("");
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
	}

	protected void actionPerformedTf2(ActionEvent e) {
		String item = tf2.getText().trim();
		cmb2.addItem(item);
		tf2.setText("");
	}

	protected void actionPerformedTf3(ActionEvent e) {
		String item = tf3.getText().trim();
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmb3.getModel();
		model.addElement(item);
		tf3.setText("");
	}
}
