package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JCheckBoxCustomEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private ArrayList<Fruit> list;
	private int sum;
	private JLabel lblRes;

	public JCheckBoxCustomEx(ArrayList<Fruit> list) {
		this.list = list;
		initialize();
//		list.forEach(s->System.out.println(s));
	}

	private void initialize() {
		setTitle("실전 체크박스");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("New label");
		pNorth.add(lblTitle);

		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);

		lblRes = new JLabel("New label");
		pSouth.add(lblRes);

		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);

		//
		String title = "";
		for (Fruit f : list) {
			title += f.toString() + " "; // Fruit에 선언된 toString이 읽어오는걸 타이틀에 적어준다.
			JCheckBox ck = new JCheckBox(f.getName()); // list 안에 있는 객체들의 이름으로 체크박스 생성
			pCenter.add(ck); // pCenter의 패널에 생성한 체크박스를 추가해준다.
			ck.addItemListener(this); // itemListener를 달아준다.
		}
		lblTitle.setText(title);

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		JCheckBox cb = (JCheckBox) arg0.getSource(); // 선택된 체크박스
		// getText된 이름(사과, 배, 체리)가 들어간 생성자로 객체 3개 생성
		Fruit selectedFruit = list.get(list.indexOf(new Fruit(cb.getText())));

		// 체크박스가 선택되면 총가격에 금액을 더하고, 체크가 해제되면 총가격에 금액이 빠진다.
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			sum += selectedFruit.getPrice();
		} else {
			sum -= selectedFruit.getPrice();
		}

		lblRes.setText(sum + "");

	}

}
