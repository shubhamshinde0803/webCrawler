package srs.scraping;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProcessingThread implements Runnable{

    Document siteHtml = null;
    public ProcessingThread(Document siteHtml){
        this.siteHtml = siteHtml;
    }

    @Override
    public void run() {
        try{
            long startTime = System.currentTimeMillis();
            Element contentDiv = siteHtml.selectFirst("div.blog-post-body__content");
            if(contentDiv != null)
                processUrl(contentDiv);
            else
                System.out.println("Content div not found");
            long endTime = System.currentTimeMillis();
            System.out.printf("Time taken: %.2f seconds%n", (endTime - startTime) / 1000.0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void processUrl(Element mainElement){
        Elements tags = mainElement.select("a");
        for (Element item : tags) {
            String href = item.attr("href");
            String title = item.text();
            System.out.println("Title: " + title + "\tsite link: " + href);
        }
    }
}
