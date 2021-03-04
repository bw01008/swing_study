package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JRadioButtonEx extends JFrame implements ItemListener {
	private JPanel contentPane;
	// 이미지파일을 불러올 path설정(절대경로로 설정시 다른 컴퓨터에서 파일을 불러 올 수 없다.)
	private String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	private ImageIcon[] icons = { new ImageIcon(imgPath + "apple.jpg"), new ImageIcon(imgPath + "pear.jpg"),
			new ImageIcon(imgPath + "cherry.jpg") };
	private JLabel lblImg;

	public JRadioButtonEx() {
		initialize(); // 보이는 부분을 초기화(UI를 꾸미기 위한 메소드)
	}

	private void initialize() {
		setTitle("라디오버튼예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));

		JPanel pLeft = new JPanel(); // pLeft이름으로 패널 생성
		pLeft.setBorder(new TitledBorder(null, "간단한 라디오 버튼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft); // contentPane에 pLeft추가
		pLeft.setLayout(new BorderLayout(0, 0));

		CustomRadioButton pRadio = new CustomRadioButton(); // pRadio 객체 생성
		pLeft.add(pRadio); // pLeft패널 위에 pRadio패널 추가 / getter메소드가 있기때문에 필드에 접근이 가능하다

		JPanel pRight = new JPanel(); // pRight이름으로 패널 생성
		pRight.setBorder(new TitledBorder(null, "응용 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));

		CustomRadioButton panel = new CustomRadioButton();
		pRight.add(panel, BorderLayout.NORTH);

		lblImg = new JLabel("New label");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblImg, BorderLayout.CENTER);

		// rdbtns의 3개 버튼에 ItemListener기능을 달아준다
		for (JRadioButton r : panel.getRdBtns()) {
			r.addItemListener(this);
		}
		
		panel.getRdbtnApple().setSelected(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//라디오 버튼이 선택(클릭)되었을때 아이텐리스너 기능이 실행이 되면서 선택된 버튼의 정보가 넘어와서 변수에 저장된다
		JRadioButton rd = (JRadioButton) e.getSource();
		// 넘어온 라디오 버튼상태가 선택된 상태면 그 버튼정보의 Text를 가져와서 변수 text에 저장
		if (e.getStateChange() == ItemEvent.SELECTED) {
//			JOptionPane.showMessageDialog(null, rd.getText()); 선택된 버튼의 텍스트가 팝업으로 뜬다
			String text = rd.getText();
			switch(text) {
			case "사과" :
				lblImg.setIcon(icons[0]);
				break;
			case "배" : 
				lblImg.setIcon(icons[1]);
				break;
			default :
				lblImg.setIcon(icons[2]);
			}
		}
	}

}
