package swing_study.component.Table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class MyTablePanel extends JPanel {
	private JTable table;

	public MyTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel()); // getModel로 메소드 뺴기(칼럼이랑 데이터)
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 테이블에서 하나만 선택 가능하도록 세팅(원래는 컨트롤누르면 다중선택가능)
		scrollPane.setViewportView(table);
	}

	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	// 데이터를 이차배열로 받아온다.
	public Object[][] getData() {
		Object[][] datas = new Object[1][7]; // 이차배열 생성 1행 7열
		datas[0] = new Object[] { null, null, null, null, null, null, null };

		return datas;

	}

	public String[] getColumnNames() {
		return new String[] { "학생번호", "학생명", "국어", "영어", "수학", "총점", "평균" };
	}// end of getColumnNames

	//setList메소드 만들기(컬렉션 > 2차배열)
	// 데이터를 담은 List를 가져와서 배열에 담기
	public void setList(List<Student> stdList) {
		// 2차원배열생성
		Object[][] datas = new Object[stdList.size()][];
		// 2차원배열 담기
		for (int i = 0; i < datas.length; i++) {
			datas[i] = toArray(stdList.get(i)); // toArray 메소드 만들기
		}
		CustomTableModel model = new CustomTableModel(datas, getColumnNames());
		table.setModel(model);

		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);

		// 컬럼별 너비 조정
		setTableCellWidth(100, 150, 100, 100, 100, 150, 150);

		// 조건에 맞는 셀 색조절(총점이 200점 미만은 빨강)
		setTableCellCondition(0,1,2,3,4,5,6);	//조건에 맞는 행을 다 색칠...

	}// end of setList

	public void setTableCellCondition(int...idx) {
		ConditionTableCellRenderer ctcr = new ConditionTableCellRenderer();	//객체생성
		TableColumnModel tcm = table.getColumnModel();	//테이블에 있는 컬럼을 가져온다.
		//
		for(int i = 0; i < idx.length; i++) {	
			tcm.getColumn(idx[i]).setCellRenderer(ctcr);
		}
		
	}

	public void setTableCellWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel(); // 테이블에 있는 각 컬럼을 가져온다

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]); // 0 : 학생번호컬럼 너비 조정
		}

	}

	// 컬럼 정렬 메소드 : 상수(int)와 가변배열을 매개변수로 받는다.
	public void setTableCellAlign(int align, int... idx) {

		TableColumnModel tcm = table.getColumnModel(); // 각 컬럼을 가져온다

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align); // 선택된 컬럼을 가운데 정렬
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr); // 학생번호, 학생명 가운데 정렬
		}

	}

	private Object[] toArray(Student std) {
		// 1차원 배열 생성
		Object[] data = new Object[] { std.getStdNo(), std.getStdName(), std.getKor(), std.getEng(), std.getMath(),
				std.getTotal(), String.format("%.2f", std.getAvg()) }; // 소수점이하 두번째자리까지 출력

		return data;
	}

	// 테이블 수정 불가 설정을 위해 만든 클래스(이 안에서만 쓰기때문에 private으로 설정)
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
	
	// 조건에 따라 테이블의 셀 색깔을 변경하기 위해 만든 클래스(private)
	private class ConditionTableCellRenderer extends JLabel implements TableCellRenderer {
		//JLable을 상속받았기때문에 셀들이 레이블로 바뀐다.
		//TableCellRenderer인터페이스를 구현하기때문에 오버라이딩을 해준다.
		// 오버라이딩된 메소드는 조건이 맞는지 안맞는지 모두 순회한 뒤, 셀들을 레이블로 변경해준다.(레이블 상속)
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			//셀 > 레이블로 바뀌면서(레이블은 처음에 만들때 비어있으니까) 셀에 값이 있다면 가져오고, 없으면 공백처리
			//value 타입이 Object인건 뭐가 올지 모르기때문에
			setText(value == null ? "" : value.toString());
			setOpaque(true);	//배경색 보이게 설정
			// 테이블에 5번째 칼럼에 있는 값을 가져온다.(총점) > 총점이 200점이면 배경색을 빨강으로 아니면 흰색으로 설정
			int total = (int) table.getValueAt(row, 5);	//모든행의 총점을 가져온다.
			if (total < 200) {
				setBackground(Color.ORANGE);
			} else {
				setBackground(Color.WHITE);
			}
			setHorizontalAlignment(SwingConstants.RIGHT);	//5번째 칼럼을 오른쪽 정렬
			return this;
		}

	}

}
