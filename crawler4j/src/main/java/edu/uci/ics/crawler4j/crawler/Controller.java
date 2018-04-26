package edu.uci.ics.crawler4j.crawler;

import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
    public static void main(String[] args) throws Exception {
        //爬行的存储文件
        String crawlStorageFolder = "d:/data/";
        //爬去文件的Crawler个数
        int numberOfCrawlers = 7;

        //将文件的下载存储配置文件配置在统一的配置中
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        //抓取的最大的深度
        config.setMaxDepthOfCrawling(7);
        //抓取的组大的数量
        config.setMaxPagesToFetch(1);
        /*
         * Instantiate the controller for this crawl.
         * 为这个爬虫实例实例化控制器。
         */
        //加载配置文件的文在下载信息
        PageFetcher pageFetcher = new PageFetcher(config);
        //
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);


        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("http://www.gg2017.cn");
       /* controller.addSeed("http://www.ics.uci.edu/~lopes/");
        controller.addSeed("http://www.ics.uci.edu/~welling/");
        controller.addSeed("http://www.ics.uci.edu/");*/

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(MyCrawler.class, numberOfCrawlers);
        System.out.println("11111111111111111111111");
    }

}
