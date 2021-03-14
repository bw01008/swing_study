package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;

@SuppressWarnings("serial")
public class JComboBoxEx03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private List<Department> deptList = new ArrayList<Department>();
	private JComboBox<Department> cmbDept;
	private DeptPanel pDept;
	private JButton btnAdd;
	private DefaultComboBoxModel<Department> model;
	private JButton btnConfirm;

	public JComboBoxEx03() {
		
		deptList.add(new Department(1, "마케팅", 8));
		deptList.add(new Department(2, "영업", 18));
		deptList.add(new Department(3, "개발", 28));
		initialize();

	}

	private void initialize() {
		setTitle("JCombo 실전예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));

		pDept = new DeptPanel();
		pLeft.add(pDept, BorderLayout.CENTER);

		JPanel pBtn = new JPanel();
		pLeft.add(pBtn, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		JPanel pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));

		cmbDept = new JComboBox<>();
		cmbDept.addActionListener(this);
		pRight.add(cmbDept);
		model = new DefaultComboBoxModel<Department>(new Vector<Department>(deptList));
		cmbDept.setModel(model);

		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}

	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department newDept = pDept.getDepartment();
		
		if(deptList.contains(newDept)) {
			JOptionPane.showMessageDialog(null, "중복아이템");
		}else {
			pDept.clearTf();
			model.addElement(newDept);
			JOptionPane.showMessageDialog(null, "추가되었습니다.");
		}
		
	}
	protected void actionPerformedBtnConfirm(ActionEvent e) {
		Object sel = model.getSelectedItem();
		String message = "";
		JOptionPane.showMessageDialog(null, sel);
	}
}
