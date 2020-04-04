package cemthecebi.application.model.mapper;

import cemthecebi.application.model.response.Response;
import cemthecebi.application.model.response.RetrieveTvShowListResponse;
import cemthecebi.domain.model.vo.HomePageTvShowVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetrieveTvShowListResponseMapper extends Response {

    public RetrieveTvShowListResponse map(List<HomePageTvShowVo> homePageTvShowVoList) {
        RetrieveTvShowListResponse retrieveTvShowListResponse = new RetrieveTvShowListResponse();
        retrieveTvShowListResponse.setStatus("OK");
        retrieveTvShowListResponse.setHomePageTvShowVoList(homePageTvShowVoList);
        return retrieveTvShowListResponse;
    }
}
