package cn.web;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import cn.method.CommondMethods;

public class Access extends JFrame {
	CommondMethods methods = null;
	JPanel statusPanel = null;
	JPanel inforPanel = null;
	JButton start = null;
	JRadioButton btn1 = null;
	JRadioButton btn2 = null;
	JRadioButton btn3 = null;
	JRadioButton btn4 = null;
	JRadioButton btn5 = null;
	JRadioButton btn6 = null;
	JRadioButton btn7 = null;
	JRadioButton btn8 = null;
	JRadioButton btn9 = null;
	ButtonGroup group = null;
	JTextField webURL = null;
	int i = 1;
	int size = 0;
	String URLaddress = null;
	JTextArea statusArea = null;
	JPanel noticePanel = null;
	JTextArea noticeArea = null;
	Color panelColor = new Color(165,234,255);
	Color textColor = new Color(190,255,248);

	public Access() {
		methods = new CommondMethods();
		init();
		addPanel();
		addStatus();
		addInfor();
		addEvent();
		addNotice();
		setVisible(true);
	}

	/*
	 * 初始化
	 */
	public void init() {
		setTitle("网页访问器v1.0");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this.getOwner());
		setResizable(false);
	}

	/*
	 * 添加面板
	 */
	public void addPanel() {
		// 主面板
		JPanel mainPanel = methods.createPanel(600, 400, 0, 0);

		// 名称面板
		JPanel namePanel = methods.createPanel(10, 10, 575, 40);
		JLabel nameLabel = methods.createLabel("WordPress博客访问器", 180, 10, 300,
				20, "隶书", 24);
		nameLabel.setForeground(Color.red);
		namePanel.add(nameLabel);
		namePanel.setBackground(panelColor);
		mainPanel.add(namePanel);

		// 状态面板
		statusPanel = methods.createPanel(10, 60, 350, 300);
		statusPanel.setBackground(panelColor);
		mainPanel.add(statusPanel);

		// 信息面板
		inforPanel = methods.createPanel(370, 60, 214, 200);
		inforPanel.setBackground(panelColor);
		mainPanel.add(inforPanel);

		// 提示面板
		noticePanel = methods.createPanel(370, 270, 214, 90);
		noticePanel.setBackground(panelColor);
		mainPanel.add(noticePanel);
		this.add(mainPanel);
	}

	/*
	 * 状态面板
	 */
	public void addStatus() {
		statusArea = methods.createTextArea("", 5, 5, 340, 290, "宋体", 14,
				textColor);
		statusArea.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(statusArea);
		scroller.setBounds(5, 5, 340, 290);
		statusPanel.add(scroller);
	}

	/*
	 * 信息面板
	 */
	public void addInfor() {
		JLabel webLabel = methods.createLabel("网址:", 10, 10, 100, 20, "宋体", 14);
		inforPanel.add(webLabel);

		webURL = methods.createTextField("", 50, 10, 160, 20, "宋体", 14,
				textColor);
		inforPanel.add(webURL);

		JLabel numLabel = methods.createLabel("访问次数:", 10, 40, 100, 20, "宋体",
				14);
		inforPanel.add(numLabel);

		btn1 = methods.createRadioButton("10", true, 10, 60, 60, 20);
		btn1.setBackground(panelColor);
		inforPanel.add(btn1);
		btn2 = methods.createRadioButton("5千", false, 80, 60, 60, 20);
		inforPanel.add(btn2);
		btn2.setBackground(panelColor);
		btn3 = methods.createRadioButton("1万", false, 150, 60, 60, 20);
		inforPanel.add(btn3);
		btn3.setBackground(panelColor);
		btn4 = methods.createRadioButton("2万", false, 10, 90, 60, 20);
		inforPanel.add(btn4);
		btn4.setBackground(panelColor);
		btn5 = methods.createRadioButton("5万", false, 80, 90, 60, 20);
		inforPanel.add(btn5);
		btn5.setBackground(panelColor);
		btn6 = methods.createRadioButton("10万", false, 150, 90, 60, 20);
		inforPanel.add(btn6);
		btn6.setBackground(panelColor);
		btn7 = methods.createRadioButton("20万", false, 10, 120, 60, 20);
		inforPanel.add(btn7);
		btn7.setBackground(panelColor);
		btn8 = methods.createRadioButton("50万", false, 80, 120, 60, 20);
		inforPanel.add(btn8);
		btn8.setBackground(panelColor);
		btn9 = methods.createRadioButton("100万", false, 150, 120, 60, 20);
		inforPanel.add(btn9);
		btn9.setBackground(panelColor);

		// 实例化按钮组
		ButtonGroup group = new ButtonGroup();
		group.add(btn1);
		group.add(btn2);
		group.add(btn3);
		group.add(btn4);
		group.add(btn5);
		group.add(btn6);
		group.add(btn7);
		group.add(btn8);
		group.add(btn9);

		// 创建开始按钮
		start = methods.createButton("开始", 50, 160, 100, 20, "宋体", 14);
		inforPanel.add(start);

	}

	/*
	 * 提示面板
	 */
	public void addNotice() {
		noticeArea = new JTextArea();
		noticeArea.setBounds(5, 5, 205, 80);
		noticeArea.setBackground(textColor);
		noticeArea.setText("点击开始会出现程序卡死属于正常现象，耐心等待即可。");
		noticeArea.setLineWrap(true);
		noticePanel.add(noticeArea);
	}

	/*
	 * 按钮添加点击事件
	 */
	public void addEvent() {
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (btn1.isSelected()) {
					size = 10;
					access();
				} else if (btn2.isSelected()) {
					size = 5000;
					access();
				} else if (btn3.isSelected()) {
					size = 10000;
					access();
				} else if (btn4.isSelected()) {
					size = 20000;
					access();
				} else if (btn5.isSelected()) {
					size = 50000;
					access();
				} else if (btn6.isSelected()) {
					size = 100000;
					access();
				} else if (btn7.isSelected()) {
					size = 200000;
					access();
				} else if (btn8.isSelected()) {
					size = 500000;
					access();
				} else {
					size = 10000000;
					access();
				}

			}
		});
	}

	/*
	 * 公共调用访问
	 */
	public void access() {
		if ("".equals(webURL.getText().trim())) {
			JOptionPane.showMessageDialog(null, "地址不能为空");
		} else {
			URLaddress = webURL.getText().toString();
			URL url = null;
			try {
				url = new URL(URLaddress);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			statusArea.setText("");
			noticeArea.setText("正在刷新访问量，请耐心等待。。。");
			for (int i = 1; i <= size; i++) {
				// 到了这里就已经在访问url了
				HttpURLConnection conn = null;
				try {
					conn = (HttpURLConnection) url.openConnection();
					conn.connect();// 连接会话
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					InputStream is = conn.getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				statusArea.append(URLaddress + "  已被访问" + i + "次\n");
				statusArea
						.append("----------------------------------------------------------------\n");
			}
			noticeArea.setText("访问量已达成，请查看你的页面访问数量。");
			JOptionPane.showMessageDialog(null, size + "次已被访问完");
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Access();
	}

}
