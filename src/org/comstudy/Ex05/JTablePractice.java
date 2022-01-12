package org.comstudy.Ex05;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.comstudy.guiex.myframe.MyJFrame;

public class JTablePractice extends MyJFrame {
	JTable table;
	DefaultTableModel tbModel;
	JScrollPane scrollPane;
	
	Object[][] data;
	Object[] columNames;
	
	public JTablePractice() {
		super("JTable ¿¬½À", 640, 480);
	}
	
	

	@Override
	protected void displayLayer() {
		contentPan = getContentPane();
		

	}

	@Override
	protected void actionEvent() {
		columNames = new Object[] {"IDX", "USER", "PHONE", "EMAIL"};
		
		data = new Object[][] {
			{1, "hong", "010-1111-1111", "hong@a.com"},
			{2, "kim", "010-2222-2222", "kim@a.com"},
			{3, "lee", "010-3333-3333", "lee@a.com"},
			
		};

	}

	public static void main(String[] args) {
		new JTablePractice().setVisible(true);

	}

}
