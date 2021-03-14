package swing_study.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import swing_study.panel.Department;
import swing_study.panel.DeptPanel;
import swing_study.panel.EmpPanel;
import swing_study.panel.Employee;
import swing_study.panel.Title;
import swing_study.panel.TitlePanel;

@SuppressWarnings("serial")
public class JTabbedPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnConfirm;
	private JTabbedPane tabbedPane;
	private JPanel DeptPanel;
	private DeptPanel pDept;
	private TitlePanel pTitle;
	private EmpPanel pEmp;


	public JTabbedPaneEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JTabbedPane");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pDept = new DeptPanel();
		tabbedPane.addTab("부서", null, pDept, "부서관리");	//~관리는 툴팁으로 마우스를 올리면 뜬다
		
		pTitle = new TitlePanel();
		tabbedPane.addTab("직책", null, pTitle, "직책관리");
		
		pEmp = new EmpPanel();
		tabbedPane.addTab("사원", null, pEmp, "사원관리");
		
		JPanel pbtn = new JPanel();
		contentPane.add(pbtn, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pbtn.add(btnConfirm);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
	}
	protected void actionPerformedBtnConfirm(ActionEvent e) {
		//선택된 탭을 가져와서
		Component comp = tabbedPane.getSelectedComponent();	//선택된 패널 가져와서 comp에 저장(deptPanel, titlePanel, empPanel)
		System.out.println(comp);
		//getxx()호출
		if(comp.equals(pDept)) {
			DeptPanel deptPanel = (DeptPanel) comp;
			Department department = deptPanel.getDepartment();
			JOptionPane.showMessageDialog(null, department);
		}else if(comp.equals(pTitle)) {
			TitlePanel titlePanel = (TitlePanel) comp;
			Title title = titlePanel.getTitle();
			JOptionPane.showMessageDialog(null, title);
		}
	
//		EmpPanel emppanel = comp;
	}
}
