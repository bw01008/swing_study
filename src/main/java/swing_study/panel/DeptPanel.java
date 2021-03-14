package swing_study.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeptPanel extends JPanel {
	private JTextField tfDeptNo;
	private JTextField tfDeptName;
	private JTextField tfFloor;

	public DeptPanel() {
		initialize();
	}

	private void initialize() {
		// TitleBorder설정
		setBorder(new TitledBorder(null, "부서정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// 레이아웃 설정
		setLayout(new GridLayout(0, 2, 10, 10));

		// 레이블 생성
		JLabel lblDeptNo = new JLabel("부서번호");
		lblDeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptNo);

		// 텍스트필드 생성
		tfDeptNo = new JTextField();
		tfDeptNo.setColumns(10);
		add(tfDeptNo);

		// 레이블 생성
		JLabel lblDeptName = new JLabel("부서명");
		lblDeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblDeptName);

		// 텍스트필드 생성
		tfDeptName = new JTextField();
		tfDeptName.setColumns(10);
		add(tfDeptName);

		// 레이블 생성
		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblFloor);

		// 텍스트필드 생성
		tfFloor = new JTextField();
		tfFloor.setColumns(10);
		add(tfFloor);
	}

	//텍스트 필드에 부서 정보 설정해주는 메소드 > 매개변수로 받은 객체의 필드값으로 설정해준다
	public void setDepartment(Department department) {
//		tfDeptNo.setText(String.valueOf(department.getDeptNo()));
		tfDeptNo.setText(department.getDeptNo() + "");
		tfDeptName.setText(department.getDeptName());
		tfFloor.setText(department.getFloor() + "");
	}

	//인스턴스 필드값으로 만든 객체를 반환해주는 메소드
	public Department getDepartment() {
		int deptNo = Integer.parseInt(tfDeptNo.getText().trim());
		String deptName = tfDeptName.getText().trim();
		int floor = Integer.parseInt(tfFloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}

	//텍스트필드 안을 공란으로 만들어주는 메소드
	public void clearTf() {
		tfDeptNo.setText("");
		tfDeptName.setText("");
		tfFloor.setText("");
	}
}
