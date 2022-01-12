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
		
		// 데이터와 테이블 생성
		mkTbl();
	}
	
	private void mkTbl() {
		// 속성 위에 부분
		colNames = new Object[] {"idx", "name", "phone"};
		
		// 테이블에 들어갈 부분
		rowData = new Object[][] {
			{1, "kim", "1111-1111"},
			{2, "lee", "2222-2222"},
			{3, "pack", "3333-3333"},
			{4, "kang", "4444-4444"},
			{5, "hong", "5555-5555"}
		};
		
		// DefaultTableModel rowData(행의수를 반환) colNames(열의 수를 반환)
		tableModel = new DefaultTableModel(rowData, colNames);
		
		// JTable을 모델로 만들어 주자 수정하기 편하다.
		table = new JTable(tableModel);
		
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);		
		
		
		// 이벤트가 발생하면 이문장이 실행되게
		// ---------- 내용 변경 ------------
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
