package daw.dwes._6.exceptions;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

public class ApiExceptions extends ResponseStatusException {
	private static final long serialVersionUID = 1L;
	
	public ApiExceptions(HttpStatus status, String message) {
        super(status, message);
    }

}
