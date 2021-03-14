package swing_study.component.Table;

import javax.swing.SwingConstants;

import swing_study.panel.Employee;

@SuppressWarnings("serial")
public class EmpTablePanel extends AbstractCustomTablePanel<Employee> {

	@Override
	protected void setAlignAndWidth() {
		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);
		setTableCellAlign(SwingConstants.RIGHT, 4);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250, 100, 100, 100, 100);
	}

	@Override
	public Object[] toArray(Employee e) {
		return new Object[] { 
				e.getEmpno(), 
				e.getEmpname(), 
				String.format("%s(%d)", e.getTitle().getTname(), e.getTitle().getTno()),
				e.getManager() == null ? "" : e.getManager().getEmpname(),
				String.format("%,d", e.getSalary()),
				String.format("%s(%d)", e.getDept().getDeptName(), e.getDept().getDeptNo())
			};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "사번", "사원명", "직책", "직속상사", "급여", "부서" };
	}

}
