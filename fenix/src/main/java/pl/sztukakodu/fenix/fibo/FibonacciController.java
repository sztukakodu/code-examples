package pl.sztukakodu.fenix.fibo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibo")
class FibonacciController {

    @GetMapping("/{number}")
    public Long compute(@PathVariable Long number) {
        return calculate(number);
    }

    private Long calculate(Long number) {
        if(number < 2) {
            return 1L;
        }
        return calculate(number - 1) + calculate(number - 2);
    }

}
