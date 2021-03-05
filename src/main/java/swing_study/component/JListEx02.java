package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JListEx02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfValue;
	private JList<String> nameList; // 리스트에 수정된 벡터를 달아주었다
	private ArrayList<String> stdList = new ArrayList<>(); // ArrayList생성
	private JList<String> nameList2;// 리스트에 모델을 넣어주었다.

	public JListEx02() {
		stdList.add("김인환"); // ArrayList에 데이터 추가
		stdList.add("이태훈");
		stdList.add("김상건");
		stdList.add("전수린");

		initialize();
	}

	private void initialize() {
		setTitle("실시간 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("이름 입력 후, <Enter>키");
		pNorth.add(lblTitle);

		tfValue = new JTextField();
		tfValue.addActionListener(this);
		pNorth.add(tfValue);
		tfValue.setColumns(10);

		// 1. 보더 레이아웃 패널 추가
		JPanel pList = new JPanel();
		pList.setBorder(new EmptyBorder(0, 100, 0, 100));
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new GridLayout(0, 2, 10, 10));

		// 2. 스크롤 패인 추가
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);

		// 3. 스크롤 페인 위에 리스트 추가
		nameList = new JList<>(); // JList 생성
		nameList.setListData(new Vector<String>(stdList)); // setListData로 리스트에 벡터를 삽입
		nameList.setFixedCellWidth(100);
		nameList.setVisibleRowCount(5); // 한번에 보이는 열의 수
		scrollPane.setViewportView(nameList);	//스크롤 페인 뷰포트 위에 리스트 추가
		// 또다른 스크롤 패인 생성 후 pList에 추가
		JScrollPane scrollPane_1 = new JScrollPane();
		pList.add(scrollPane_1);
		// 리스트 생성해서 스크롤페인의 뷰포트 위에 추가
		nameList2 = new JList<>();	
		//생성한 getModel()메소드를 호출해서 model을 리턴 받고, 리스트에 추가해준다
		nameList2.setModel(getModel(stdList)); //**********************
		scrollPane_1.setViewportView(nameList2);
	}
	
	//
	private ListModel<String> getModel(List<String> stdList) {
		//String 타입의 model생성
		DefaultListModel<String> model = new DefaultListModel<String>();
		// List 안에 있는 문자열들을 하나씩 풀어서 model에 추가
		for (String e : stdList) {
			model.addElement(e);
		}
		return model;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == tfValue) {
			actionPerformedTfValue(arg0);
		}
	}

	protected void actionPerformedTfValue(ActionEvent arg0) {
		// 텍스트필드에 입력된 텍스트를 가져온다.
		String value = tfValue.getText().trim();
		// 입력돤 텍스트를 String타입의 ArrayList에 추가한다.
		stdList.add(value);
		// 추가된 ArrayList를 매개변수로 넣어서 벡터생성
		Vector<String> v = new Vector<String>(stdList);
		//Jlist에 추가해준다(덮는다)
		nameList.setListData(v);
		// 추가 후 텍스트 필드를 공백으로
		tfValue.setText("");
		// 텍스트 필드에 커서세팅
		tfValue.requestFocus();
		// 리스트에 있는 모델들을 가져와서 변수에 저장
		DefaultListModel<String> model = (DefaultListModel)nameList2.getModel();
		
		model.addElement(value);
	}
}
