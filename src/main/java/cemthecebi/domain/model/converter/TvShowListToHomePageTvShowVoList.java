package cemthecebi.domain.model.converter;

import cemthecebi.domain.entity.TvShow;
import cemthecebi.domain.model.vo.HomePageTvShowVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TvShowListToHomePageTvShowVoList {

    public List<HomePageTvShowVo> convertToList(List<TvShow> tvShowList) {
        return tvShowList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }


    private HomePageTvShowVo convert(TvShow tvShow) {
        HomePageTvShowVo homePageTvShowVo = new HomePageTvShowVo();
        homePageTvShowVo.setTitle(tvShow.getTitle());
        homePageTvShowVo.setImageLink(tvShow.getImageLink());
        return homePageTvShowVo;
    }
}
