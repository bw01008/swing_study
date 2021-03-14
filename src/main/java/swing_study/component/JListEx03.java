package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;

@SuppressWarnings("serial")
public class JListEx03 extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnAdd;
	private JPanel pRight;
	private JPanel pLeftSouth;
	private DeptPanel pLeftCenter; // Morph하는 순간 DeptPanel이 pLeftCenter의 타입으로 들어온다.
	private JPanel pLeft;
	private JList<Department> deptList;
	private JPanel pBtns;
	private JButton btnConfirm;
	private JButton btnUpdate;
	private JButton btnDelete;
	private DefaultListModel<Department> model; // list에 모델을 이용해서 추가 -> Department 객체가 추가 되기때문에 타입이 Department

	public JListEx03() {
		initialize();
		// 매개변수 모두 받는 생성자 호출해서 객체 생성한다음 리스트에 모델을 이용해서 요소로 추가
		model.addElement(new Department(1, "마케팅", 8));
		model.addElement(new Department(2, "영업", 18));
		model.addElement(new Department(3, "개발", 28));
	}

	private void initialize() {
		setTitle("JList 응용예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 0));

		pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));

		pLeftCenter = new DeptPanel(); // Morph > subclass > deptPanel
		pLeft.add(pLeftCenter, BorderLayout.CENTER);

		pLeftSouth = new JPanel();
		pLeft.add(pLeftSouth, BorderLayout.SOUTH);
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pLeftSouth.add(btnAdd);

		// 패널을 보더레이아웃으로 바꾸고, 보더 센터에 스크롤 패인 추가 후, 뷰포트에 리스트 추가
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "부서 목록", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));

		// Department 타입의 리스트 생성(위에 선언해줌)
		deptList = new JList<>();
		// 하나만 선택하게...?
		deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 생성한 getDeptModel()메소드를 호출해서 model을 리턴 받고, 리스트에 추가해준다
		deptList.setModel(getDeptModel());
		// 패널 위에 리스트 추가
		pRight.add(deptList);

		pBtns = new JPanel();
		pRight.add(pBtns, BorderLayout.SOUTH);

		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtns.add(btnConfirm);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);

		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pBtns.add(btnDelete);
	}

	private ListModel<Department> getDeptModel() {
		// Department타입의 모델 생성
		model = new DefaultListModel<Department>();
		return model;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnDelete) {
			actionPerformedBtnDelete(arg0);
		}
		if (arg0.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(arg0);
		}
		if (arg0.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(arg0);
		}
		if (arg0.getSource() == btnAdd) {
			// 텍스트 필드에 있는 텍스트들을 변경 후 (pLeftSouth에 위치한)추가버튼이 수정버튼이면, else문에 있는 메소드가 호출된다.
			if (btnAdd.getText().equals("추가")) {
				actionPerformedBtnAdd(arg0);
			} else {
				actionPerformedUpate(arg0);
			}
		}
	}

	private void actionPerformedUpate(ActionEvent arg0) {
		// 텍스트 필드에 입력된 값들로 새로운 객체 생성
		Department upDept = pLeftCenter.getDepartment();
		// 수정해야할 객체의 위치 인덱스를 가져온다
		int idx = deptList.getSelectedIndex();
		// 변경
		model.setElementAt(upDept, idx);
		// 텍스트 필드 공백으로 변경
		pLeftCenter.clearTf();
		// 버튼 이름 변경
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, "수정완료되었습니다.");

	}

	// 추가 버튼을 눌렀을 때 tf에 작성한 정보가 리스트에 추가되게 해주는 메소드
	protected void actionPerformedBtnAdd(ActionEvent arg0) {
		// 텍스트필드에 작성된 텍스트로 생성한 객체를 반환하는 메소드를 호출해서 변수에 저장
		Department dept = pLeftCenter.getDepartment();
		// 텍스트필드를 공백으로 만들어주는 메소드 호출
		pLeftCenter.clearTf();
		// 모델에 반환받은 객체를 추가
		model.addElement(dept);
		JOptionPane.showMessageDialog(null, "추가되었습니다.");
	}

	// 확인 버튼을 눌렀을 때 선택한 요소의 정보를 띄워주는 메소드
	protected void actionPerformedBtnConfirm(ActionEvent arg0) {
		// 부서목록에서 선택된 부서의 인덱스 번호로 찾아서 반환
		int idx = deptList.getSelectedIndex(); // 선택된 인덱스
		// 선택한 요소의 인덱스 값으로 요소의 정보를 받아와서 변수에 저장
		Department selDept = model.get(idx);
		String message1 = String.format("%d번부서, %s부서, %d층", selDept.getDeptNo(), selDept.getDeptName(),
				selDept.getFloor());
		// 부서목록에서 선택된 부서의 값으로 찾아서 반환
		Department dept = deptList.getSelectedValue();
		String message = String.format("%d번부서, %s부서, %d층", dept.getDeptNo(), dept.getDeptName(), dept.getFloor());
		JOptionPane.showMessageDialog(null, message + "\n" + message1);
	}

	// 수정 버튼을 눌렀을 때 선택한 요소의 정보를 tf에 불러오는 메소드
	protected void actionPerformedBtnUpdate(ActionEvent arg0) {
		// 선택한 요소의 정보를 변수에 저장
		Department selDept = deptList.getSelectedValue();
		// setDepartment메소드를 호출해서 tf에 불러오기
		pLeftCenter.setDepartment(selDept);
		// 버튼 이름 변경
		btnAdd.setText("수정");

	}

	// 삭제 버튼이 눌렸을 때 동작하는 메소드
	protected void actionPerformedBtnDelete(ActionEvent arg0) {
		// 리스트에서 선택된 객체의 값을 받아온다.
		Department deleteDept = deptList.getSelectedValue();
		model.removeElement(deleteDept);
		JOptionPane.showMessageDialog(null, "삭제되었습니다.");

	}
}
