package swing_study.component;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JTextFieldAreaEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pfPass1;
	private JPasswordField pfPass2;
	private JTextArea ta;
	private JLabel lblConfirm;
	private JDateChooser dateChooser;
	private JButton btnAdd;
	private JButton btnCancel;

	public JTextFieldAreaEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pCenter = new JPanel(); // pCenter 패널 생성
		contentPane.add(pCenter); // contentPane에 추가
		pCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pCenter.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea(); // 외부 접근을 위해 필드에 선언해줬다.
		ta.setEditable(false);
		scrollPane.setViewportView(ta);

		JPanel pNorth = new JPanel();
		// pNorth패널의 크기를 지정, 그에 맞게 프레임 사이즈도 커진다.(부모는 자식에 맞춰서 커진다.)
		// show advanced properties - setPreferredSize에서 설정해주면 된다.
		pNorth.setPreferredSize(new Dimension(450, 300));
		pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblName);
		// 텍스트필드가 추가되는 패널은 보더레이아웃이어야 가득차게 보인다.
		tfName = new JTextField();
		pNorth.add(tfName);
		tfName.setColumns(10);

		JLabel lblPass1 = new JLabel("비밀번호");
		lblPass1.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblPass1);

		pfPass1 = new JPasswordField();	//패스워드 필드 생성
		//패스워드 필드에 입력된 값을 가져와서 addDocumentListener에 위임하겠다는 뜻
		pfPass1.getDocument().addDocumentListener(listener);
		//화면에 비번대신 보여주는 문자를 지정
		pfPass1.setEchoChar('♥');
		//패널에 추가
		pNorth.add(pfPass1);
		
		JLabel lblPass2 = new JLabel("비밀번호 확인");
		lblPass2.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblPass2);

		pfPass2 = new JPasswordField();	//패스워드 필드 생성
		pfPass2.getDocument().addDocumentListener(listener);
		pfPass2.setEchoChar('♥');
		pNorth.add(pfPass2);

		JPanel panel = new JPanel();
		pNorth.add(panel);
		
		lblConfirm = new JLabel("");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.RED);
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 12));
		pNorth.add(lblConfirm);

		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblBirth);

		// 생성자 안에 new Date()를 넣어주면 오늘 날짜로 세팅된다.
		dateChooser = new JDateChooser(new Date());
		dateChooser.setDateFormatString("yyyy. MM. dd");
		pNorth.add(dateChooser);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pNorth.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pNorth.add(btnCancel);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			actionPerformedBtnCancel(arg0);
		}
		if (arg0.getSource() == btnAdd) {
			actionPerformedBtnAdd(arg0); // 메소드 호출
		}
//		if (arg0.getSource() == tfName) {
//			actionPerformedTfName(arg0);
//		}
	}

//	 텍스트 필드에 문자를 적고 엔터를 누르면 append가 호출되어 작성한 문자가 텍스트아리아에 들어간 뒤 텍스트필드는 공백으로 세팅
	protected void actionPerformedTfName(ActionEvent arg0) {
		// 텍스트 필드가 0이 아니라면(= 뭐라도 입력이 된다면)
		if (tfName.getText().length() != 0) {
			Date d = dateChooser.getDate();
			String msg = String.format("%s - %tF%n", tfName.getText(), d);
			// 해당 텍스트필드에 입력된 문자열을 가져와서 텍스트 아리아에 추가해주고 줄바꿈 해주는 메소드
			// ta.append(tfName.getText() + "\n");
			ta.append(msg);
			// 위 메소드 수행 후 텍스트필드를 공백으로 만들어준다.
			tfName.setText("");
		}
	}

	// 선생님 해설
	protected void actionPerformedBtnAdd(ActionEvent arg0) {
		// 추가 버튼을 눌렀을 때 "일치"와 동일하면 텍스트 필드에 작성된 내용을 텍스트아리아에 작성된다.
		if (lblConfirm.getText().equals("일치")) {
			Date d = dateChooser.getDate(); // %tF는 지정된 date형식
			String msg = String.format("%s - %tF%n", tfName.getText(), d);
			ta.append(msg);
			// 추가 버튼 후 공백으로 세팅
			tfName.setText("");
			pfPass1.setText("");
			pfPass2.setText("");
			// 추가 버튼 후 날짜는 오늘날짜로 세팅
			dateChooser.setDate(new Date());
			// 일치, 불일치 뜨는 곳에 공백세팅
			lblConfirm.setText("");
			// 성명 입력란에 커서 세팅
			tfName.requestFocus();
		} else {
			// 비밀번호 불일치시 비밀번호 확인 입력란을 공백으로 세팅
			pfPass2.setText("");
			// 비밍번호 인력란에 커서세팅
			pfPass1.requestFocus();
			// 입력한 부분 전체선택(블록지정)
			pfPass1.selectAll();
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent arg0) {
		tfName.setText("");
		pfPass1.setText("");
		pfPass2.setText("");
	}

	DocumentListener listener = new DocumentListener() {
	//password field가 추가/변경/수정될때마다 두 입력값을 비교하게 만든다.
		@Override
		public void removeUpdate(DocumentEvent e) {
			getMessage();// 메소드 호출
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			getMessage();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			getMessage();
		}

		private void getMessage() {
			// 두가지 방법이 있으니 골라쓰길 1.문자열 객체생성 2.valueOf메소드 호출
			String pw1 = new String(pfPass1.getPassword());
			String pw2 = String.valueOf(pfPass2.getPassword()); 
			// 문자열 비교 > 동일하면 일치, 동일하지 않으면 불일치 출력
			if (pw1.equals(pw2)) {
				lblConfirm.setText("일치");
			} else {
				lblConfirm.setText("불일치");
			}
		}
	};
}
