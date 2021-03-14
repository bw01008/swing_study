package swing_study.component.Table;

import javax.swing.SwingConstants;

import swing_study.panel.Title;
// 추상 클래스 AbstractCustomTablePanel(패널)을 상속받은 TitleTablePanel (일반)클래스
@SuppressWarnings("serial")
public class TitleTablePanel extends AbstractCustomTablePanel<Title> {

	@Override
	protected void setAlignAndWidth() {

		// 컬럼 내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 250);

	}

	@Override
	public Object[] toArray(Title t) {
		return new Object[] { t.getTno(), t.getTname() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "직책번호", "직책명" };
	}

}
