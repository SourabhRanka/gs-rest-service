package hello.maths;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathsController {

    
    @RequestMapping(value="api/v1/add",method=RequestMethod.POST)
    public ResponseEntity<MathResult> addNumber(@RequestParam(value="operand1") Float o1,@RequestParam(value="operand2") Float o2) {
     MathResult mr = 	new MathResult();
     mr.setResult(new Float(o1+o2));	
    	return new ResponseEntity<MathResult>(mr,HttpStatus.OK);
    }
    
    @RequestMapping(value="api/v1/{operation}/{number}",method=RequestMethod.GET)
    public ResponseEntity<MathResult> calculate(@PathVariable("operation") String opr,@PathVariable("number") Float num) {
     MathResult mr = 	new MathResult();
     
     if(opr.equals("square")) {
    	 mr.setResult(new Float(num*num));	
    	 System.out.println("square");
    	 return new ResponseEntity<MathResult>(mr,HttpStatus.OK);
     	
     }else if(opr.equals("cube")) {
    	 mr.setResult(new Float(num*num*num));	
    	 System.out.println("cube");
    	 return new ResponseEntity<MathResult>(mr,HttpStatus.OK);
      	
     }
     
     
     return new ResponseEntity<MathResult>(mr,HttpStatus.OK);
     
     
    }
    
    
//    
//    @RequestMapping(value="api/v1/square",method=RequestMethod.POST)
//    public ResponseEntity<MathResult> square(@RequestParam(value="operand1") Float o1 ) {
//     MathResult mr = 	new MathResult();
//     mr.setResult(new Float(o1*o1));	
//    	return new ResponseEntity<MathResult>(mr,HttpStatus.OK);
//    }
//    
//    
//    @RequestMapping(value="api/v1/cube",method=RequestMethod.POST)
//    public ResponseEntity<MathResult> cube(@RequestParam(value="operand1") Float o1 ) {
//     MathResult mr = 	new MathResult();
//     mr.setResult(new Float(o1*o1*o1));	
//    	return new ResponseEntity<MathResult>(mr,HttpStatus.OK);
//    }
}
