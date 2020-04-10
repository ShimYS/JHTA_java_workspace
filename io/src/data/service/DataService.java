package data.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

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
		// 모든 DB정보 불러오기
		List<Data> items = repo.getAllData();
		// 맵생성 -> 키값1개, 벨류2개(객체를 만들어서 하나로 던지기)
		TreeMap<String, Stat> map = new TreeMap<String, Stat>();
		// 월 : 12개(키값), 사고사망자수 가져오기
		for(Data data : items) {
			String month = data.getDay().substring(0, 2);
			int death = data.getNumOfDeath();
			
			// 맵에 저장     키값(월)로 유무확인해서 있으면 카운트만 업, 없으면 새로운 엔트리 생성
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
		// 키값세트 불러오기 => Stat객체 불러오기 => 출력
		NavigableSet<String> set = map.navigableKeySet();
		System.out.println("[월] 사고건수 사망자수");
		for(String key : set) {
			Stat stat = map.get(key);
			System.out.println("["+key+"월] " + stat.getRecords() + " " + stat.getDeaths());
		}	
	}

	// 쌤표 월별 사고현황 통계 출력
	public void printDataStatBymontgByTeacher() {
		List<Data> items = repo.getAllData();
		TreeMap<Integer, Stat> stats = new TreeMap<Integer, Stat>();
		
		for(Data data : items) {
			String day = data.getDay();
			String monthString = day.substring(0, 2);
			int month = 0;
			if(monthString.startsWith("0")) {
				month = Integer.parseInt(monthString.substring(1));
			} else {
				month = Integer.parseInt(monthString);
			}
			
			// Map에서 month를 key로 Stat객체를 조회한다
			Stat savedStat = stats.get(month);
			// 저장된 Stat객체가 없으면
			if(savedStat == null) {
				// Stat객체 만들어서 사망자수, 사고건수 카운트 넣어주기
				Stat stat = new Stat();
				stat.setDeaths(data.getNumOfDeath());
				stat.setRecords(1);
				
				stats.put(month, stat);
				// Stat객체가 있다면 사망자수 추가, 사고건수 카운트 +1
			}  else {
				savedStat.setDeaths(savedStat.getDeaths() + data.getNumOfDeath());
				savedStat.setRecords(savedStat.getRecords() + 1);
			}
			
		}
		System.out.println("[월] 사고건수 사망자수");
		int size = stats.size();
		for(int i=1; i<=size; i++) {
			Stat stat = stats.get(i);
			System.out.println("["+i+"월] " + stat.getRecords() + " " + stat.getDeaths());
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

				// 출력
				NavigableSet<String> set = map.navigableKeySet();
							
				System.out.println("[요일] 사고건수 사망자수");
				for(String key : set) {
					Stat stat = map.get(key);
					System.out.println("["+key+"] " + stat.getRecords() + " " + stat.getDeaths());
				}
	}
	
	// 위반 내용별
	public void printDataStatViolation() {
		// 모든 DB정보 불러오기
		List<Data> items = repo.getAllData();
		// 맵생성 -> 키값1개, 벨류2개(객체를 만들어서 하나로 던지기)
		TreeMap<String, Stat> map = new TreeMap<String, Stat>();
		// 월 : 12개(키값), 사고사망자수 가져오기
		for(Data data : items) {
			String violationOfLaw = data.getViolationOfLaw();
			int death = data.getNumOfDeath();
			
			// 맵에 저장     키값(월)로 유무확인해서 있으면 카운트만 업, 없으면 새로운 엔트리 생성
			if(map.containsKey(violationOfLaw)) {
				Stat stat = map.get(violationOfLaw);
				stat.setRecords(stat.getRecords()+1);
				stat.setDeaths(stat.getDeaths() + death);
				
			} else {
				Stat stat = new Stat();
				stat.setRecords(1);
				stat.setDeaths(death);
				
				map.put(violationOfLaw, stat);
			}
		}
		// 키값세트 불러오기 => Stat객체 불러오기 => 출력
		NavigableSet<String> set = map.navigableKeySet();
		System.out.println("[위반 내용] 사고건수 사망자수");
		for(String key : set) {
			Stat stat = map.get(key);
			System.out.println("["+key+"] " + stat.getRecords() + " " + stat.getDeaths());
		}	
	}		
	
	// 사고현황 요약 결과를 출력하는 기능
	public void printDataStat() {
		// 최다 사고 발생 시도, 최다 사고 발생 월, 최다 사고 발생일, 최다 사고 발생요일, 최다 사고 발생 유형
		Map<String, Map<String, Stat>> map = new HashMap<String, Map<String,Stat>>();
		map.put("시도별", new HashMap<String, Stat>());
		map.put("월별", new HashMap<String, Stat>());
		map.put("날짜별", new HashMap<String, Stat>());
		map.put("요일별", new HashMap<String, Stat>());
		map.put("사고유형별", new HashMap<String, Stat>());
		
		Map<String, Stat> sidoMap = map.get("시도별");
		Map<String, Stat> monthMap = map.get("월별");
		Map<String, Stat> dayMap = map.get("날짜별");
		Map<String, Stat> dayOfWeekMap = map.get("요일별");
		Map<String, Stat> violationMap = map.get("사고유형별");
		
		List<Data> items = repo.getAllData();

		for(Data data:items) {
			String sido = data.getSido();
			String month = data.getDay().substring(0, 2);
			String day = data.getDay();
			String dayOfWeek = data.getDayOfWeek();
			String violation = data.getViolationOfLaw();
			int death = data.getNumOfDeath();
				
			reduceStat(sido, death, sidoMap);			
			reduceStat(month, death, monthMap);			
			reduceStat(day, death, dayMap);			
			reduceStat(dayOfWeek, death, dayOfWeekMap);			
			reduceStat(violation, death, violationMap);
			
		}
		
		Stat sidoMaxStat = maxState(sidoMap);
		Stat monthMaxStat = maxState(monthMap);
		Stat dayMaxStat = maxState(dayMap);
		Stat dayOfWeekMaxStat = maxState(dayOfWeekMap);
		Stat violationMaxStat = maxState(violationMap);
		
		System.out.println("============ 교통사고 현황 요약 =============");
		System.out.println("구                     분                        \t\t사고 건수     사망자수");
		System.out.println("최다 사고 발생 시도:\t" + sidoMaxStat.getName() + "\t\t" + sidoMaxStat.getRecords() + "\t" + sidoMaxStat.getDeaths());
		System.out.println("최다 사고 발생 월   :\t" + monthMaxStat.getName() + "\t\t" + monthMaxStat.getRecords() + "\t" + monthMaxStat.getDeaths());
		System.out.println("최다 사고 발생 날짜:\t" + dayMaxStat.getName() + "\t\t" + dayMaxStat.getRecords() + "\t" + dayMaxStat.getDeaths());
		System.out.println("최다 사고 발생 요일:\t" + dayOfWeekMaxStat.getName() + "\t\t" + dayOfWeekMaxStat.getRecords() + "\t" + dayOfWeekMaxStat.getDeaths());
		System.out.println("최다 사고 발생 유형:\t" + violationMaxStat.getName() + "\t" + violationMaxStat.getRecords() + "\t" + violationMaxStat.getDeaths());
		System.out.println("======================================");
	}
	
	
	private void reduceStat(String key, int death, Map<String, Stat> map) {
		if(map.containsKey(key)) {
			Stat stat = map.get(key);
			stat.setDeaths(stat.getDeaths()+death);
			stat.setRecords(stat.getRecords()+1);
		} else {
			Stat stat = new Stat();
			stat.setName(key);
			stat.setDeaths(death);
			stat.setRecords(1);
			
			map.put(key, stat);
		}
	}
	
	private Stat maxState(Map<String, Stat> map) {
		Collection<Stat> stats = map.values();
		TreeSet<Stat> treeSet = new TreeSet<Stat>(stats);
		return treeSet.last();
	}
	
//	//TreeMap 리스트를 받아
//	// 월 화 수 .. 배열 만들고
//	//키값추출
//	// 키값 반복문 돌리면서 배열 순으로 정렬
//	// TreeMap을 반환
//	public TreeMap<String, Stat> sortMap (TreeMap<String, Stat> map){
//		TreeMap<String, Stat> result = null;
//		NavigableSet<String> set = map.navigableKeySet();
//		String[] month = {"월","화","수","목","금","토","일"};
//		
//		for(int i=0; i<month.length; i++) {	
//		}		
//		return result;
//	}
	
	// 메소드 안에서 한번만 사용할꺼라서 내부클래스 생성
	class Stat implements Comparable<Stat> {
		private String name;
		private int records;
		private int deaths;
		
		public Stat() {}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

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
		
		@Override
		public int compareTo(Stat other) {
			return this.deaths - other.deaths;
		}
	}

	
	
	
	
}
