package org.comstudy.Ex05;

import java.util.Vector;

public class SaramDAO {
	// @Vector
	// 사람 정보 저장
	public static Vector<SaramDTO> saramList = new Vector<SaramDTO>();
	static {
		saramList.add(new SaramDTO(1, "kim", "kim@aa.com", "010-1111-1111"));
		saramList.add(new SaramDTO(2, "lee", "lee@bb.com", "010-2222-1111"));
		saramList.add(new SaramDTO(3, "park", "park@cc.com", "010-3333-1111"));
		
	}
	public static int sequence = 4;
	
	public Vector selectAll() {
		Vector vector = new Vector();
		for(int i=0; i < saramList.size(); i++) {
			vector.add(saramList.get(i).toVector());
		}
		
		return vector;
	}

	public void insert(SaramDTO saramDTO) {
		if(saramDTO != null) {
			saramDTO.setIdx(sequence++);
			saramList.add(saramDTO);
		}
	}
}
