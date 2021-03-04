package swing_study.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSetDept;
	private JButton btnGetDept;
	private DeptPanel pDept;
	private JButton btnClear;

	/**
	 * Create the frame.
	 */
	public JPanelEx() {
		initialize();
	}

	private void initialize() {
		setTitle("부서정보");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pDept = new DeptPanel(); // 디자인에서 contentpane 위에 패널을 올리고 Morph - subclass로 만들어 둔 패널을 합친다.
		contentPane.add(pDept, BorderLayout.CENTER); // contentPane 중앙에 패널 추가

		JPanel pBtn = new JPanel(); // 패널 생성
		contentPane.add(pBtn, BorderLayout.SOUTH);	// contentPane 아래쪽에 패널 추가

		btnSetDept = new JButton("부서설정");
		btnSetDept.addActionListener(this);
		pBtn.add(btnSetDept);

		btnGetDept = new JButton("부서가져오기");
		btnGetDept.addActionListener(this);
		pBtn.add(btnGetDept);

		btnClear = new JButton("초기화");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnGetDept) {
			actionPerformedBtnGetDept(e);
		}
		if (e.getSource() == btnSetDept) {
			actionPerformedBtnSetDept(e);
		}
	}

	protected void actionPerformedBtnSetDept(ActionEvent e) {
		Department dept = new Department(1, "기획", 9);	//객체 생성
		pDept.setDepartment(dept);	//생성된 객체를 매개변수로 넣어서 메소드 호출
	}

	protected void actionPerformedBtnGetDept(ActionEvent e) {
		Department dept = pDept.getDepartment(); // 메소드 호출해서 변수에 저장
		JOptionPane.showMessageDialog(null, dept); // 리턴된 객체 메시지로 출력
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pDept.clearTf();
	}
}
