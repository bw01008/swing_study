package swing_study.component;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class CustomRadioButton extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup(); // 버튼 그룹 객체 생성(배타성)
	private JRadioButton rdbtnApple; // 버튼 생성
	private JRadioButton rdbtnPear; // 버튼 생성
	private JRadioButton rdbtnCherry; // 버튼 생성
	private ArrayList<JRadioButton> rdBtns; // 리스트 선언

	public CustomRadioButton() {
		rdBtns = new ArrayList<JRadioButton>(); // 리스트 생성
		initialize();

		rdBtns.add(rdbtnApple);
		rdBtns.add(rdbtnPear);
		rdBtns.add(rdbtnCherry);
	}

	private void initialize() {

		rdbtnApple = new JRadioButton("사과");// 라디오 버튼 생성
		buttonGroup.add(rdbtnApple); // 그룹에 버튼 추가()
		add(rdbtnApple);// 패널에 버튼 추가

		rdbtnPear = new JRadioButton("배");
		buttonGroup.add(rdbtnPear);
		add(rdbtnPear);

		rdbtnCherry = new JRadioButton("체리");
		buttonGroup.add(rdbtnCherry);
		add(rdbtnCherry);

	}

	// getter메소드로 필드에 접근할 수 있다.
	public JRadioButton getRdbtnApple() {
		return rdbtnApple;
	}

	public JRadioButton getRdbtnPear() {
		return rdbtnPear;
	}

	public JRadioButton getRdbtnCherry() {
		return rdbtnCherry;
	}

	public ArrayList<JRadioButton> getRdBtns() {
		return rdBtns;
	}

}
