/*
 * DatabaseUtil.java
 *
 * Created on __DATE__, __TIME__
 */

package com.xiaozheng.generate.ui;




import com.xiaozheng.generate.entily.db.DataBase;
import com.xiaozheng.generate.utils.DataBaseUtils;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * 黑马程序员代码生成器  V2.4
 *
 * @author 传智播客研究院 刘皇叔
 *
 */
public class DataBaseUi extends JFrame {

	/** Creates new form DatabaseUtil */
	public DataBaseUi() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new JLabel();
		jComboBox1 = new JComboBox();
		jLabel2 = new JLabel();
		jTextField1 = new JTextField();
		jLabel3 = new JLabel();
		jTextField2 = new JTextField();
		jLabel4 = new JLabel();
		jComboBox2 = new JComboBox();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jTextField3 = new JTextField();
		jLabel5 = new JLabel();

		//setTitle("\u4f20\u667a\u5218\u5907\u4ee3\u7801\u751f\u6210\u56682.3");
		setTitle("代码生成器v1.0");
		setBackground(new java.awt.Color(204, 255, 204));
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}

			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}

			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		jLabel1.setText("\u9009\u62e9\u6570\u636e\u5e93\u7c7b\u578b");

		jComboBox1.setModel(new DefaultComboBoxModel(
				new String[] { "--请选择--" }));

		jLabel2.setText("\u7528\u6237\u540d");

		jLabel3.setText("\u5bc6\u7801");

		jLabel4.setText("\u6570\u636e\u5e93");

		jComboBox2.setModel(new DefaultComboBoxModel(
				new String[] { "--请选择数据库--" }));

		jButton1.setText("\u6d4b\u8bd5\u8fde\u63a5");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setLabel("\u8df3\u8fc7");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jTextField3.setText("127.0.0.1");

		jLabel5.setText("\u670d\u52a1\u5668IP");

		GroupLayout layout = new GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(75, 75, 75)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addComponent(jLabel5)
												.addComponent(jLabel1)
												.addComponent(jLabel2)
												.addComponent(jLabel4)
												.addComponent(jButton1))
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton2,
																		GroupLayout.PREFERRED_SIZE,
																		99,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														GroupLayout.Alignment.LEADING,
														layout.createSequentialGroup()
																.addGap(34, 34,
																		34)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jComboBox2,
																						GroupLayout.Alignment.TRAILING,
																						0,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField1,
																						GroupLayout.Alignment.TRAILING,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						jComboBox1,
																						GroupLayout.Alignment.TRAILING,
																						0,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField3,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField2,
																						GroupLayout.DEFAULT_SIZE,
																						174,
																						Short.MAX_VALUE))))
								.addGap(106, 106, 106)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(53, 53, 53)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jComboBox1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField3,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField1,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel2))
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField2,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3))
								.addGap(11, 11, 11)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4)
												.addComponent(
														jComboBox2,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(11, 11, 11)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		dispose();
		System.exit(0);
		System.out.println("释放");
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		dispose();
		System.exit(0);
		System.out.println("释放");
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		setLocationRelativeTo(null);

		String [] dbTypes = new String[]{"MYSQL","ORACLE"};

		for (String key : dbTypes) {
			this.jComboBox1.addItem(key);
		}

		setLocationRelativeTo(null);
	}
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.jButton2.getText().equals("下一步")) {
			this.jButton2.setText("运行中...");
			this.jButton2.setEnabled(false);
			final Thread t=new Thread(new Runnable(){
				  public void run(){
					  String dbName = jComboBox2.getSelectedItem().toString();
					  String ip = jTextField3.getText();
					  String username = jTextField1.getText();
					  String password = jTextField2.getText();
					  String dbType = (String)jComboBox1.getSelectedItem();
					  DataBase db = new DataBase(dbType,ip,"3306",dbName);
					  db.setUserName(dbName);
					  db.setUserName(username);
					  db.setPassWord(password);
					  CodeUi codeUi = new CodeUi(db);
					  codeUi.setDbInfo(db,dbName);
					  codeUi.setVisible(true);
					  setVisible(false);
				  }}
				 );
			t.start();
			
		 }else{
			JOptionPane.showMessageDialog(null, "请选择数据库", "提示",
					JOptionPane.OK_OPTION);
		 }
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//
		jButton1.setText("连接中...");
		jButton1.setEnabled(false);
		
		final Thread t=new Thread(new Runnable(){
			  @Override
			  public void run(){
				  try{
				  	  String ip = jTextField3.getText();
					  String username = jTextField1.getText();
					  String password = jTextField2.getText();
					  String dbType = (String)jComboBox1.getSelectedItem();
					  DataBase db = new DataBase(dbType,ip,"3306","");
					  db.setUserName(username);
					  db.setPassWord(password);
					  List<String> catalogs = DataBaseUtils.getSchemas(db);
						jComboBox2.removeAllItems();
						for (String c : catalogs) {
							jComboBox2.addItem(c);
						}
						
						JOptionPane.showMessageDialog(null, "连接成功", "提示",
									JOptionPane.DEFAULT_OPTION);
						jButton2.setText("下一步");
					  
				  }catch (ClassNotFoundException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "无法加载驱动类", "提示",
								JOptionPane.OK_OPTION);
						
				  } catch (SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "无法连接数据库，请核对连接信息是否正确", "提示",
								JOptionPane.OK_OPTION);
				   }catch (Exception e) {
				     e.printStackTrace();
				     JOptionPane.showMessageDialog(null, "发生错误", "错误详情请查看error.log",
								JOptionPane.INFORMATION_MESSAGE);
				  }
				  jButton1.setEnabled(true);
				  jButton1.setText("测试连接");
			  }}
			 );
		t.start();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(() -> new DataBaseUi().setVisible(true));
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private JButton jButton1;
	private JButton jButton2;
	private JComboBox<String> jComboBox1;
	private JComboBox jComboBox2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}