package srs.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.fantasybookreview.co.uk/top-100-fantasy-books/";
        try{
            Document document = Jsoup.connect(url).get();
            Elements bookElements = document.select("h2");
            int count = 10;
            for(Element book : bookElements){
                Element link = book.selectFirst("a");
                if(link != null){
                    count--;
                    String title = link.text();
                    System.out.println("title: " + title);
                    if(count == 0)
                        break;
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}