package RestfulWebService;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Model.Person;
import Model.PersonAjax;


@RestController
public class MainController {
    
    //Not working!!!
    
    @RequestMapping(value="/listallperson",method = RequestMethod.GET)
    public ResponseEntity< PersonAjax > listAllPerson() {
		PersonAjax ajax = new PersonAjax();
		
		List<Person> pList = new LinkedList<Person>();
		Person p = new Person();
		p.name="Tiger Nixon";
	    p.position="System Architect";
	    p.salary=320800;
	    p.start_date="2011/04/25";
	    p.office="Edinburgh";
	    p.extn="5421";
	    pList.add(p);
	    
	    
	    ajax.setData(pList);
		
		return new ResponseEntity< PersonAjax > ( ajax,HttpStatus.OK);
    }
    
}