package cemthecebi.domain.model.converter;

import cemthecebi.domain.entity.Category;
import cemthecebi.domain.model.vo.CategoryVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryListToCategoryVoList {

    public List<CategoryVo> convertToList(List<Category> categoryList) {
        return categoryList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }


    private CategoryVo convert(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setName(category.getName());
        categoryVo.setDescription(category.getDescription());
        return categoryVo;
    }
}
