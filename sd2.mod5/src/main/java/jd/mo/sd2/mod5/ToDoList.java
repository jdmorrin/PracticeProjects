package jd.mo.sd2.mod5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoList {		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id;
		
		@Column(name="name")
		private String name;
		
		@ElementCollection
		List <String> items = new ArrayList <String> ();
	    
		public ToDoList(){} 
		
		public Long getId() {
			return id;
		}
	    
		public List<String> getList() {
			return items;
		}
		
		public void setToDo(ArrayList<String> items) {
			this.items = items;
		}
	    
	    public void addItem(String str){
	        this.items.add(str);
	    }
	    
	    public void deleteItem(){
	        items.remove(items.size() - 1);
	    }
	    
	    public void display(){
	        for(String item : items){
	            System.out.println(item);
	        }
	    }
	    
	    public void showMenu(){
	        System.out.println(
	                "1. Add item\n"
	                + "2. Delete Item\n"
	                + "3. Show items in list");
	    }
}
