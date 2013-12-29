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
 * ���ƣ�������Ӵ���
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
		setIconifiable(true);							// ���ô������С������������
		setClosable(true);								// ���ô���ɹرգ���������
		setTitle("������Ϣ�����Ϣ���");						// ���ô�����⣭��������
		setBounds(100, 100, 396, 260);					// ���ô���λ�úʹ�С����������

		final JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		final GridLayout gridLayout = new GridLayout(0, 4);
		gridLayout.setVgap(5);
		gridLayout.setHgap(5);
		panel.setLayout(gridLayout);
		getContentPane().add(panel);

		final JLabel label_2 = new JLabel();
		label_2.setText("�����ţ�");
		panel.add(label_2);

		ISBN = new JTextField("������13λ������",13);
		ISBN.setDocument(new MyDocument(13)); //���û�����ı����������ֵΪ13
		
		ISBN.setColumns(13);
		ISBN.addKeyListener(new ISBNkeyListener());
		ISBN.addFocusListener(new ISBNFocusListener());
		panel.add(ISBN);

		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("���");
		panel.add(label);

		goodsType = new JComboBox();
		goodsTypeModel= (DefaultComboBoxModel)goodsType.getModel();
		
		//�����ݿ���ȡ���������
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
		label_1.setText("��������");
		panel.add(label_1);

		goodsName = new JTextField();
		panel.add(goodsName);

		final JLabel label_3 = new JLabel();
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setText("�����̣�");
		panel.add(label_3);

		producer = new JTextField();
		producer.setDocument(new MyDocument(10));
		panel.add(producer);

		final JLabel label_2_1 = new JLabel();
		label_2_1.setText("�����̣�");
		panel.add(label_2_1);

		company = new JComboBox();
		String[]array=new String[]{"***������","**���޹�˾","**���͹�˾","***С�͹�˾"};
		company.setModel(new DefaultComboBoxModel(array));
		panel.add(company);

		final JLabel label_4 = new JLabel();
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setText("��¼Ա��");
		panel.add(label_4);

		salesman = new JTextField();
		salesman.setDocument(new MyDocument(10));
		panel.add(salesman);

		final JLabel label_1_1 = new JLabel();
		label_1_1.setText("�������ڣ�");
		panel.add(label_1_1);

		SimpleDateFormat myfmt=new SimpleDateFormat("yyyy-MM-dd");
		pubDate= new JFormattedTextField(myfmt.getDateInstance());
		pubDate.setValue(new java.util.Date());
		panel.add(pubDate);
		final JLabel label_3_1 = new JLabel();
		label_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_3_1.setText("���ۣ�");
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
		buttonadd.setText("���");
		panel_1.add(buttonadd);

		buttonclose = new JButton();
		buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("�ر�");
		panel_1.add(buttonclose);

		final JLabel label_5 = new JLabel();
		ImageIcon bookAddIcon=CreatecdIcon.add("newBookorderImg.jpg");
		label_5.setIcon(bookAddIcon);
		label_5.setPreferredSize(new Dimension(400, 80));
		label_5.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(label_5, BorderLayout.NORTH);
		label_5.setText("�»�����(LOGOͼƬ)");
		
		setVisible(true);											// ��ʾ����ɹرգ�����������������пؼ�֮��ִ�и����
	}
	class ISBNFocusListener extends FocusAdapter {
		public void focusLost(FocusEvent e){
			if(!Dao.selectGoodsInfo(ISBN.getText().trim()).isEmpty()){
				JOptionPane.showMessageDialog(null, "��ӻ������ظ���");
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
	class CloseActionListener implements ActionListener {			// ��ӹرհ�ť���¼�������
		public void actionPerformed(final ActionEvent e) {
			doDefaultCloseAction();
		}
	}
	class addBookActionListener implements ActionListener {		// ��Ӱ�ť�ĵ����¼�������
		public void actionPerformed(final ActionEvent e) {
			// ����ҵ��
			

			if(ISBN.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�������ı��򲻿���Ϊ��");
				return;
			}
			if(ISBN.getText().length()!=13){
				JOptionPane.showMessageDialog(null, "�������ı�������λ��Ϊ13λ");
				return;
			}
			if(goodsName.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�������������ı��򲻿���Ϊ��");
				return;
			}
			if(producer.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�������ı��򲻿���Ϊ��");
				return;
			}
			if(pubDate.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�������������ı��򲻿���Ϊ��");
				return;
			}
			if(price.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�����ı��򲻿���Ϊ��");
				return;
			}

			
			String ISBNs=ISBN.getText().trim();
			
			//����
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
			
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
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
