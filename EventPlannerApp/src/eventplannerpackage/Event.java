package eventplannerpackage;
import java.util.ArrayList;
import java.util.HashMap;

// name, description, totalPeople, totalCost... 
public class Event {
	String name;
	String descrition;
	ArrayList<String> people = new ArrayList<String>();
	HashMap<String, Integer> expenses = new HashMap<>();
	
	// simple for now / sum a list later ------
	Integer totalPeople = 0;
	Double totalCost = 0.00;
	public int getTotalPeople() {
		return totalPeople;
	}
	public int getTotalCost() {
		return totalPeople;
	}
	public void setTotalPeople(int people) {
		totalPeople = people;
	}
	public void setTotalCost(double cost) {
		totalCost = cost;
	}
	// ------------------------------------------
	
	
	public Event(String name){
		this.name = name;
	}
	
		
	
	// Functions
	public String getName(){
		return this.name;
	}
	public void setName(String n){
		this.name = n;
	}
	public String getDescription(){
		return this.descrition;
	}
	public void setDescription(String d){
		this.descrition = d;
	}
	
	//Functions specific to People
	public ArrayList<String> getPeople(){
		return this.people;
	}
	public void addPerson(String p){
		int i = findPerson(p);
		if( i!= -1) {
			System.out.print("Person already in event");
		}
		else {
			this.people.add(p);
		}
	}
	public int findPerson(String p) {
		int pos = -1;
		for (int i = 0; i < people.size(); i++) {
			if (this.people.get(i) == p) {
				pos = i;
			}
		}
		return pos;
	}
	public void editPerson(String oldP, String newP) {
		int i = findPerson(oldP);
		if( i== -1) {
			System.out.print("Person not in list");
		}
		else {
			this.people.set(i, newP);
		}
	}
	public void removePerson(String p) {
		int i = findPerson(p);
		if( i== -1) {
			System.out.print("Person not in list");
		}
		else {
			this.people.remove(i);
		}
	}
	
	//Functions specific to Expenses
	public HashMap<String, Integer> getExpenses() {
		return this.expenses;
	}
	public void addExpense(String e, int c) {
		if(this.expenses.containsKey(e)) {
			System.out.print("Expense already in event");
		}
		else {
			this.expenses.put(e, c);
		}
	}
	public void removeExpense(String e) {
		this.expenses.remove(e);
	}
	public void editExpense(String oldE, String newE, int c) {
		if(oldE!=newE) {
			this.expenses.remove(oldE);
		}
		this.expenses.put(newE, c);
	}
	
	// correct way! add back after midterm thing
	/*
	public int getTotalCost() {
		int tot=0;
		for (int i : expenses.values()) {
			  tot+=i;
			}
		return tot;
	}
	public int getTotalPeople() {
		return this.people.size();
	}
	*/
}
