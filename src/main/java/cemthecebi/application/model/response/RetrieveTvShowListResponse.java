package cemthecebi.application.model.response;

import cemthecebi.domain.model.vo.HomePageTvShowVo;
import lombok.Data;

import java.util.List;

@Data
public class RetrieveTvShowListResponse extends Response {

    private List<HomePageTvShowVo> homePageTvShowVoList;
}
