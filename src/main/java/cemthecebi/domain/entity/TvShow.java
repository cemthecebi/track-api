package cemthecebi.domain.entity;

import cemthecebi.domain.model.enumtype.TVShowStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class TvShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "image_link", nullable = false)
    private String imageLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "tv_show_status")
    private TVShowStatus tvShowStatus;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "trailer_link")
    private String trailerLink;

    @Column(name = "language")
    private String language;

    @OneToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

    @Column(name = "episode_count")
    private BigDecimal episodeCount;

    @Column(name = "season_count")
    private BigDecimal seasonCount;

    @Column(name = "average_episode_length")
    private BigDecimal averageEpisodeLength;

    @Column(name = "view_count")
    private BigDecimal viewCount;

    @Column(name = "follow_count")
    private BigDecimal followCount;

    @Column(name = "like_count")
    private BigDecimal likeCount;

    @Column(name = "dislike_count")
    private BigDecimal dislikeCount;

}
