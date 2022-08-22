package sit.int221.oasip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.oasip.entities.Category;
import sit.int221.oasip.repositories.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class EventCategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

}
