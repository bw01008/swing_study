package swing_study.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class JFileChooserEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblImg;
	private JButton btnOpen;
	private JFileChooser chooserPath = new JFileChooser(System.getProperty("user.dir"));

	public JFileChooserEx() {
		initialize();
	}

	private void initialize() {
		setTitle("파일");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblImg = new JLabel("");
		contentPane.add(lblImg, BorderLayout.CENTER);

		btnOpen = new JButton("불러오기");
		btnOpen.addActionListener(this);
		contentPane.add(btnOpen, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			if (e.getActionCommand().equals("불러오기")) {
				actionPerformedBtnOpen(e);
			} else {//저장하기를 눌렀을때
				actionPerformedBtnSave(e);
			}

		}
	}
	
	//저장
	private void actionPerformedBtnSave(ActionEvent e) {
		// download 폴더에 저장되도록 하세요. 
		//만약 download폴더가 존재하지 않으면 생성 후 저장되도록 하세요.
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG &GIF images", "jpg", "png", "gif");
		chooserPath.setFileFilter(filter);
		
		//String saveName = 
		int res = chooserPath.showSaveDialog(null);
		
	
		
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(
					null, 
					"파일이 저장되지 않았습니다.", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
//		else {
//			File file = new File(chooserPath.getSelectedFile().getName());
//			try (FileInputStream fis = new FileInputStream(chooserPath + "icon01.png");
//					FileOutputStream fos = new FileOutputStream(chooserPath + "icon10.png")){
//				
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			}
//		}
		
	}
	//열기
	protected void actionPerformedBtnOpen(ActionEvent e) {
		//파일 필터 객체 생성 > 보이는 파일의 유형을 결정한다.
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & PNG &GIF images", // 설명
				"jpg", "png", "gif"); // 확장자
		
		chooserPath.setFileFilter(filter);
		
		//열기 다이얼로그 출력
		int res = chooserPath.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(
					null, 
					"파일을 선택하지 않았습니다.", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String chooseFilePath = chooserPath.getSelectedFile().getPath();
		lblImg.setIcon(new ImageIcon(chooseFilePath));

		if (btnOpen.getText().equals("불러오기")) {
			btnOpen.setText("저장하기");

		}
	}
}
