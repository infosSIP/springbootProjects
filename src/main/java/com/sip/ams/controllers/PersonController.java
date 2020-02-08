package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;
import com.sip.ams.entities.Person;
import com.sip.ams.forms.PersonForm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Persons")
public class PersonController {

	@Value("${error.message}")
    private String errorMessage;
 

	
	private  static List<Person> persons = new ArrayList<Person>();
	 
    static {
        persons.add(new Person(0,"Albert", "Einstein"));
        persons.add(new Person(1,"Frederic", "Gauss"));
        persons.add(new Person(2,"Belman", "Bel"));
    }
    static int nbr = 2;
    
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "Person/personList";
    }
    
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        PersonForm personForm = new PersonForm();
        //personForm.setFirstName("Faycel");
        //personForm.setLastName("El Ayeb");
        model.addAttribute("personForm", personForm);
       
        return "Person/addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model,  @ModelAttribute("personForm") PersonForm personForm) {
     nbr++;
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(nbr,firstName, lastName);
            persons.add(newPerson);
 
            return "redirect:personList";
            //return "Person/personList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "Person/addPerson";
    }

    
    /// delete person method
  
    @RequestMapping(value = { "/deletePerson/{fname}/{lname}/{id}" }, method = RequestMethod.GET)
    public String deletePerson(@PathVariable String fname, @PathVariable String lname, @PathVariable int id, Model model) {
 
        //System.out.println(id);
    	Person p = new Person(id,fname,lname);
        persons.remove(p);
        //persons.remo
        model.addAttribute("persons", persons);
        return "Person/personList";
        
    }
 


}
