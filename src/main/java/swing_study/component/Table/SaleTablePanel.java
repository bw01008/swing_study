package swing_study.component.Table;

import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SaleTablePanel extends AbstractCustomTablePanel<Sale> {

	@Override
	protected void setAlignAndWidth() {
		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3);
		setTableCellAlign(SwingConstants.RIGHT, 4, 5, 6);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250, 100, 100, 100, 100, 100);

	}

	@Override
	public Object[] toArray(Sale s) {
		return new Object[] { 
				s.getOrderNo(), 
				new SimpleDateFormat("YYYY-MM-dd").format(s.getDate()),
				s.getCsNo().getCsNo(), 
				s.getpCode().getpCode(),
				s.getSaleAmount(), 
				s.getSelling(), 
				s.getProfit() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "주문번호", "날짜", "고객번호", "제품코드", "주문수량", "판매액", "이익금액" };
	}

}
