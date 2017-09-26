package cn.method;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;



public class CommondMethods {
	// 创建面板方法
	public JPanel createPanel(int x, int y, int width, int height) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		Color color = new Color(237, 242, 248);
		jPanel.setBackground(color);
		jPanel.setBounds(x, y, width, height);
		jPanel.setBorder(BorderFactory.createEtchedBorder());
		return jPanel;
	}

	// 创建标签方法
	public JLabel createLabel(String name, int x, int y, int width, int height, String fontName, int fontSize) {
		JLabel jLabel = new JLabel(name);
		jLabel.setBounds(x, y, width, height);
		jLabel.setFont(new Font(fontName, Font.PLAIN, fontSize));
		return jLabel;
	}

	//创建单选框按钮
	public JRadioButton createRadioButton(String name,boolean selected,int x, int y, int width, int height){
		JRadioButton jRadioButton = new JRadioButton(name,selected);
		jRadioButton.setBounds(x, y, width, height);
		return jRadioButton;
	}
	// 创建按钮方法
	public JButton createButton(String name, int x, int y, int width, int height, String fontName, int fontSize) {
		JButton jButton = new JButton(name);
		jButton.setBounds(x, y, width, height);
		Color color = new Color(129, 194, 214);
		jButton.setBackground(color);
		return jButton;
	}

	// 创建文本框方法
	public JTextField createTextField(String text, int x, int y, int width, int height, String fontName, int fontSize,
			Color color) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, width, height);
		jTextField.setText(text);
		jTextField.setFont(new Font(text, Font.PLAIN, fontSize));
		jTextField.setBackground(color);
		return jTextField;
	}
	//创建文本域方法
	public JTextArea createTextArea(String text, int x, int y, int width, int height, String fontName, int fontSize,
			Color color) {
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(x, y, width, height);
		jTextArea.setText(text);
		jTextArea.setFont(new Font(text, Font.PLAIN, fontSize));
		jTextArea.setBackground(color);
		return jTextArea;
	}

	// 创建图片按钮
	public JButton createImagesButton(String path, int logoWidth, int logoHeight, int x, int y, int width, int height) {
		ImageIcon logoIcon = new ImageIcon(path);
		Image logoImage = logoIcon.getImage();
		logoImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_DEFAULT);
		logoIcon.setImage(logoImage);
		JButton jButton = new JButton();
		jButton.setIcon(logoIcon);
		jButton.setBounds(x, y, width, height);
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		jButton.setBorder(emptyBorder);
		Color color = new Color(129, 194, 214);
		jButton.setBackground(color);
		return jButton;
	}

	// 创建密码输入框方法
	public JPasswordField createPasswordField(int x, int y, int width, int height, Color color) {
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setBounds(x, y, width, height);
		jPasswordField.setBackground(color);
		return jPasswordField;
	}

	// 创建下拉列表框
	public JComboBox createJComboBox(int x, int y, int width, int height, String fontName, int fontSize) {
		JComboBox jComboBox = new JComboBox();
		jComboBox.setBounds(x, y, width, height);
		jComboBox.setFont(new Font(fontName, Font.PLAIN, fontSize));
		return jComboBox;
	}

	/**
	 * 设置表格的所有行的行高
	 * 
	 * @param table
	 * @param height
	 */
	public void setTableAllRowHeight(JTable table, int height) {
		table.setRowHeight(height);
	}

	/**
	 * 设置表格的某一行的行高
	 * 
	 * @param table
	 * @param row
	 * @param height
	 */
	public void setTableOneRowHeight(JTable table, int row, int height) {
		table.setRowHeight(row, height);
	}

	/**
	 * 简单封装一下方法
	 * 
	 * @param table
	 *            表格
	 * @param color
	 *            颜色列表
	 */
	public static void setColor(JTable table,  final Color[] color) {
		try {
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
				// 重写getTableCellRendererComponent 方法
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					// 这里是你需要看需求修改的部分
					setBackground(color[row]);
					setForeground(Color.black);
					return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				}
			};
			// 对每行的每一个单元格
			int columnCount = table.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(dtcr);
			}
			table.setSelectionBackground(new Color(195,190,212));
			table.getTableHeader().setBackground(new Color(82,195,221));
			table.setRowHeight(25);
			table.setFont(new Font("宋体",Font.PLAIN,14));
			table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(),30));;
			table.getTableHeader().setFont(new Font("宋体",Font.PLAIN,14));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
