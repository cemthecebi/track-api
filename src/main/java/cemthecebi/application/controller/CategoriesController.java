package cemthecebi.application.controller;

import cemthecebi.application.model.response.RetrieveCategoriesResponse;
import cemthecebi.domain.service.CategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/all")
    public RetrieveCategoriesResponse retrieve(HttpServletRequest httpServletRequest) {
        return categoriesService.retrieve(httpServletRequest);
    }
}
