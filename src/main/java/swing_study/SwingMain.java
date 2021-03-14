package swing_study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing_study.JOptionPane.JFileChooserEx;
import swing_study.JOptionPane.JOptionPaneConfirmEx;
import swing_study.JOptionPane.JOptionPaneInputEx;
import swing_study.JOptionPane.JOptionPaneMessageEx;
import swing_study.Listener.AnonymousClassListener;
import swing_study.Listener.IndepClassListener;
import swing_study.Listener.InnerClassListener;
import swing_study.Listener.MouseAdaptorEx;
import swing_study.Listener.MouseListenerEx;
import swing_study.Menu.JMenuFrameEx;
import swing_study.Menu.JMenuPopupEx;
import swing_study.component.FrameComponentEx;
import swing_study.component.Fruit;
import swing_study.component.JButtonEx;
import swing_study.component.JCheckBoxCustomEx;
import swing_study.component.JCheckBoxEx;
import swing_study.component.JComboBoxEx01;
import swing_study.component.JComboBoxEx02;
import swing_study.component.JComboBoxEx03;
import swing_study.component.JLableEx1_size;
import swing_study.component.JListEx;
import swing_study.component.JListEx02;
import swing_study.component.JListEx03;
import swing_study.component.JRadioButtonEx;
import swing_study.component.JSliderEx;
import swing_study.component.JSpinnerEx;
import swing_study.component.JTabbedPaneEx;
import swing_study.component.JTableEx;
import swing_study.component.JTextFieldAreaEx;
import swing_study.component.LabelEx;
import swing_study.frame.ContentPaneEx;
import swing_study.frame.JPanelEx;
import swing_study.layout.FrameLayout;
import swing_study.layout.LayoutGubun;

