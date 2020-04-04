package cemthecebi.application.model.response;

import cemthecebi.domain.model.vo.CategoryVo;
import lombok.Data;

import java.util.List;

@Data
public class RetrieveCategoriesResponse extends Response {

    private List<CategoryVo> categoryVoList;
}
