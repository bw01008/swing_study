package swing_study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class LabelEx extends JFrame implements MouseListener {

	private JPanel contentPane;
	//이미지 절대경로 설정시 다른 컴퓨터에서 작동하지 않는 문제가 있어서 path설정을 따로 해줘야 한다. 완전 중요!!(swing_study프로젝트까지 접근 후 이미지가 들어있는 폴더명을 seperator로 감싸준다)
	private String path = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	private JLabel lblNorth;
	private JLabel lblCenter;
	private JLabel lblSouth;

	public LabelEx() {
		System.out.println(path);	//콘솔창에 찍어보기용
		initialize();
	}
	private void initialize() {
		setTitle("JLabel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblNorth = new JLabel("사랑합니다.");
		lblNorth.addMouseListener(this);
		lblNorth.setFont(new Font("굴림", Font.BOLD, 50));
		lblNorth.setOpaque(true);
		lblNorth.setBackground(Color.PINK);
		lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNorth, BorderLayout.NORTH);
		
		lblCenter = new JLabel("");
		lblCenter.setIcon(new ImageIcon(path + "KakaoTalk_20210224_153435197.jpg"));	//절대경로에서 path + 이미지명으로 변경해준다
		lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCenter, BorderLayout.CENTER);
		
		lblSouth = new JLabel("강동강동하고 울어따");
		lblSouth.setOpaque(true);
		lblSouth.setBackground(Color.PINK);
		lblSouth.setIcon(new ImageIcon(path + "common.jpg"));
		lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSouth, BorderLayout.SOUTH);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNorth) {
			mouseClickedLblNorth(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void mouseClickedLblNorth(MouseEvent e) {	// NorthLabel 클릭할때 발생
		lblCenter.setIcon(new ImageIcon(path + "common.jpg"));	// 이미지 변경
		lblSouth.setText("010-1234-1234");	//텍스트 변경
		JOptionPane.showMessageDialog(null, "변경완료");	//메시지창 팝업
	}
}
