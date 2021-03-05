package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class JListEx02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfValue;
	private JList<String> nameList; // 이름이 입력될때마다 추가되야함(외부 접근하기 위해 필드로 빼줬다)
	private ArrayList<String> stdList = new ArrayList<>(); // ArrayList생성
	private JList<String> nameList2;

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
		scrollPane.setViewportView(nameList);

		JScrollPane scrollPane_1 = new JScrollPane();
		pList.add(scrollPane_1);

		nameList2 = new JList<>();
		nameList2.setModel(getModel(stdList));
		scrollPane_1.setViewportView(nameList2);
	}

	private ListModel<String> getModel(List<String> stdList) {
		DefaultListModel<String> model = new DefaultListModel<String>();
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
		// 텍스트필드에 있는 텍스트를 가져온다.
		String value = tfValue.getText().trim();
		// 입력한 이름을 팝업창에 띄워준다.
//		JOptionPane.showMessageDialog(null, value);
		// 입력한 이름을 ArrayList에 추가한다.
		stdList.add(value);
		// 리스트에 수정된 벡터를 다시 달아준다.
		nameList.setListData(new Vector<String>(stdList));
		// 추가 후 텍스트 필드를 공백으로
		tfValue.setText("");
		// 텍스트 필드에 커서세팅
		tfValue.requestFocus();
		
		DefaultListModel<String> model = (DefaultListModel<String>) nameList2.getModel();
		model.addElement(value);
	}
}