@SuppressWarnings("serial")
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
	private JPanel pJCheckRadio;
	private JButton btn06;
	private JButton btn07;
	private JPanel pText;
	private JButton btn08;
	private JPanel pList;
	private JButton btn09;
	private JButton btn10;
	private JButton btn11;
	private JPanel pCombo;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JPanel pSliderSpinner;
	private JPanel pSlider;
	private JPanel pSpinner;
	private JButton btn15;
	private JButton btn16;
	private JPanel pTabbedPane;
	private JButton btn17;
	private JButton btn04_2;
	private JButton btn18;
	private JPanel panel;
	private JButton btn19;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private JButton btn23;
	private JPanel pMenu;
	private JButton btn24;
	private JButton btn25;
	private JPanel pJoptionPane;
	private JButton btn26;
	private JButton btn27;
	private JButton btn28;
	private JPanel pFileChooser;
	private JButton btn29;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain(); // jframe 생성
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
		initialize(); // 보이는 부분을 초기화(UI를 꾸미기 위한 메소드)
	}

	private void initialize() {
		setTitle("스윙 스터디"); // 타이틀바 이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창닫기 설정
		setBounds(10, 10, 809, 537); // 화면왼쪽상단으로부터 100픽셀떨어진 위치에 450 *300 픽셀 크기의 프레임을 띄워준다.
		contentPane = new JPanel(); // 프레임 안에 contentPane 생성
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // contentPane 안쪽여백 설정
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 5, 10, 10));// 행, 열, 수평gap, 수직gap

		btn01 = new JButton("Jframe 예"); // 버튼 생성
		btn01.addActionListener(this); // actionperformed를 생성해서 JFrame에서 해결하도록 작성
		contentPane.add(btn01); // contentPane위에 버튼추가

		btn02 = new JButton("Jpanel 예"); // 버튼 생성
		btn02.addActionListener(this);
		contentPane.add(btn02); // contentPane위에 버튼추가

		pLayout = new JPanel();
		pLayout.setBorder(new TitledBorder(null, "레이아웃", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLayout);
		pLayout.setLayout(new GridLayout(0, 1, 0, 10));

		btnFlowLayout = new JButton("플로우레이아웃");
		btnFlowLayout.addActionListener(this);
		// 람다식
//		btnFlowLayout.addActionListener(e -> new FrameLayout(LayoutGubun.FLOW));
		// 직접작성
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
		pComponent1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"JLabel & JButton & JToggleButton ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pComponent1);
		pComponent1.setLayout(new GridLayout(0, 1, 0, 0));

		btn04 = new JButton("JLabel");
		btn04.addActionListener(this);
		pComponent1.add(btn04);

		btn05 = new JButton("JButton");
		btn05.addActionListener(this);

		btn04_2 = new JButton("Lable_size");
		btn04_2.addActionListener(this);
		pComponent1.add(btn04_2);
		pComponent1.add(btn05);

		pJCheckRadio = new JPanel();
		pJCheckRadio.setBorder(
				new TitledBorder(null, "JCheckBox & JRadioButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJCheckRadio);

		btn06 = new JButton("JCheckBox");
		btn06.addActionListener(this);
		pJCheckRadio.setLayout(new GridLayout(0, 1, 0, 0));
		pJCheckRadio.add(btn06);

		btn07 = new JButton("JRadioButton");
		btn07.addActionListener(this);
		pJCheckRadio.add(btn07);

		pText = new JPanel();
		pText.setBorder(new TitledBorder(null, "텍스트 필드", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pText);

		btn08 = new JButton("TextField 관련예제");
		btn08.addActionListener(this);
		pText.add(btn08);

		pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pList);
		pList.setLayout(new GridLayout(0, 1, 0, 0));

		btn09 = new JButton("JList 예1");
		btn09.addActionListener(this);
		pList.add(btn09);

		btn10 = new JButton("JList 예2");
		btn10.addActionListener(this);
		pList.add(btn10);

		btn11 = new JButton("JList 예3");
		btn11.addActionListener(this);
		pList.add(btn11);

		pCombo = new JPanel();
		pCombo.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pCombo);
		pCombo.setLayout(new GridLayout(0, 1, 0, 0));

		btn12 = new JButton("JComboBox 예1");
		btn12.addActionListener(this);
		pCombo.add(btn12);

		btn13 = new JButton("JComboBox 예2");
		btn13.addActionListener(this);
		pCombo.add(btn13);

		btn14 = new JButton("JComboBox 예3");
		btn14.addActionListener(this);
//		btn14.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				System.out.println("mouseReleased");
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				JComboBoxEx03 frame = new JComboBoxEx03();
//				frame.setVisible(true);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				System.out.println("mouseExited");
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				System.out.println("mouseEntered");
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("mouseClicked");
//			}
//		});
		pCombo.add(btn14);

		pSliderSpinner = new JPanel();
		pSliderSpinner.setBorder(
				new TitledBorder(null, "Slider&Spinner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSliderSpinner);
		pSliderSpinner.setLayout(new GridLayout(0, 1, 0, 0));

		pSlider = new JPanel();
		pSlider.setBorder(new TitledBorder(null, "Silder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpinner.add(pSlider);
		pSlider.setLayout(new BorderLayout(0, 0));

		btn15 = new JButton(" JSlider 예");
		btn15.addActionListener(this);
		pSlider.add(btn15, BorderLayout.CENTER);

		pSpinner = new JPanel();
		pSpinner.setBorder(new TitledBorder(null, "Spinner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpinner.add(pSpinner);
		pSpinner.setLayout(new BorderLayout(0, 0));

		btn16 = new JButton("JSpinner 예");
		btn16.addActionListener(this);
		pSpinner.add(btn16, BorderLayout.CENTER);

		pTabbedPane = new JPanel();
		pTabbedPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JTabbedPane & JTable",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pTabbedPane);

		btn17 = new JButton("JTabbedPane");
		btn17.addActionListener(this); // > actionPerformed가 호출된다.
		pTabbedPane.setLayout(new GridLayout(0, 1, 0, 0));
		pTabbedPane.add(btn17);

		btn18 = new JButton("JTable");// 버튼 달기
		btn18.addActionListener(this); // 버튼에 이벤트가 발생하면 this > 여기에서(프레임에서()) 액션리스너를 구현하겠다(액션리스너 인터페이스 구현)
		pTabbedPane.add(btn18);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "이벤트 리스너", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn19 = new JButton("독립클래스");
		btn19.addActionListener(this);
		panel.add(btn19);
		
		btn20 = new JButton("내부클래스");
		btn20.addActionListener(this);
		panel.add(btn20);
		
		btn21 = new JButton("익명클래스");
		btn21.addActionListener(this);
		panel.add(btn21);
		
		btn22 = new JButton("마우스 리스너");
		btn22.addActionListener(this);
		panel.add(btn22);
		
		btn23 = new JButton("마우스 어댑터");
		btn23.addActionListener(this);
		panel.add(btn23);
		
		pMenu = new JPanel();
		pMenu.setBorder(new TitledBorder(null, "JMenu&JPopupMenu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pMenu);
		pMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn24 = new JButton("메뉴바");
		btn24.addActionListener(this);
		pMenu.add(btn24);
		
		btn25 = new JButton("팝업메뉴");
		btn25.addActionListener(this);
		pMenu.add(btn25);
		
		pJoptionPane = new JPanel();
		pJoptionPane.setBorder(new TitledBorder(null, "JOptionPane", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pJoptionPane);
		pJoptionPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn26 = new JButton("InputDlg");
		btn26.addActionListener(this);
		pJoptionPane.add(btn26);
		
		btn27 = new JButton("ConfirmDlg");
		btn27.addActionListener(this);
		pJoptionPane.add(btn27);
		
		btn28 = new JButton("MessageDlg");
		btn28.addActionListener(this);
		pJoptionPane.add(btn28);
		
		pFileChooser = new JPanel();
		pFileChooser.setBorder(new TitledBorder(null, "JFileChooser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pFileChooser);
		
		btn29 = new JButton("JFileChooser");
		btn29.addActionListener(this);
		pFileChooser.add(btn29);
	}

	protected void actionPerformedBtn17(ActionEvent e) {
		JTabbedPaneEx frame = new JTabbedPaneEx();
		frame.setVisible(true);
	}

	// 모든 액션핸들러 달았는건 여기서 해결
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn29) {
			actionPerformedBtn29(e);
		}
		if (e.getSource() == btn28) {
			actionPerformedBtn28(e);
		}
		if (e.getSource() == btn27) {
			actionPerformedBtn27(e);
		}
		if (e.getSource() == btn26) {
			actionPerformedBtn26(e);
		}
		if (e.getSource() == btn25) {
			actionPerformedBtn25(e);
		}
		if (e.getSource() == btn24) {
			actionPerformedBtn24(e);
		}
		if (e.getSource() == btn23) {
			actionPerformedBtn23(e);
		}
		if (e.getSource() == btn22) {
			actionPerformedBtn22(e);
		}
		if (e.getSource() == btn21) {
			actionPerformedBtn21(e);
		}
		if (e.getSource() == btn20) {
			actionPerformedBtn20(e);
		}
		if (e.getSource() == btn19) {
			actionPerformedBtn19(e);
		}
		if (e.getSource() == btn18) { // 이벤트가 18버튼에서 발생했다면 해당 메소드를 호출
			actionPerformedBtn18(e);
		}

		if (e.getSource() == btn04_2) {
			actionPerformedBtn04_2(e);
		}
		if (e.getSource() == btn17) {
			actionPerformedBtn17(e);
		}
		if (e.getSource() == btn16) {
			actionPerformedBtn16(e);
		}
		if (e.getSource() == btn15) {
			actionPerformedBtn15(e);
		}
		if (e.getSource() == btn14) {
			actionPerformedBtn14(e);
		}
		if (e.getSource() == btn13) {
			actionPerformedBtn13(e);
		}
		if (e.getSource() == btn12) {
			actionPerformedBtn12(e);
		}
		if (e.getSource() == btn11) {
			actionPerformedBtn11(e);
		}
		if (e.getSource() == btn10) {
			actionPerformedBtn10(e);
		}
		if (e.getSource() == btn09) {
			actionPerformedBtn09(e);
		}
		if (e.getSource() == btn08) {
			actionPerformedBtn08(e);
		}
		if (e.getSource() == btn07) {
			actionPerformedBtn07(e);
		}
		if (e.getSource() == btn06) {
			actionPerformedBtn06(e);
		}
		if (e.getSource() == btn05) {
			actionPerformedBtn05(e);
		}
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

	// 버튼을 눌렀을 때 Jframe 새창이 뜬다.
	protected void actionPerformedBtn01(ActionEvent e) {
		ContentPaneEx frame = new ContentPaneEx(); // 객체 생성
		frame.setVisible(true); // 새창을 보이게 띄운다(?)
	}

	protected void actionPerformedBtn02(ActionEvent e) {
		JPanelEx frame = new JPanelEx(); // 객체 생성
		frame.setVisible(true); // 새창을 보이게 띄운다(?)
	}

	// 플로우레이아웃 버튼을 눌렀을 때, 새로운 프레임이 생성된다. > 생성자
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

	protected void actionPerformedBtn05(ActionEvent e) {
		JButtonEx frame = new JButtonEx();
		frame.setVisible(true);
	}

	// Btn06을 눌렀을 때 창이 총 2개 뜬다.
	protected void actionPerformedBtn06(ActionEvent e) {
		JCheckBoxEx frame = new JCheckBoxEx();
		frame.setVisible(true);

		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("사과", 100));
		list.add(new Fruit("배", 500));
		list.add(new Fruit("체리", 2000));
		list.add(new Fruit("바나나", 3000));
		list.add(new Fruit("오렌지", 3000));
		list.add(new Fruit("땅콩", 3000));
		list.add(new Fruit("아보카도", 3000));

		JCheckBoxCustomEx frame1 = new JCheckBoxCustomEx(list);
		frame1.setVisible(true);
	}

	protected void actionPerformedBtn07(ActionEvent e) {
		JRadioButtonEx frame = new JRadioButtonEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn08(ActionEvent e) {
		JTextFieldAreaEx frame = new JTextFieldAreaEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn09(ActionEvent e) {
		JListEx frame = new JListEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn10(ActionEvent e) {
		JListEx02 frame = new JListEx02();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn11(ActionEvent e) {
		JListEx03 frame = new JListEx03();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn12(ActionEvent e) {
		JComboBoxEx01 frame = new JComboBoxEx01();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn13(ActionEvent e) {
		JComboBoxEx02 frame = new JComboBoxEx02();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn14(ActionEvent e) {
		JComboBoxEx03 frame = new JComboBoxEx03();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn15(ActionEvent e) {
		JSliderEx frame = new JSliderEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn16(ActionEvent e) {
		JSpinnerEx frame = new JSpinnerEx();
		frame.setVisible(true);
	}

//	protected void actionPerformedBtn17(ActionEvent e) {
//		JTabbedPaneEx frame = new JTabbedPaneEx();
//		frame.setVisible(true);
//	}
	protected void actionPerformedBtn04_2(ActionEvent e) {
		JLableEx1_size frame = new JLableEx1_size();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn18(ActionEvent e) {
		JTableEx frame = new JTableEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn19(ActionEvent e) {
		IndepClassListener frame = new IndepClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn20(ActionEvent e) {
		InnerClassListener frame = new InnerClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn21(ActionEvent e) {
		AnonymousClassListener frame = new AnonymousClassListener();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn22(ActionEvent e) {
		MouseListenerEx frame = new MouseListenerEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn23(ActionEvent e) {
		MouseAdaptorEx frame = new MouseAdaptorEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn24(ActionEvent e) {
		JMenuFrameEx frame = new JMenuFrameEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn25(ActionEvent e) {
		JMenuPopupEx frame = new JMenuPopupEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn26(ActionEvent e) {
		JOptionPaneInputEx frame = new JOptionPaneInputEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn27(ActionEvent e) {
		JOptionPaneConfirmEx frame = new JOptionPaneConfirmEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn28(ActionEvent e) {
		JOptionPaneMessageEx frame = new JOptionPaneMessageEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn29(ActionEvent e) {
		JFileChooserEx frame = new JFileChooserEx();
		frame.setVisible(true);
	}
}
