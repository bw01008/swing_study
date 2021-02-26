package swing_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.frame.ContentPaneEx;
import swing_study.frame.JPanelEx;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SwingMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn01;
	private JButton btn02;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingMain() {
		initialize();
	}
	
	private void initialize() {
		setTitle("스윙 스터디");	//타이틀바 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//창닫기 설정
		setBounds(100, 100, 450, 300);	//화면왼쪽상단으로부터 100픽셀떨어진 위치에 450 *300 픽셀 크기의 프레임을 띄워준다.
		contentPane = new JPanel();		//프레임 안에 contentPane 생성
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	//contentPane 안쪽여백 설정
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));//행, 열, 수평갭, 수직갭
		
		btn01 = new JButton("Jframe 예");	//버튼 생성
		btn01.addActionListener(this);	//actionperformed를 JFrame에서 해결하도록 작성
		contentPane.add(btn01);	//contentPane위에 버튼추가
		
		btn02 = new JButton("Jpanel 예");	//버튼 생성
		btn02.addActionListener(this);	
		contentPane.add(btn02);	//contentPane위에 버튼추가
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn02) {
			actionPerformedBtn02(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	
	//버튼을 눌렀을 때 Jframe 새창이 뜬다.
	protected void actionPerformedBtn01(ActionEvent e) {
		ContentPaneEx frame = new ContentPaneEx();	// 객체 생성
		frame.setVisible(true);	// 새창을 보이게 띄운다(?)
	}
	protected void actionPerformedBtn02(ActionEvent e) {
		JPanelEx frame = new JPanelEx();	//객체 생성
		frame.setVisible(true); // 새창을 보이게 띄운다(?)
	}
}
