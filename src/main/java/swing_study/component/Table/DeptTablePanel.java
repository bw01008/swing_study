package swing_study.component.Table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import swing_study.panel.Department;

@SuppressWarnings("serial")
public class DeptTablePanel extends JPanel {
	private JTable table;

	public DeptTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getModel()); // 1번 : getModel()을 호출해서 테이블
		scrollPane.setViewportView(table);
	}
	//2번
	public DefaultTableModel getModel() {
		// 2차배열과 배열(을 반환하는 메소드)을 매개변수로 하는 생성자 호출
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}
	//3번
	public Object[][] getData() {
		return new Object[][] { { null, null, null }, };
	}// end of getData
	//4번
	public String[] getColumnNames() {
		return new String[] { "부서 번호", "부서명", "위치" };
	}// end of getColumnNames

	// 리스트를 받아와서 2차배열에 넣어주고 모델달아주는 메소드
	public void setList(List<Department> deptList) {
		Object[][] data = new Object[deptList.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(deptList.get(i));
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250, 100);
	}

	private void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	private void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();// 컬럼별로 가져오기때문에 컬럼수만큼 들어온다.
		// 컬럼별로 정렬할 Align 설정
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	private Object[] toArray(Department department) {
		Object[] row = new Object[] { department.getDeptNo(), department.getDeptName(), department.getFloor() };
		return row;
	}
	//5번
	private class CustomTableModel extends DefaultTableModel {
		// 2차배열을 매개변수로 하는 생성자 생성(super)
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		// isCellEditable메소드 오버라이딩 > false를 반환하면서 테이블에서 수정 불가하도록 설정
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}// end of CustomTableModel

}// end of class
