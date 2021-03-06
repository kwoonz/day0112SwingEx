package org.comstudy.Ex05;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.comstudy.guiex.myframe.MyJFrame;

import static org.comstudy.Ex05.R.allBtn;
import static org.comstudy.Ex05.R.columNames;
import static org.comstudy.Ex05.R.data;
import static org.comstudy.Ex05.R.dao;
import static org.comstudy.Ex05.R.deleteBtn;
import static org.comstudy.Ex05.R.finishBtn;
import static org.comstudy.Ex05.R.inputBtn;
import static org.comstudy.Ex05.R.tbModel;
import static org.comstudy.Ex05.R.modifyBtn;
import static org.comstudy.Ex05.R.scrollPane;
import static org.comstudy.Ex05.R.searchBtn;
import static org.comstudy.Ex05.R.table;
import static org.comstudy.Ex05.R.txtFld1;
import static org.comstudy.Ex05.R.txtFld2;
import static org.comstudy.Ex05.R.txtFld3;
import static org.comstudy.Ex05.R.txtFld4;

public class TestJTable extends MyJFrame {

	
	public TestJTable() {
		super("JTable 연습", 640, 480);
		
	}
	
	public void mkTableData() {
		//columNames = new Object[] {"IDX", "USER", "EMAIL", "PHONE"};
		
		/*
		data = new Object[][] {
			{1, "hong", "hong@naver.com", "010-1111-1111"},
			{2, "kim",  "kim@naver.com", "010-2222-2222"},
			{3, "lee",  "lee@naver.com", "010-3333-3333"},
			
		};
		*/
		columNames = new Vector();
		columNames.add("IDX");
		columNames.add("NAME");
		columNames.add("EMAIL");
		columNames.add("PHONE");
		
		data = dao.selectAll();
	}

	@Override
	protected void displayLayer() {
		mkTableData();
		contentPan = getContentPane();
		
		// 클래스생성자를 호출한다.
		contentPan.add(BorderLayout.WEST, new LeftPane());
		contentPan.add(BorderLayout.SOUTH, new BottomPane());
		
		
		// Table에 DefaultTableModel 붙이기
		tbModel = new DefaultTableModel(data, columNames);
		table = new JTable(tbModel);
		
		scrollPane = new JScrollPane(table);
		contentPan.add(scrollPane);
		
	}
	
	private void addRowDataTest() {
		// data 삭제
		tbModel.setDataVector(null, columNames);
				
		// 데이터 추가
		tbModel.addRow(new Object[] {4, "aaa", "aa@a.com", "010-4444-4444"});
		tbModel.addRow(new Object[] {5, "bbb", "bb@a.com", "010-5555-5555"});
	}
	
	


	
	
	@Override
	protected void actionEvent() {
		// 테이블 이벤트 핸들러 추가
		table.addMouseListener(new MouseListener() {
			

			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {
				JTable tbl = (JTable) e.getSource();
				
				// 데이블의 전체 행과 열 알아내기
				int totalcol = tbl.getColumnCount();
				int totalrow = tbl.getRowCount();
				//System.out.println(row + ", "+ col);
				
				// 선택한 컬럼의 행과 열 알아내기
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				// 데이터 찾아오기
				int idx = (int) tbModel.getValueAt(row, 0);
				String name = (String) tbModel.getValueAt(row, 1);
				String email = (String) tbModel.getValueAt(row, 2);
				String phone = (String) tbModel.getValueAt(row, 3);
				//System.out.println(idx + " "+ name +" "+ email+" "+phone);
				
				// 찾아 온 데이터 적용하기
				txtFld1.setText(""+idx);
				txtFld2.setText(name);
				txtFld3.setText(email);
				txtFld4.setText(phone);
				
			}
			
			public void mouseExited(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {}

		});
		
		
		
		
		
		// 버튼 이벤트 핸들러 추가
		
		// 전체 검색
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.selectAll();
				
			}
		});
		
		
		
		// 삽입
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// textField의 데이터를 읽어온다.
				String name = txtFld2.getText();
				// textxFild의 읽어오고 비워준다.
				txtFld2.setText("");
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				
				// TableModel에 반영 해 주기.
				//tbModel.addRow(new Object[] {sequence++, name, email, phone});
				
				// dao에 저장 후 
				dao.insert(new SaramDTO(0, name, email, phone));
				
				// list를 다시 그려준다.
				displayList();
				
			}
			
			
			private void displayList() {
				// 데이터 삭제
				tbModel.setDataVector(null, columNames);
				
				Vector<Vector> saramList = dao.selectAll();
				for (Vector vector : saramList) {
				// 데이터 추가
				tbModel.addRow(vector);
				}
				
			}

		});
		

		
		// 검색
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtFld2.getText();
				txtFld2.setText("");
				

				Vector<Vector> saramList = dao.selectByName(new SaramDTO(0, name, null, null));
				
				displayList(saramList);
				
				
			}
			
			
			
			private void displayList(Vector<Vector> sList) {
				// 데이터 삭제
				tbModel.setDataVector(null, columNames);
				
				
				Vector<Vector> saramList = sList;
				for (Vector vector : saramList) {
					
				// 데이터 추가
				tbModel.addRow(vector);
				}
				
			}
			
			
		});
		
		// 수정
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtFld1.getText();
				txtFld2.setText("");
				String name = txtFld2.getText();
				txtFld2.setText("");
				String email = txtFld3.getText();
				txtFld3.setText("");
				String phone = txtFld4.getText();
				txtFld4.setText("");
				
				int idx = 0;
				
				try {
					idx = Integer.parseInt(id);
				} catch (NumberFormatException e1) {
					idx = 0;
				}
				
				Vector vector = dao.modify(new SaramDTO(idx, name, email, phone));
				
				displayAll();
				
				
			}

			private void displayAll() {
				tbModel.setDataVector(null, columNames);
				Vector<Vector> saramList = dao.selectAll();
				for(Vector vector : saramList) {
					tbModel.addRow(vector);
				}
				
			}

		});
		
		//삭제
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtFld2.getText();
				txtFld2.setText("");

				
				
				 dao.delete(new SaramDTO(0, name, null, null));
				
				

				
			}


		});
		
		//종료
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestJTable.this, "굿바이~");
				dispose();
				System.exit(0);
				
			}
		});
		
		
		
		
	}
	

	public static void main(String[] args) {
		new TestJTable().setVisible(true);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
