package cemthecebi.application.controller;

import cemthecebi.application.model.response.RetrieveTvShowListResponse;
import cemthecebi.domain.service.TvShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tvshow")
public class TvShowController {

    private final TvShowService tvShowService;

    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping("/all")
    public RetrieveTvShowListResponse retrieve(HttpServletRequest httpServletRequest) {
        return tvShowService.retrieve(httpServletRequest);
    }
}
