package fr.esilv.s8.youtubesearch.models;



        import com.google.gson.annotations.SerializedName;

        import java.io.Serializable;
        import java.util.List;

/**
 * Created by Salem on 21/03/2017.
 */

public class VideoResponse {

    /**
     * kind : youtube#searchListResponse
     * etag : "uQc-MPTsstrHkQcRXL3IWLmeNsM/g0JhzZyhiTXe9HGG5EV08hCSDZw"
     * nextPageToken : CAIQAA
     * regionCode : FR
     * pageInfo : {"totalResults":1000000,"resultsPerPage":2}
     * items : [{"kind":"youtube#searchResult","etag":"\"uQc-MPTsstrHkQcRXL3IWLmeNsM/ZWWpct7CLelELWlfIvRZj5eDtoI\"","id":{"kind":"youtube#video","videoId":"q5l9Vq2CKdg"},"snippet":{"publishedAt":"2017-03-18T18:53:03.000Z","channelId":"UCe_vXdMrHHseZ_esYUskSBw","title":"8 Kitchen Gadgets Put to the Test","description":"1 BambooBread Slicer - http://amzn.to/2nlAusS 2 Hot Dog Dicer - http://amzn.to/2nDvCwk 3 Strawberry Huller - http://amzn.to/2nDr1du 4 Grape and Tomato ...","thumbnails":{"default":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/default.jpg","width":120,"height":90},"medium":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/mqdefault.jpg","width":320,"height":180},"high":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/hqdefault.jpg","width":480,"height":360}},"channelTitle":"CrazyRussianHacker","liveBroadcastContent":"none"}},{"kind":"youtube#searchResult","etag":"\"uQc-MPTsstrHkQcRXL3IWLmeNsM/MLG98kGQZs_8JKC5jjIsNfVYzD8\"","id":{"kind":"youtube#video","videoId":"IC4ANBT22wY"},"snippet":{"publishedAt":"2017-03-20T16:30:01.000Z","channelId":"UCTafEJoRl5myC8A50plIrng","title":"Qui arrivera à passer ce test d'attention ?","description":"Déroulez la description il y a de bonnes infos *** Les 4 #ImpossibleChallenge : https://goo.gl/mDNvm1 Vidéo de l'attention sélective de BrainDayProject ...","thumbnails":{"default":{"url":"https://i.ytimg.com/vi/IC4ANBT22wY/default.jpg","width":120,"height":90},"medium":{"url":"https://i.ytimg.com/vi/IC4ANBT22wY/mqdefault.jpg","width":320,"height":180},"high":{"url":"https://i.ytimg.com/vi/IC4ANBT22wY/hqdefault.jpg","width":480,"height":360}},"channelTitle":"FabienOlicard","liveBroadcastContent":"none"}}]
     */

    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfoBean pageInfo;
    private List<ItemsBean> items;

