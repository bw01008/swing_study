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

//공통된 부분 추출해서 만든 추상클래스

@SuppressWarnings("serial")
public abstract class AbstractCustomTablePanel<T> extends JPanel {
	private JTable table;

	public AbstractCustomTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}// end of initialize()

	public DefaultTableModel getModel() {
		// 2차배열과 배열(을 반환하는 메소드)을 매개변수로 하는 생성자 호출
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	public Object[][] getData() {
		return new Object[][] { { null, null, null }, };
	}// end of getData

	// 컬럼명, 개수가 다르기때문에 하위클래스에서 정의하도록 추상메소드로 만들고 구현부 삭제 > 추상클래스 선언
	public abstract String[] getColumnNames();

	// setList도 구현부 달라서 추상메소드 선언 > 타입도 다르기때문에 제네릭에 T로 선언 > abstract지우고 구현부 생성 >
	// toArray부분만 추상메서드 선언
	public void setList(List<T> list) {
		Object[][] data = new Object[list.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);
		
		/*
		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250, 100);
		*/
		setAlignAndWidth();	//
	};
	
	protected abstract void setAlignAndWidth();

	//추상메서드 선언
	public abstract Object[] toArray(T t);

	
	protected void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();// 컬럼별로 가져오기때문에 컬럼수만큼 들어온다.
		// 컬럼별로 정렬할 Align 설정
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	public class CustomTableModel extends DefaultTableModel {
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
