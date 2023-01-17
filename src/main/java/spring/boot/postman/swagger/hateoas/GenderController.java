package spring.boot.postman.swagger.hateoas;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenderController {

	@GetMapping(value="getGender/{genderID1}"
			,
			produces= {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Gender> getGender(@PathVariable("genderID1") int genderID){
		Gender g=new Gender();
		g.setGenderCode("M");
		g.setGenderId(1);
		g.setGenderName("Male");
		
		Link withLink=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GenderController.class).getAllGenderList())
				.withRel("Books");
		g.add(withLink);
				
		ResponseEntity ret=new ResponseEntity(g,HttpStatus.OK);
		
		return ret;
	}
	
	@GetMapping(value="getAllGenderList" ,
			produces= {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList> getAllGenderList(){
		Gender g=new Gender();
		g.setGenderCode("M");
		g.setGenderId(1);
		g.setGenderName("Male");
		
		Gender g1=new Gender();
		g1.setGenderCode("M");
		g1.setGenderId(1);
		g1.setGenderName("Male");

		Gender g2=new Gender();
		g2.setGenderCode("M");
		g2.setGenderId(1);
		g2.setGenderName("Male");
		
		ArrayList<Gender> al=new ArrayList();
		
		al.addAll(Arrays.asList(g,g1,g2));
		
		for(int k=0;k<al.size();k++) {
			Gender g4=al.get(k);
			System.out.println(g4.getGenderCode() +" Gender Code "+
			g4.getGenderId() + "  Gender ID " +
					g4.getGenderName() + "  Gender Name ");
		}
		
		ResponseEntity ret=new ResponseEntity(al,HttpStatus.OK);
		
		return ret;
	}
}
