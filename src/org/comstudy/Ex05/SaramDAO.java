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

	
	public Vector selectByName(SaramDTO saramInfo) {
		Vector saraminfo = new Vector();
		for(int idx=0; idx<saramList.size(); idx++) {
			
			
			if(saramInfo.getName().equals(saramList.get(idx).getName())) {
				saraminfo.add(saramList.get(idx).toVector());
			}
			
		}
		return saraminfo;
	}

	public Vector modify(SaramDTO saramInfo) {
		int idx = saramList.indexOf(saramInfo);
		Vector vector = new Vector();
		if(idx != -1) {
			saramList.set(idx, saramInfo);
			vector = saramList.get(idx).toVector();
			return vector;
		}
		
		
		return null;

	}

	public Vector delete(SaramDTO saramInfo) {
		Vector saraminfo = new Vector();
		for(int idx=0; idx<saramList.size(); idx++) {
			SaramDTO Info = saramList.get(idx);
			
			if(saramInfo.getName().equals(Info.getName())) {
				saraminfo.remove(idx);
			}
		}
		return saraminfo;
			
		
	}

	
	
	


	
	
	
	
	
}
