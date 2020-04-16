/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gp41370
 */

public class Student 
{
    
    private String firstName, lastName,emailAddress;
    
    public Student(String firstName, String lastName, String emailAddress) 
    {     
        this.emailAddress = emailAddress;
        this.firstName  = firstName;
        this.lastName = lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
	
    public String getLastName()
    {
	return lastName;
    }
	
    public String getEmail()
    {
	return emailAddress;
    }
}
