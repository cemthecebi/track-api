package cemthecebi.domain.service;

import cemthecebi.application.model.mapper.RetrieveTvShowListResponseMapper;
import cemthecebi.application.model.response.RetrieveTvShowListResponse;
import cemthecebi.domain.entity.TvShow;
import cemthecebi.domain.model.converter.TvShowListToHomePageTvShowVoList;
import cemthecebi.domain.model.vo.HomePageTvShowVo;
import cemthecebi.domain.repository.TvShowRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TvShowService {

    private final TvShowRepository tvShowRepository;
    private final TvShowListToHomePageTvShowVoList tvShowListToHomePageTvShowVoList;
    private final RetrieveTvShowListResponseMapper retrieveTvShowListResponseMapper;

    public TvShowService(TvShowRepository tvShowRepository,
                         TvShowListToHomePageTvShowVoList tvShowListToHomePageTvShowVoList,
                         RetrieveTvShowListResponseMapper retrieveTvShowListResponseMapper) {
        this.tvShowRepository = tvShowRepository;
        this.tvShowListToHomePageTvShowVoList = tvShowListToHomePageTvShowVoList;
        this.retrieveTvShowListResponseMapper = retrieveTvShowListResponseMapper;
    }


    public RetrieveTvShowListResponse retrieve(HttpServletRequest httpServletRequest) {
        //TODO open authentication part before production
        //String token = jwtTokenProvider.resolveToken(httpServletRequest);
        //jwtTokenProvider.validateToken(token);
        //jwtTokenProvider.getEmail(token);
        List<TvShow> tvShowList = tvShowRepository.findAll();
        List<HomePageTvShowVo> homePageTvShowVoList = tvShowListToHomePageTvShowVoList.convertToList(tvShowList);
        return retrieveTvShowListResponseMapper.map(homePageTvShowVoList);
    }
}
