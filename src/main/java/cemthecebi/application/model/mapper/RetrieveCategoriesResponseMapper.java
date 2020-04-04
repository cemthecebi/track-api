package cemthecebi.application.model.mapper;

import cemthecebi.application.model.response.Response;
import cemthecebi.application.model.response.RetrieveCategoriesResponse;
import cemthecebi.domain.model.vo.CategoryVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveCategoriesResponseMapper extends Response {

    public RetrieveCategoriesResponse map(List<CategoryVo> categoryVoList) {
        RetrieveCategoriesResponse retrieveCategoriesResponse = new RetrieveCategoriesResponse();

        retrieveCategoriesResponse.setCategoryVoList(categoryVoList);
        retrieveCategoriesResponse.setStatus("OK");
        return retrieveCategoriesResponse;
    }
}
