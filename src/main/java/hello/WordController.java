package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WordController {
	
	@Autowired
	private WordService service;
	
	@GetMapping(value="/words/{word}")
	public ResponseBean getWordStatus(@PathVariable String word){
		return this.service.getWordStatus(word);
	}
}
