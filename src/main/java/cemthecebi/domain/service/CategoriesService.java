package cemthecebi.domain.service;

import cemthecebi.application.model.mapper.RetrieveCategoryListResponseMapper;
import cemthecebi.application.model.response.RetrieveCategoriesResponse;
import cemthecebi.domain.entity.Category;
import cemthecebi.domain.model.converter.CategoryListToCategoryVoList;
import cemthecebi.domain.model.vo.CategoryVo;
import cemthecebi.domain.repository.CategoryRepository;
import cemthecebi.infrastructure.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CategoriesService {

    private final JwtTokenProvider jwtTokenProvider;
    private final CategoryRepository categoryRepository;
    private final CategoryListToCategoryVoList categoryListToCategoryVoList;
    private final RetrieveCategoryListResponseMapper retrieveCategoryListResponseMapper;

    public CategoriesService(JwtTokenProvider jwtTokenProvider,
                             CategoryRepository categoryRepository,
                             CategoryListToCategoryVoList categoryListToCategoryVoList,
                             RetrieveCategoryListResponseMapper retrieveCategoryListResponseMapper) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.categoryRepository = categoryRepository;
        this.categoryListToCategoryVoList = categoryListToCategoryVoList;
        this.retrieveCategoryListResponseMapper = retrieveCategoryListResponseMapper;
    }

    public RetrieveCategoriesResponse retrieve(HttpServletRequest httpServletRequest) {
        //TODO open authentication part before production
        //String token = jwtTokenProvider.resolveToken(httpServletRequest);
        //jwtTokenProvider.validateToken(token);
        //jwtTokenProvider.getEmail(token);
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryVo> categoryVoList = categoryListToCategoryVoList.convertToList(categoryList);
        return retrieveCategoryListResponseMapper.map(categoryVoList);
    }
}
