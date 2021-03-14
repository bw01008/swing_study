package swing_study.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class EmpPanel extends JPanel {
	private JTextField tfEmpname;
	private JTextField tfEmpno;
	private JComboBox cmbTitle;
	private JComboBox cmbManager;
	private JSpinner spinnerSalary;
	private JComboBox cmbDept;
	private JTextField spinnerDate;
	private JPasswordField tfPass;
	private JTextField tfPass2;

	/**
	 * Create the panel.
	 */
	public EmpPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "사원정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblEmpname = new JLabel("사원이름");
		lblEmpname.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblEmpname);
		
		tfEmpname = new JTextField();
		tfEmpname.setColumns(10);
		panel_1.add(tfEmpname);
		
		JLabel lblEmpno = new JLabel("사원번호");
		lblEmpno.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblEmpno);
		
		tfEmpno = new JTextField();
		tfEmpno.setColumns(10);
		panel_1.add(tfEmpno);
		
		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblTitle);
		
		cmbTitle = new JComboBox();
		panel_1.add(cmbTitle);
		
		JLabel lblManager = new JLabel("직속상사");
		lblManager.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblManager);
		
		cmbManager = new JComboBox();
		panel_1.add(cmbManager);
		
		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblSalary);
		
		spinnerSalary = new JSpinner();
		panel_1.add(spinnerSalary);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblDept);
		
		cmbDept = new JComboBox();
		panel_1.add(cmbDept);
		
		JLabel lblDate = new JLabel("입사일");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblDate);
		
		spinnerDate = new JTextField();
		spinnerDate.setColumns(10);
		panel_1.add(spinnerDate);
		
		JLabel label_7 = new JLabel("비밀번호");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(label_7);
		
		tfPass = new JPasswordField();
		tfPass.setColumns(10);
		panel_1.add(tfPass);
		
		JLabel label_8 = new JLabel("비밀번호 확인");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(label_8);
		
		tfPass2 = new JTextField();
		tfPass2.setColumns(10);
		panel_1.add(tfPass2);
		
		JPanel pSpace = new JPanel();
		panel_1.add(pSpace);
		
		JPanel pResult = new JPanel();
		panel_1.add(pResult);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.RED);
		pResult.add(lblNewLabel);
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pPic = new JPanel();
		pTop.add(pPic);
		pPic.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPic = new JLabel("");
		pPic.add(lblPic);
		
		JPanel pBtn = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pBtn.getLayout();
		pPic.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnPicAdd = new JButton("사진추가");
		pBtn.add(btnPicAdd);
	}
	
	public void setEmp(Employee emp) {
		tfEmpno.setText(emp.getEmpno() + "");
		tfEmpname.setText(emp.getEmpname());
		
	}
	
	public Employee getEmp() {

		return null;
	}
	
	public void clearTf() {

	}

}
