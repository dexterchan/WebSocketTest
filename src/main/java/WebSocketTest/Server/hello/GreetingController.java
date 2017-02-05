package WebSocketTest.Server.hello;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Model.Person;
import Model.PersonAjax;

@Controller
public class GreetingController {


	@RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }
	
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @RequestMapping(value="/table",method = RequestMethod.GET)
    public String hrhomepageTable(){
        return "hrindexTable.html";
    }
    @RequestMapping(value="/tableajax",method = RequestMethod.GET)
    public String hrajaxhomepageTable(){
        return "hrindexTable2.html";
    }
    
    @RequestMapping(value="/listallperson2",method = RequestMethod.GET)
    public ResponseEntity< PersonAjax > listAllPerson2() {
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
	    
	    p = new Person();
		p.name="Garrett Winters";
	    p.position="Accountant";
	    p.salary=170000;
	    p.start_date="2011/04/25";
	    p.office="Tokyo";
	    p.extn="1234";
	    pList.add(p);
	    
	    ajax.setData(pList);
		
		return new ResponseEntity< PersonAjax > ( ajax,HttpStatus.OK);
    }
   
}
