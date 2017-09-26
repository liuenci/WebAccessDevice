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
	// ������巽��
	public JPanel createPanel(int x, int y, int width, int height) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		Color color = new Color(237, 242, 248);
		jPanel.setBackground(color);
		jPanel.setBounds(x, y, width, height);
		jPanel.setBorder(BorderFactory.createEtchedBorder());
		return jPanel;
	}

	// ������ǩ����
	public JLabel createLabel(String name, int x, int y, int width, int height, String fontName, int fontSize) {
		JLabel jLabel = new JLabel(name);
		jLabel.setBounds(x, y, width, height);
		jLabel.setFont(new Font(fontName, Font.PLAIN, fontSize));
		return jLabel;
	}

	//������ѡ��ť
	public JRadioButton createRadioButton(String name,boolean selected,int x, int y, int width, int height){
		JRadioButton jRadioButton = new JRadioButton(name,selected);
		jRadioButton.setBounds(x, y, width, height);
		return jRadioButton;
	}
	// ������ť����
	public JButton createButton(String name, int x, int y, int width, int height, String fontName, int fontSize) {
		JButton jButton = new JButton(name);
		jButton.setBounds(x, y, width, height);
		Color color = new Color(129, 194, 214);
		jButton.setBackground(color);
		return jButton;
	}

	// �����ı��򷽷�
	public JTextField createTextField(String text, int x, int y, int width, int height, String fontName, int fontSize,
			Color color) {
		JTextField jTextField = new JTextField();
		jTextField.setBounds(x, y, width, height);
		jTextField.setText(text);
		jTextField.setFont(new Font(text, Font.PLAIN, fontSize));
		jTextField.setBackground(color);
		return jTextField;
	}
	//�����ı��򷽷�
	public JTextArea createTextArea(String text, int x, int y, int width, int height, String fontName, int fontSize,
			Color color) {
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(x, y, width, height);
		jTextArea.setText(text);
		jTextArea.setFont(new Font(text, Font.PLAIN, fontSize));
		jTextArea.setBackground(color);
		return jTextArea;
	}

	// ����ͼƬ��ť
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

	// ������������򷽷�
	public JPasswordField createPasswordField(int x, int y, int width, int height, Color color) {
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setBounds(x, y, width, height);
		jPasswordField.setBackground(color);
		return jPasswordField;
	}

	// ���������б��
	public JComboBox createJComboBox(int x, int y, int width, int height, String fontName, int fontSize) {
		JComboBox jComboBox = new JComboBox();
		jComboBox.setBounds(x, y, width, height);
		jComboBox.setFont(new Font(fontName, Font.PLAIN, fontSize));
		return jComboBox;
	}

	/**
	 * ���ñ��������е��и�
	 * 
	 * @param table
	 * @param height
	 */
	public void setTableAllRowHeight(JTable table, int height) {
		table.setRowHeight(height);
	}

	/**
	 * ���ñ���ĳһ�е��и�
	 * 
	 * @param table
	 * @param row
	 * @param height
	 */
	public void setTableOneRowHeight(JTable table, int row, int height) {
		table.setRowHeight(row, height);
	}

	/**
	 * �򵥷�װһ�·���
	 * 
	 * @param table
	 *            ���
	 * @param color
	 *            ��ɫ�б�
	 */
	public static void setColor(JTable table,  final Color[] color) {
		try {
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() {
				// ��дgetTableCellRendererComponent ����
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					// ����������Ҫ�������޸ĵĲ���
					setBackground(color[row]);
					setForeground(Color.black);
					return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				}
			};
			// ��ÿ�е�ÿһ����Ԫ��
			int columnCount = table.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				table.getColumn(table.getColumnName(i)).setCellRenderer(dtcr);
			}
			table.setSelectionBackground(new Color(195,190,212));
			table.getTableHeader().setBackground(new Color(82,195,221));
			table.setRowHeight(25);
			table.setFont(new Font("����",Font.PLAIN,14));
			table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(),30));;
			table.getTableHeader().setFont(new Font("����",Font.PLAIN,14));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
