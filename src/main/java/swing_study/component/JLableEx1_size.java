package swing_study.component;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//이미지 잘리는 현상 해결하기
@SuppressWarnings("serial")
public class JLableEx1_size extends JFrame {

	private JPanel contentPane;
	String path = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	ImageIcon icon = new ImageIcon(path + "flower.jpg");	//ImageIcon 생성

	public JLableEx1_size() {
		initialize();
	}
	private void initialize() {
		setTitle("이미지 불러오기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 1000);	//500 - 1000으로 변경
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JLabel lblImg1 = new JLabel(icon);
		contentPane.add(lblImg1);
		
		//레이블의 사이즈에 맞춰 이미지 변경
		Image img = icon.getImage();	//이미지 가져오기
		Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);	//사이즈 설정
		ImageIcon changeIcon = new ImageIcon(changeImg);	//설정된 이미지를 다시 ImageIcon으로 생성
		
		JLabel lblImg2 = new JLabel(changeIcon);
		contentPane.add(lblImg2);
	}

}
