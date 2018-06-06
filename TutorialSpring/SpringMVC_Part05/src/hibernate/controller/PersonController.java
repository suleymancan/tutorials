/**
 * 
 */
package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hibernate.domain.Person;
import hibernate.service.PersonService;

/**
 * @author suleymancan Mar 20, 2018
 */
@Controller
public class PersonController {

	@Autowired
	private PersonService personServiceImpl;

	@RequestMapping(value = "/person.list", method = RequestMethod.GET)
	public String getPersonList(Model model) {
		System.out.println("...getPersonList...");
		List<Person> personList = personServiceImpl.getAllPersons();
		model.addAttribute("newPerson", new Person());
		model.addAttribute("allPersons", personList);
		return "hibernate.view/personList";

	}

	@RequestMapping(value = "/person.add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("newPerson") Person person, Model model) {
		System.out.println("...addPerson...");
		personServiceImpl.insertPerson(person);
		return "redirect:/person.list";
	}

	@RequestMapping(value = "/person.delete{personId}", method = RequestMethod.GET)
	public String deletePerson(@RequestParam("personId") int id, Model model) {

		System.out.println("...deletePerson...");
		personServiceImpl.deletePerson(id);
		return "redirect:/person.list";
	}

	@RequestMapping(value = "/person.edit{personId}", method = RequestMethod.GET)
	public String editPerson(@RequestParam("personId") int id, Model model) {

		System.out.println("...editPerson ...");

		model.addAttribute("newPerson", personServiceImpl.getPersonById(id));
		model.addAttribute("allPersons", personServiceImpl.getAllPersons());
		model.addAttribute("update", "update");
		return "hibernate.view/personList";
	}

	@RequestMapping(value = "/person.update", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("newPerson") Person person, Model model) {
		personServiceImpl.updatePerson(person);
		return "redirect:/person.list";
	}
}
