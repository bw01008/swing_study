package swing_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing_study.component.FrameComponentEx;
import swing_study.component.LabelEx;
import swing_study.frame.ContentPaneEx;
import swing_study.frame.JPanelEx;
import swing_study.layout.FrameLayout;
import swing_study.layout.LayoutGubun;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.Color;

public class SwingMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn01;
	private JButton btn02;
	private JPanel pLayout;
	private JButton btnFlowLayout;
	private JButton btnBorderLayout;
	private JButton btnNGridLayout;
	private JButton btnAbsoluteLayout;
	private JButton btnNewButton;
	private JPanel pComponent1;
	private JButton btn04;
	private JButton btn05;
	private JButton btn06;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();	//jframe 생성
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
		setBounds(10, 10, 700, 450);	//화면왼쪽상단으로부터 100픽셀떨어진 위치에 450 *300 픽셀 크기의 프레임을 띄워준다.
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
		
		pLayout = new JPanel();
		pLayout.setBorder(new TitledBorder(null, "레이아웃", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLayout);
		pLayout.setLayout(new GridLayout(0, 1, 0, 10));
		
		btnFlowLayout = new JButton("플로우레이아웃");
		btnFlowLayout.addActionListener(this);
		//람다식
//		btnFlowLayout.addActionListener(e -> new FrameLayout(LayoutGubun.FLOW));
		//직접작성
//		btnFlowLayout.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				FrameLayout flow = new FrameLayout(LayoutGubun.FLOW);
//				flow.setVisible(true);
//				
//			}
//		});
//		
		
		pLayout.add(btnFlowLayout);
		
		btnBorderLayout = new JButton("보더레이아웃");
		btnBorderLayout.addActionListener(this);
		pLayout.add(btnBorderLayout);
		
		btnNGridLayout = new JButton("그리드레이아웃");
		btnNGridLayout.addActionListener(this);
		pLayout.add(btnNGridLayout);
		
		btnAbsoluteLayout = new JButton("절대레이아웃");
		btnAbsoluteLayout.addActionListener(this);
		pLayout.add(btnAbsoluteLayout);
		
		btnNewButton = new JButton("JComponent 공통속성");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		pComponent1 = new JPanel();
		pComponent1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JLabel & JButton & JToggleButton ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pComponent1);
		pComponent1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn04 = new JButton("JLabel");
		btn04.addActionListener(this);
		pComponent1.add(btn04);
		
		btn05 = new JButton("JButton");
		pComponent1.add(btn05);
		
		btn06 = new JButton("JToggle");
		pComponent1.add(btn06);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn04) {
			actionPerformedBtn04(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnAbsoluteLayout) {
			actionPerformedBtnAbsoluteLayout(e);
		}
		if (e.getSource() == btnNGridLayout) {
			actionPerformedBtnNGridLayout(e);
		}
		if (e.getSource() == btnBorderLayout) {
			actionPerformedBtnBorderLayout(e);
		}
		if (e.getSource() == btnFlowLayout) {
			actionPerformedBtnFlowLayout(e);
		}
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
	protected void actionPerformedBtnFlowLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.FLOW);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnBorderLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.BORDER);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnNGridLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.GRID);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnAbsoluteLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGubun.ABSOLUTE);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		FrameComponentEx frame = new FrameComponentEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn04(ActionEvent e) {
		LabelEx frame = new LabelEx();
		frame.setVisible(true);
	}
}
