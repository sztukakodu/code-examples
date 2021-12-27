package pl.sztukakodu.lazyinit;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
class OrderController {

    @PostMapping
    public ResponseEntity<Object> makeAnOrder(@RequestBody @Valid OrderRequest orderRequest, Errors errors) {
        if(errors.hasErrors()) {
            return errorResponse(errors);
        }
        System.out.println("Faking order for: " + orderRequest);
        return ResponseEntity.ok("It's fine!");
    }

    private ResponseEntity<Object> errorResponse(Errors errors) {
        List<String> errorsList = errors.getAllErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();
        return ResponseEntity
            .badRequest()
            .body(new ErrorResponse(errorsList));
    }

    static record ErrorResponse(List<String> errors) {}
}
