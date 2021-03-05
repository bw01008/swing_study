package swing_study.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	private ImageIcon[] icons = { 
			new ImageIcon(imgPath + "icon01.png"), 
			new ImageIcon(imgPath + "icon02.png"),
			new ImageIcon(imgPath + "icon03.png"), 
			new ImageIcon(imgPath + "icon04.png") 
			};
	
	private String[] fruits = new String[] { "Apple", "Banana", "Kiwi", "Mango", "Pear", "Peach", "Berry","StrawBerry", "Blackberry" };
	
	private JButton btn01;
	
	private JList<String> strList;

	public JListEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JList 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));

		//*** 리스트 생성자를 호출할때 매개변수를 넣으면 되긴 되는데 윈도우 빌더에서 화면출력을 지원하지 않아서 따로 데이터 입력을 해줘야한다.
		// JList생성, 필드에 선언해둔 배열을 생성자의 매개변수에 대입
		strList = new JList<String>();
		//setListData는 생성된 리스트에 데이터를 삽입해준다.
		strList.setListData(fruits);
		contentPane.add(strList);	
		
		JList<ImageIcon> list = new JList<>();
		//생성된 리스트에 필드에 선언된 배열을 삽입해준다.
		list.setListData(icons);
		contentPane.add(list);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);

		btn01 = new JButton("첫 리스트 선택 확인");
		btn01.addActionListener(this);
		pBtns.add(btn01);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btn01) {
			actionPerformedBtn01(arg0);
		}
	}
	//첫리스트 선택확인 버튼 눌렀을때 actionPerformed
	protected void actionPerformedBtn01(ActionEvent arg0) {
		//1. 리스트에서 선택된 요소의 인덱스 반환해서 저장
		int idx = strList.getSelectedIndex();	
		//2. 리스트에서 선택된 요소의 값을 반환해서 저장
		String selStr = strList.getSelectedValue();	
		// 리스트에서 선택된 항목(들)의 리스트를 반환해서 저장
		List<String> selectedList = strList.getSelectedValuesList();
		String message = String.format("index : %d%n selectedValue : %s%n selectedList %s%n",
										idx, selStr,selectedList);

		JOptionPane.showMessageDialog(null, message);	//팝업창을 띄운다
	}
}
