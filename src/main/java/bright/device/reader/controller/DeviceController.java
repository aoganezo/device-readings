package bright.device.reader.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
public class DeviceController {
	
	/**
	 * A temporary controller
	 * 
	 * @return ResponseEntity(null, HTTPStatus)
	 */
	@GetMapping
	public ResponseEntity<?> getResponse() throws Exception {
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}