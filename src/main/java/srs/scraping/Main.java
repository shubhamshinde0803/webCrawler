package srs.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.bestsellerbookreviews.com/blog/the-25-best-book-reviewing-websites";
        try{
            Document document = Jsoup.connect(url).get();
            Thread pThread = new Thread(new ProcessingThread(document));
            pThread.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}