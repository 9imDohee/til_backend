package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

public class PersonManager {
	private List<Person> pList = new ArrayList<>();

	// singleton
	private PersonManager() {
		pList.add(new Person("Yang",10,"M",new String[] {"singing"}));
		pList.add(new Person("Kim",30,"M",new String[] {"eating"}));
		pList.add(new Person("Park",50,"M",new String[] {"sleeping"}));
	}

	private static PersonManager pManager = new PersonManager();

	public static PersonManager getManager() {
		return pManager;
	}

	public void add(Person p) {
		pList.add(p);
	}

	public List<Person> getList(){
		return pList;
	}
}
