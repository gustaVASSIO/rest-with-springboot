package br.bosch.com;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.bosch.com.exceptions.UnsupportedMathOperationException;


@RestController
public class MathController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{n1}/{n2}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "n1") String n1, 
			@PathVariable( value = "n2") String n2 ) throws Exception {
		
		if(!isNumeric(n1) || !isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please, insert a numeric value");
		
		return Double.parseDouble(n1) + Double.parseDouble(n2);
	}
	@RequestMapping(value = "/subtraction/{n1}/{n2}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "n1") String n1, 
			@PathVariable( value = "n2") String n2 ) throws Exception {
		
		if(!isNumeric(n1) || !isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please, insert a numeric value");
		
		return Double.parseDouble(n1) - Double.parseDouble(n2);
	}
	@RequestMapping(value = "/multiplication/{n1}/{n2}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "n1") String n1, 
			@PathVariable( value = "n2") String n2 ) throws Exception {
		
		if(!isNumeric(n1) || !isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please, insert a numeric value");
		
		return Double.parseDouble(n1) * Double.parseDouble(n2);
	}
	@RequestMapping(value = "/division/{n1}/{n2}", method = RequestMethod.GET)
	public Double division(@PathVariable(value = "n1") String n1, 
			@PathVariable( value = "n2") String n2 ) throws Exception {
		
		if(!isNumeric(n1) || !isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please, insert a numeric value");
		
		return Double.parseDouble(n1) /  Double.parseDouble(n2);
	}
	@RequestMapping(value = "/sum/{n1}", method = RequestMethod.GET)
	public Double poten(@PathVariable(value = "n1") String n1, 
			@PathVariable( value = "n2") String n2 ) throws Exception {
		
		if(!isNumeric(n1) || !isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please, insert a numeric value");
		
		return Double.parseDouble(n1) /  Double.parseDouble(n2);
	}

	private boolean isNumeric(String n) {
		if(n == null) return false;
		
		String number = n.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
