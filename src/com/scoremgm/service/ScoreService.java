package com.scoremgm.service;

public interface ScoreService {
	public void register();
	public void list();
	public void search();
	public void update();
	public void delete();
	public void exit();
	public int getCount();
}
/*
1. 학생 등록<br>
2. 학생 목록 조회<br>
3. 학생 성적 검색<br>
4. 성적 수정<br>
5. 학생 삭제<br>
6. 종료<br>
*/