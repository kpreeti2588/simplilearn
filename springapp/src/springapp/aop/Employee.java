package springapp.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean,DisposableBean {

	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<Integer, String> map = new HashMap<Integer, String>();
    List<Integer> numberList = new ArrayList<>();
    
   /* public void init() {
    	 System.out.println("initialize method");
    }
    public void destroy() {
    	System.out.println("destroy method");
    }*/
    
	public List<Integer> getNumberList() {
		return numberList;
	}

	public void setNumberList(List<Integer> numberList) {
		this.numberList = numberList;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After properties set");
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy");
	}

}
