package swing_study.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;

public class ContentPaneEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ContentPaneEx() {
		initialize();
	}
	
	private void initialize() {
		setResizable(false);	//생성된 창 사이즈 조절 불가로 설정(true면 사이즈 조절 가능)
		setTitle("테스트");	//타이틀바 이름설정
		//창닫기 눌렀을때 반응에 대한 설정: 모든 창닫기, 해당 창만 닫기 등등
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//100,100은 모니터 상에 왼쪽으로부터 100픽셀, 위에서부터 100픽셀 위치에 450*300사이즈의 프레임을 띄워라
		setBounds(100, 400, 450, 300);
		//contentPane생성
		contentPane = new JPanel();	//contentPane 위에 패널 생성
		contentPane.setBackground(Color.ORANGE);	//contentPane배경색 설정
		contentPane.setForeground(Color.BLACK);		//contentPane폰트색상 설정
		contentPane.setBorder(new EmptyBorder(10, 20, 30, 40));	//contentPane 내부 여백 설정
		
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50)); //레이아웃 설정
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3);
	}

}
