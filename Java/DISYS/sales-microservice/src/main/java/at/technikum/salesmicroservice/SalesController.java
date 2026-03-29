package at.technikum.salesmicroservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")

public class SalesController {
    @GetMapping
    public List<Sale> readAll() {
        if (Math.random() > 0.5) {
            return List.of(
                    new Sale(12345, 0.5f),
                    new Sale(5678, 0.25f),
                    new Sale(1111, 0.1f),
                    new Sale(76456, 0.9f)
            );
        }

        return List.of(
                new Sale(12345, 0.5f),
                new Sale(5678,0.25f)
        );
    }
}
