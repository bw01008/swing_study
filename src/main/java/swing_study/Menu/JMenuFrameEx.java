package swing_study.Menu;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JMenuFrameEx extends JFrame implements ActionListener {
	String path = System.getProperty("user.dir") + File.separator + "img" + File.separator;
	private JLabel lblImg = new JLabel();
	private JPanel contentPane;
	private JMenuItem mntmLoad;
	private JMenuItem mntmHide;
	private JMenuItem mntmReShow;
	private JMenuItem mntmExit;

	public JMenuFrameEx() {
		initialize();

	}

	private void initialize() {
		setTitle("메뉴 팝업");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnScreen = new JMenu("Screen");
		menuBar.add(mnScreen);

		mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(this);
		mnScreen.add(mntmLoad);

		JSeparator separator = new JSeparator();
		mnScreen.add(separator);

		mntmHide = new JMenuItem("Hide");
		mntmHide.addActionListener(this);
		mnScreen.add(mntmHide);

		JSeparator separator_1 = new JSeparator();
		mnScreen.add(separator_1);

		mntmReShow = new JMenuItem("ReShow");
		mntmReShow.addActionListener(this);
		mnScreen.add(mntmReShow);

		JSeparator separator_2 = new JSeparator();
		mnScreen.add(separator_2);

		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(this);
		mnScreen.add(mntmExit);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(lblImg, BorderLayout.CENTER);

	}// end of initialize

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmExit) {
			actionPerformedMntmExit(e);
		}
		if (e.getSource() == mntmReShow) {
			actionPerformedMntmReShow(e);
		}
		if (e.getSource() == mntmHide) {
			actionPerformedMntmHide(e);
		}
		if (e.getSource() == mntmLoad) {
			actionPerformedMntmLoad(e);
		}
	}

	protected void actionPerformedMntmLoad(ActionEvent e) {
		if (lblImg.getIcon() != null) {
			return;
		} else {
			ImageIcon icon = new ImageIcon(path + "flower.jpg");
			Image changeImg = icon.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(),
					Image.SCALE_SMOOTH);
			lblImg.setIcon(new ImageIcon(changeImg));
		}
	}

	protected void actionPerformedMntmHide(ActionEvent e) {
		if(lblImg.getIcon() == null) {
			return;
		}else {
			lblImg.setVisible(false);
		}
	}

	protected void actionPerformedMntmReShow(ActionEvent e) {
		if(lblImg.getIcon() == null) {
			return;
		}else {
			lblImg.setVisible(true);
		}
	}

	protected void actionPerformedMntmExit(ActionEvent e) {
		System.exit(0);
	}
}
