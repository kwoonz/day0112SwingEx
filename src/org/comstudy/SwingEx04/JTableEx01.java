package org.comstudy.SwingEx04;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEx01 extends JFrame { 
	Container contentPane;
	JTable table;
	DefaultTableModel tableModel;
	JScrollPane scrollPane;
	
	Object[][] rowData;
	Object[] colNames;
	
	public JTableEx01() {
		init();
		start();
	}
	
	private void init() {
		contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		setSize(640, 480);
		
		// �����Ϳ� ���̺� ����
		mkTbl();
	}
	
	private void mkTbl() {
		// �Ӽ� ���� �κ�
		colNames = new Object[] {"idx", "name", "phone"};
		
		// ���̺� �� �κ�
		rowData = new Object[][] {
			{1, "kim", "1111-1111"},
			{2, "lee", "2222-2222"},
			{3, "pack", "3333-3333"},
			{4, "kang", "4444-4444"},
			{5, "hong", "5555-5555"}
		};
		
		// DefaultTableModel rowData(���Ǽ��� ��ȯ) colNames(���� ���� ��ȯ)
		tableModel = new DefaultTableModel(rowData, colNames);
		
		// JTable�� �𵨷� ����� ���� �����ϱ� ���ϴ�.
		table = new JTable(tableModel);
		
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);		
		
		
		// �̺�Ʈ�� �߻��ϸ� �̹����� ����ǰ�
		// ---------- ���� ���� ------------
		tableModel.setDataVector(null, colNames);
		tableModel.addRow(new Object[] {3, "ccc", "7777"});
		tableModel.addRow(new Object[] {2, "bbb", "8888"});
		tableModel.addRow(new Object[] {1, "aaa", "9999"});
		
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}



	public static void main(String[] args) {
		new JTableEx01().setVisible(true);
	}
}
