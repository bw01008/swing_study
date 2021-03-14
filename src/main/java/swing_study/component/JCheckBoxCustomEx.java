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
//ArrayList로 목록 받아와서 체크박스 생성
@SuppressWarnings("serial")
public class JCheckBoxCustomEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	//Fruite타입의 ArrayList 선언
	private ArrayList<Fruit> list;
	private int sum;
	private JLabel lblRes;
	
	//ArrayList타입의 매개변수를 받는 생성자
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

		//***
		String title = "";
		for (Fruit f : list) {
			title += f.toString() + " "; // Fruit에 선언된 toString이 리스트에 있는 데이터를 읽어와서 문자열타입 변수에 저장
			JCheckBox ck = new JCheckBox(f.getName()); // list 안에 있는 객체들의 이름으로 체크박스 생성(JCheckBox) e.getSource()
			pCenter.add(ck); // pCenter의 패널에 생성한 체크박스를 추가해준다.
			ck.addItemListener(this); // itemListener를 달아준다.
		}
		lblTitle.setText(title);	//레이블에 title변수로 텍스트 설정

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		JCheckBox cb = (JCheckBox) arg0.getSource(); // 선택된 체크박스
		//선택된 체크박스 이름을 매개변수로 하는 생성자를 호출해서 객체를 생성해주고 그 객체가 담긴 리스트의 위치(인덱스)를 받아서 객체의 주소값을 받아서 변수에 저장
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
