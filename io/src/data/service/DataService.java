package data.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

import data.repo.DataRepo;
import data.vo.Data;

public class DataService {

	private DataRepo repo;

	public DataService() throws Exception {
		repo = new DataRepo();
	}

	// 전체 사고건수, 사망자수를 출력하는 기능
	public void printAllDataCount() {
		List<Data> items = repo.getAllData();

		int totalDeath = 0;
		for (Data data : items) {
			totalDeath += data.getNumOfDeath();
		}

		System.out.println("전체 사고건수: " + items.size());
		System.out.println("전체 사망자수: " + totalDeath);
	}

	// 시도를 전달받아서 해당 지역의 사고건수와 사망자수를 출력하는 기능
	public void printDataBySido(String sido) {
		List<Data> items = repo.getDataBySido(sido);

		int totalDeath = 0;
		for (Data data : items) {
			totalDeath += data.getNumOfDeath();
		}

		System.out.println("[" + sido + "] 지역 사고 현황");
		System.out.println("전체 사고건수: " + items.size());
		System.out.println("전체 사망자수: " + totalDeath);
	}

	// 날짜를 전달받아서 해당 날짜의 사고건수와 사망자수를 출력하는 기능
	public void printDataByDay(String day) {
		List<Data> items = repo.getDataByDay(day);

		int totalDeath = 0;
		for (Data data : items) {
			totalDeath += data.getNumOfDeath();
		}

		System.out.println("[" + day + "] 날짜 사고 현황");
		System.out.println("전체 사고건수: " + items.size());
		System.out.println("전체 사망자수: " + totalDeath);
	}

	// 시도를 전달받아서 해당 지역의 구군별 사고현황 통계를 출력하는 기능
	public void printDataStatBySido(String sido) {
		// 해당시도 사고 데이터 로드
		List<Data> items = repo.getDataBySido(sido);
		// 사고건수, 사망자수를 표현하고 싶음
		// 값을 2개가진 객체가 필요
		// 내부클래스 이용해서 클래스 생성
		TreeMap<String, Stat> map = new TreeMap<String, Stat>();
		
		// DB에서 각 지역구 및 사망자 추출
		for(Data data : items) {
			String gugun = data.getGugun();
			int death = data.getNumOfDeath();
			
			// 맵에 지역구 존재시 카운트만
			if(map.containsKey(gugun)) {
				//키(지역구)를 통해서 값(stat)불러옴
				Stat stat = map.get(gugun);
				stat.setRecords(stat.getRecords() + 1);
				stat.setDeaths(stat.getDeaths() + death);
				
			} else {
				//맵에 새로 등록
				Stat stat = new Stat();
				stat.setRecords(1);
				stat.setDeaths(death);
				map.put(gugun, stat);
				
			}
		}
		// map.navigable로 키값만 불러오기
		NavigableSet<String> set = map.navigableKeySet();
		System.out.println("[구군] 사고건수 사망자수");
		// 키값으로 값 불러와서 출력
		for(String key : set) {
			Stat stat = map.get(key);
			System.out.println("["+key+"] " + stat.getRecords() + " " + stat.getDeaths());
		}
		
	}

	// 월	사고건수	사망자수
	// 월별 사고현황 통계를 출력하는 기능
	public void printDataStatByMonth() {
		// DB불러오기
		List<Data> items = repo.getAllData();
		// 맵생성
		TreeMap<String, Stat> map = new TreeMap<String, Stat>();
		// 월 : 12개 사고사망자수 가져오기
		for(Data data : items) {
			String month = data.getDay().substring(0, 2);
			int death = data.getNumOfDeath();
			
			// 맵에 저장
			if(map.containsKey(month)) {
				Stat stat = map.get(month);
				stat.setRecords(stat.getRecords()+1);
				stat.setDeaths(stat.getDeaths() + death);
				
			} else {
				Stat stat = new Stat();
				stat.setRecords(1);
				stat.setDeaths(death);
				
				map.put(month, stat);
			}
		}
		// 출력
		NavigableSet<String> set = map.navigableKeySet();
		System.out.println("[월] 사고건수 사망자수");
		for(String key : set) {
			Stat stat = map.get(key);
			System.out.println("["+key+"] " + stat.getRecords() + " " + stat.getDeaths());
		}	
	}
	// 요일별 사고현황 통계를 출력하는 기능
	public void printDataStatByDayOfWeek() {
		// DB불러오기
				List<Data> items = repo.getAllData();
				// 맵생성
				TreeMap<String, Stat> map = new TreeMap<String, Stat>();
				// 월 : 12개 사고사망자수 가져오기
				for(Data data : items) {
					String dayOfWeek = data.getDayOfWeek();
					int death = data.getNumOfDeath();
					
					// 맵에 저장
					if(map.containsKey(dayOfWeek)) {
						Stat stat = map.get(dayOfWeek);
						stat.setRecords(stat.getRecords()+1);
						stat.setDeaths(stat.getDeaths() + death);
						
					} else {
						Stat stat = new Stat();
						stat.setRecords(1);
						stat.setDeaths(death);
						
						map.put(dayOfWeek, stat);
					}
				}
				//????????????????
				//왜 map이 key값 순으로 정렬되어있지 않다. 왜???
				
				
				System.out.println(map);
				// 출력
				NavigableSet<String> set = map.navigableKeySet();
							
				System.out.println("[요일] 사고건수 사망자수");
				for(String key : set) {
					Stat stat = map.get(key);
					System.out.println("["+key+"] " + stat.getRecords() + " " + stat.getDeaths());
				}
	}
	// 사고현황 요약 결과를 출력하는 기능
	public void printDataStat() {
		
	}
	
	// 메소드 안에서 한번만 사용할꺼라서 내부클래스 생성
	class Stat {
		private int records;
		private int deaths;
		
		public Stat() {}

		public int getRecords() {
			return records;
		}

		public void setRecords(int records) {
			this.records = records;
		}

		public int getDeaths() {
			return deaths;
		}

		public void setDeaths(int deaths) {
			this.deaths = deaths;
		}				
	}
	
}
