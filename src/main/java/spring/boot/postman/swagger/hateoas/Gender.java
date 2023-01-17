package spring.boot.postman.swagger.hateoas;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
//@EqualsAndHashCode
public class Gender extends RepresentationModel<Gender>{
	private int genderId;
	private String genderName;
	private String genderCode;
	

}
