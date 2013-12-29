package com.wsy.iframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import com.wsy.JComPz.Item;
import com.wsy.dao.Dao;
import com.wsy.model.GoodsType;
import com.wsy.util.MyDocument;
import com.wsy.util.CreatecdIcon;
/**
 * 名称：货物添加窗体
 * 
 */
public class GoodsAddIFrame extends JInternalFrame {
	private JComboBox company;
	private JTextField   price;
	private JFormattedTextField pubDate;
	private JTextField salesman;
	private JTextField producer;
	private JTextField ISBN;
	private JTextField goodsName;
	private JComboBox goodsType;
	private JButton buttonadd;
	private JButton buttonclose;
	DefaultComboBoxModel goodsTypeModel;
	
	Map map=new HashMap();
	public GoodsAddIFrame() {
		super();
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setIconifiable(true);							// 设置窗体可最小化－－－必须
		setClosable(true);								// 设置窗体可关闭－－－必须
		setTitle("货物信息添加信息添加");						// 设置窗体标题－－－必须
		setBounds(100, 100, 396, 260);					// 设置窗体位置和大小－－－必须

		final JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(5);
		gridLayout.setHgap(5);
		panel.setLayout(gridLayout);
		getContentPane().add(panel);

		final JLabel label_2 = new JLabel();
		label_2.setText("货物编号：");
		panel.add(label_2);

		ISBN = new JTextField("请输入13位货物编号",13);
		ISBN.setDocument(new MyDocument(13)); //设置货物号文本框最大输入值为13
		
		ISBN.setColumns(13);
		ISBN.addKeyListener(new ISBNkeyListener());
		ISBN.addFocusListener(new ISBNFocusListener());
		panel.add(ISBN);

		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("类别：");
		panel.add(label);

		goodsType = new JComboBox();
		goodsTypeModel= (DefaultComboBoxModel)goodsType.getModel();
		
		//从数据库中取出货物类别
		List list=Dao.selectGoodsCategory();
		for(int i=0;i<list.size();i++){
			GoodsType booktype=(GoodsType)list.get(i);
			Item item=new Item();
			item.setId((String)booktype.getId());
			item.setName((String)booktype.getTypeName());
			goodsTypeModel.addElement(item);
		}
		panel.add(goodsType);

		final JLabel label_1 = new JLabel();
		label_1.setText("货物名：");
		panel.add(label_1);

		goodsName = new JTextField();
		panel.add(goodsName);

		final JLabel label_3 = new JLabel();
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setText("生产商：");
		panel.add(label_3);

		producer = new JTextField();
		producer.setDocument(new MyDocument(10));
		panel.add(producer);

		final JLabel label_2_1 = new JLabel();
		label_2_1.setText("生产商：");
		panel.add(label_2_1);

		company = new JComboBox();
		String[]array=new String[]{"***生产商","**有限公司","**大型公司","***小型公司"};
		company.setModel(new DefaultComboBoxModel(array));
		panel.add(company);

		final JLabel label_4 = new JLabel();
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setText("记录员：");
		panel.add(label_4);

		salesman = new JTextField();
		salesman.setDocument(new MyDocument(10));
		panel.add(salesman);

		final JLabel label_1_1 = new JLabel();
		label_1_1.setText("生产日期：");
		panel.add(label_1_1);

		SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd");
		pubDate= new JFormattedTextField(myfmt.getDateInstance());
		pubDate.setValue(new java.util.Date());
		panel.add(pubDate);
		final JLabel label_3_1 = new JLabel();
		label_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_3_1.setText("单价：");
		panel.add(label_3_1);
		  price=   new   JTextField();
		  price.setDocument(new MyDocument(5));
		  price.addKeyListener(new NumberListener());
		panel.add(price);

		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setLayout(flowLayout);

		buttonadd= new JButton();
		buttonadd.addActionListener(new addBookActionListener());
		buttonadd.setText("添加");
		panel_1.add(buttonadd);

		buttonclose = new JButton();
		buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("关闭");
		panel_1.add(buttonclose);

		final JLabel label_5 = new JLabel();
		ImageIcon bookAddIcon=CreatecdIcon.add("newBookorderImg.jpg");
		label_5.setIcon(bookAddIcon);
		label_5.setPreferredSize(new Dimension(400, 80));
		label_5.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(label_5, BorderLayout.NORTH);
		label_5.setText("新货定购(LOGO图片)");
		
		setVisible(true);											// 显示窗体可关闭－－－必须在添加所有控件之后执行该语句
	}
	class ISBNFocusListener extends FocusAdapter {
		public void focusLost(FocusEvent e){
			if(!Dao.selectGoodsInfo(ISBN.getText().trim()).isEmpty()){
				JOptionPane.showMessageDialog(null, "添加货物编号重复！");
				return;
			}
		}
	}
	class ISBNkeyListener extends KeyAdapter {
		public void keyPressed(final KeyEvent e) {
			if (e.getKeyCode() == 13){
				buttonadd.doClick();
			}
		
		}
	}
	class CloseActionListener implements ActionListener {			// 添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
	class addBookActionListener implements ActionListener {		// 添加按钮的单击事件监听器
		public void actionPerformed(final ActionEvent e) {
			// 订货业务
			

			if(ISBN.getText().length()==0){
				JOptionPane.showMessageDialog(null, "货物编号文本框不可以为空");
				return;
			}
			if(ISBN.getText().length()!=13){
				JOptionPane.showMessageDialog(null, "货物编号文本框输入位数为13位");
				return;
			}
			if(goodsName.getText().length()==0){
				JOptionPane.showMessageDialog(null, "货物名称名称文本框不可以为空");
				return;
			}
			if(producer.getText().length()==0){
				JOptionPane.showMessageDialog(null, "生产商文本框不可以为空");
				return;
			}
			if(pubDate.getText().length()==0){
				JOptionPane.showMessageDialog(null, "生产日期日期文本框不可以为空");
				return;
			}
			if(price.getText().length()==0){
				JOptionPane.showMessageDialog(null, "单价文本框不可以为空");
				return;
			}

			
			String ISBNs=ISBN.getText().trim();
			
			//分类
			Object selectedItem = goodsType.getSelectedItem();
			if (selectedItem == null)
				return;
			Item item = (Item) selectedItem;
			String bookTypes=item.getId();
			
			String translators=salesman.getText().trim();
			String bookNames=goodsName.getText().trim();
			String writers=producer.getText().trim();
			String publishers=(String)company.getSelectedItem();
			String pubDates=pubDate.getText().trim();
			String prices=price.getText().trim();
			int i=Dao.Insertgoods(ISBNs,bookTypes, bookNames, writers, translators, publishers, java.sql.Date.valueOf(pubDates),Double.parseDouble(prices));
				
			if(i==1){
			
				JOptionPane.showMessageDialog(null, "添加成功");
				doDefaultCloseAction();
			}
		}
	}
	class NumberListener extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			String numStr="0123456789."+(char)8;
			if(numStr.indexOf(e.getKeyChar())<0){
				e.consume();
			}
		}
	}

}
