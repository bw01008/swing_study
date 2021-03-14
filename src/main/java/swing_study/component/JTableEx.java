package swing_study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import swing_study.component.Table.Customer;
import swing_study.component.Table.DeptTablePanel;
import swing_study.component.Table.EmpTablePanel;
import swing_study.component.Table.MyTablePanel;
import swing_study.component.Table.Product;
import swing_study.component.Table.Sale;
import swing_study.component.Table.SaleTablePanel;
import swing_study.component.Table.Student;
import swing_study.component.Table.TitleTablePanel;
import swing_study.panel.Department;
import swing_study.panel.Employee;
import swing_study.panel.Title;

@SuppressWarnings("serial")
public class JTableEx extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private List<Student> stdList = new ArrayList<>();
	private List<Department> deptList = new ArrayList<>();
	private List<Title> titleList = new ArrayList<>();
	private List<Employee> empList = new ArrayList<>();
	private List<Sale> saleList = new ArrayList<>();
	
	public JTableEx() {
		stdList.add(new Student(1, "김인환", 50,	60,	60));
		stdList.add(new Student(2, "이태훈", 70,	71,	70));
		stdList.add(new Student(3, "김상건", 90,	92,	100));
		stdList.add(new Student(4, "전수린", 60,	63,	67));
		
		deptList.add(new Department(1, "개발", 8));
		deptList.add(new Department(2, "인사", 18));
		deptList.add(new Department(3, "총무", 28));
		
		titleList.add(new Title(1, "사장"));
		titleList.add(new Title(2, "부장"));
		titleList.add(new Title(3, "과장"));
		titleList.add(new Title(4, "대리"));
		titleList.add(new Title(5, "사원"));
	
		empList.add(new Employee(1, "이성래", titleList.get(0), null, 4500000, deptList.get(0)));
		empList.add(new Employee(2, "이태훈", titleList.get(1), new Employee(1, "이성래"), 1500000, deptList.get(0)));
		empList.add(new Employee(3, "이태훈", titleList.get(2), new Employee(1, "이성래"), 2000000, deptList.get(0)));
		
		saleList.add(new Sale(1, new Date(112, 06, 20), new Customer(12003), new Product("PA"), 2));
		saleList.add(new Sale(2, new Date(112, 06, 23), new Customer(12001), new Product("PA"), 1));
		saleList.add(new Sale(3, new Date(112, 07, 05), new Customer(12003), new Product("PA"), 2));
		saleList.add(new Sale(4, new Date(112, 07, 17), new Customer(12003), new Product("PA"), 2));
		
		initialize();
	}
	private void initialize() {
		setTitle("JTable 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 974, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		JPanel pTable1 = new JPanel();
		pTable1.setBorder(new TitledBorder(null, "기본테이블 생성", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pTable1);
		pTable1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane1 = new JScrollPane();
		pTable1.add(scrollPane1, BorderLayout.CENTER);
		
		table1 = new JTable();
		table1.setModel(getModel());	// 칼럼과 데이터 설정후 메소드로 빼줌(getModel())
		scrollPane1.setViewportView(table1);
		
		JPanel pTable2 = new JPanel();
		pTable2.setBorder(new TitledBorder(null, "커스텀테이블", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pTable2);
		pTable2.setLayout(new BorderLayout(0, 0));
		
		////////////////////////////////////// list추가
		MyTablePanel pCustomTable2 = new MyTablePanel(); //몹핑@@@
		pCustomTable2.setList(stdList);	// 컬렉션 > 배열로 바꾸는 메소드 호출
		pTable2.add(pCustomTable2, BorderLayout.CENTER);
		
		JPanel pTable3 = new JPanel();
		contentPane.add(pTable3);
		pTable3.setLayout(new BorderLayout(0, 0));
		
		DeptTablePanel pDeptTable3 = new DeptTablePanel();	//몹핑@@@
		pDeptTable3.setList(deptList); 
		pTable3.add(pDeptTable3, BorderLayout.CENTER);
		
		JPanel pTable4 = new JPanel();
		contentPane.add(pTable4);
		pTable4.setLayout(new BorderLayout(0, 0));
		
		TitleTablePanel pTitleTable4 = new TitleTablePanel();	//몹핑@@@
		pTitleTable4.setList(titleList);
		pTable4.add(pTitleTable4, BorderLayout.CENTER);
		
		JPanel pTable5 = new JPanel();
		contentPane.add(pTable5);
		pTable5.setLayout(new BorderLayout(0, 0));
		
		EmpTablePanel pEmpTable5 = new EmpTablePanel();		//몹핑@@@
		pEmpTable5.setList(empList);
		pTable5.add(pEmpTable5, BorderLayout.CENTER);
		
		JPanel pTable6 = new JPanel();
		contentPane.add(pTable6);
		pTable6.setLayout(new BorderLayout(0, 0));
		
		SaleTablePanel pSaleTable6 = new SaleTablePanel();
		pSaleTable6.setList(saleList);
		pTable6.add(pSaleTable6, BorderLayout.CENTER);
	}
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;	// 칼럼이름 배열, 데이터 이차배열 모두 메소드로 따로 빼줌(getColumnsNames(), getDate())
	}
	
	//클래스 생성 - 테이블클래스를 상속받는다.
	class CustomTableModel extends DefaultTableModel{
		//데이터를 2차배열로 받아오기때문에 2차배열을 매개변수로 하는 생성자
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		//테이블 셀 편집 가능 여부 > false로 변경
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
		
	}
	public Object[][] getData() {
		return new Object[][] {
			{1, "박유진", 10, "여자"},
			{2, "이태훈", 11, "남자"},
		};
	}
	public String[] getColumnNames() {
		return new String[] {
			"학생번호", "학생명", "나이", "성별"
		};
	}

}
