package com.sip.ams.entities;

public class Person {
    private String firstName;
    private String lastName;
    private int id;

    public Person() {
 
    }
 
  public Person(int id,String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
 
    public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public String getFirstName() {
        return firstName;
   }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public boolean equals(Object o)
    {
    	Person temp = (Person)o;
    	
    	return this.id == temp.id && this.firstName.equals(temp.firstName) && this.lastName.equals(temp.lastName);
    }
}