    public VideoResponse(){

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class PageInfoBean {
        /**
         * totalResults : 1000000
         * resultsPerPage : 2
         */

        private int totalResults;
        private int resultsPerPage;

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public int getResultsPerPage() {
            return resultsPerPage;
        }

        public void setResultsPerPage(int resultsPerPage) {
            this.resultsPerPage = resultsPerPage;
        }
    }

    public static class ItemsBean implements Serializable{
        /**
         * kind : youtube#searchResult
         * etag : "uQc-MPTsstrHkQcRXL3IWLmeNsM/ZWWpct7CLelELWlfIvRZj5eDtoI"
         * id : {"kind":"youtube#video","videoId":"q5l9Vq2CKdg"}
         * snippet : {"publishedAt":"2017-03-18T18:53:03.000Z","channelId":"UCe_vXdMrHHseZ_esYUskSBw","title":"8 Kitchen Gadgets Put to the Test","description":"1 BambooBread Slicer - http://amzn.to/2nlAusS 2 Hot Dog Dicer - http://amzn.to/2nDvCwk 3 Strawberry Huller - http://amzn.to/2nDr1du 4 Grape and Tomato ...","thumbnails":{"default":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/default.jpg","width":120,"height":90},"medium":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/mqdefault.jpg","width":320,"height":180},"high":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/hqdefault.jpg","width":480,"height":360}},"channelTitle":"CrazyRussianHacker","liveBroadcastContent":"none"}
         */

        private String kind;
        private String etag;
        private IdBean id;
        private SnippetBean snippet;
        private int mData;

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getEtag() {
            return etag;
        }

        public void setEtag(String etag) {
            this.etag = etag;
        }

        public IdBean getId() {
            return id;
        }

        public void setId(IdBean id) {
            this.id = id;
        }

        public SnippetBean getSnippet() {
            return snippet;
        }

        public void setSnippet(SnippetBean snippet) {
            this.snippet = snippet;
        }

        public static class IdBean  implements Serializable{
            /**
             * kind : youtube#video
             * videoId : q5l9Vq2CKdg
             */

            private String kind;
            private String videoId;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }
        }

        public static class SnippetBean  implements Serializable {
            /**
             * publishedAt : 2017-03-18T18:53:03.000Z
             * channelId : UCe_vXdMrHHseZ_esYUskSBw
             * title : 8 Kitchen Gadgets Put to the Test
             * description : 1 BambooBread Slicer - http://amzn.to/2nlAusS 2 Hot Dog Dicer - http://amzn.to/2nDvCwk 3 Strawberry Huller - http://amzn.to/2nDr1du 4 Grape and Tomato ...
             * thumbnails : {"default":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/default.jpg","width":120,"height":90},"medium":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/mqdefault.jpg","width":320,"height":180},"high":{"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/hqdefault.jpg","width":480,"height":360}}
             * channelTitle : CrazyRussianHacker
             * liveBroadcastContent : none
             */

            private String publishedAt;
            private String channelId;
            private String title;
            private String description;
            private ThumbnailsBean thumbnails;
            private String channelTitle;
            private String liveBroadcastContent;

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getChannelId() {
                return channelId;
            }

            public void setChannelId(String channelId) {
                this.channelId = channelId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public ThumbnailsBean getThumbnails() {
                return thumbnails;
            }

            public void setThumbnails(ThumbnailsBean thumbnails) {
                this.thumbnails = thumbnails;
            }

            public String getChannelTitle() {
                return channelTitle;
            }

            public void setChannelTitle(String channelTitle) {
                this.channelTitle = channelTitle;
            }

            public String getLiveBroadcastContent() {
                return liveBroadcastContent;
            }

            public void setLiveBroadcastContent(String liveBroadcastContent) {
                this.liveBroadcastContent = liveBroadcastContent;
            }

            public static class ThumbnailsBean  implements Serializable {

                /**
                 * default : {"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/default.jpg","width":120,"height":90}
                 * medium : {"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/mqdefault.jpg","width":320,"height":180}
                 * high : {"url":"https://i.ytimg.com/vi/q5l9Vq2CKdg/hqdefault.jpg","width":480,"height":360}
                 */

                @SerializedName("default")
                private DefaultBean defaultX;
                private MediumBean medium;
                private HighBean high;

                public DefaultBean getDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(DefaultBean defaultX) {
                    this.defaultX = defaultX;
                }

                public MediumBean getMedium() {
                    return medium;
                }

                public void setMedium(MediumBean medium) {
                    this.medium = medium;
                }

                public HighBean getHigh() {
                    return high;
                }

                public void setHigh(HighBean high) {
                    this.high = high;
                }

                public static class DefaultBean  implements Serializable {
                    /**
                     * url : https://i.ytimg.com/vi/q5l9Vq2CKdg/default.jpg
                     * width : 120
                     * height : 90
                     */

                    private String url;
                    private int width;
                    private int height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                }

                public static class MediumBean  implements Serializable {
                    /**
                     * url : https://i.ytimg.com/vi/q5l9Vq2CKdg/mqdefault.jpg
                     * width : 320
                     * height : 180
                     */

                    private String url;
                    private int width;
                    private int height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                }

                public static class HighBean  implements Serializable {
                    /**
                     * url : https://i.ytimg.com/vi/q5l9Vq2CKdg/hqdefault.jpg
                     * width : 480
                     * height : 360
                     */

                    private String url;
                    private int width;
                    private int height;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                }
            }
        }
    }
}
