package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class JSliderEx extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider sliderRed;
	private JSlider sliderBlue;
	private JSlider sliderGreen;
	private JLabel lblColor;

	public JSliderEx() {
		initialize();
		//Listener는 초기화 다음에 넣어줘야 작동시에 오류 발생이 적다
		sliderRed.addChangeListener(this);
		sliderGreen.addChangeListener(this);
		sliderBlue.addChangeListener(this);
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 10, 0, 10));
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));

		sliderRed = new JSlider();

		sliderRed.setForeground(Color.RED);
		sliderRed.setMaximum(255);	//최댓값설정
		sliderRed.setMajorTickSpacing(50);	// 50단위로 큰Tick 표시
		sliderRed.setMinorTickSpacing(10);	// 10단위로 작은 Tick 표시
		sliderRed.setPaintTicks(true);	//Tick들 보이게 설정
		sliderRed.setPaintLabels(true);	// 레이블 보이게 설정
		sliderRed.setValue(128);	// 처음 세팅값 설정(처음 슬라이더 손잡이가 있는곳)
		pCenter.add(sliderRed);

		sliderGreen = new JSlider();

		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setMinorTickSpacing(10);
		sliderGreen.setMaximum(255);
		sliderGreen.setMajorTickSpacing(50);
		sliderGreen.setForeground(Color.GREEN);
		sliderGreen.setValue(128);
		pCenter.add(sliderGreen);

		sliderBlue = new JSlider();

		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMinorTickSpacing(10);
		sliderBlue.setMaximum(255);
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setForeground(Color.BLUE);
		sliderBlue.setValue(128);
		pCenter.add(sliderBlue);

		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);

		lblColor = new JLabel("RGB");
		lblColor.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 30));
		lblColor.setForeground(Color.LIGHT_GRAY);
		lblColor.setOpaque(true);
		pSouth.add(lblColor);
	}
	//슬라이더를 움직였을 때
	public void stateChanged(ChangeEvent arg0) {
		int red = 0;
		int green = 0;
		int blue = 0;
		green = sliderGreen.getValue();
		blue = sliderBlue.getValue();
		red = sliderRed.getValue();
		
		String msg = String.format("Red(%d) Green(%d), Blue(%d)", red, green, blue);
		lblColor.setText(msg);
		lblColor.setBackground(new Color(red, green, blue));
	}

}
