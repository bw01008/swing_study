package swing_study.component;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// JButton클래스를 상속받아서 나의 버튼을 직접 만들기

@SuppressWarnings("serial")
public class MyButton extends JButton {
	
	private String imgPath = System.getProperty("user.dir") + File.separator + "img" + File.separator;

	public MyButton() {
		setIcon(new ImageIcon(imgPath + "button1.gif"));
		setRolloverIcon(new ImageIcon(imgPath + "button2.gif"));
		setPressedIcon(new ImageIcon(imgPath + "button3.gif"));
	}
	
}
