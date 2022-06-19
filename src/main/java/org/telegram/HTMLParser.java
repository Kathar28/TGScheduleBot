package org.telegram;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class HTMLParser {

    public String ConvertPage(String SiteUrl) throws IOException {
        Document document = Jsoup.connect(SiteUrl).get();
        Elements Tags = document.getElementsByTag("p");
        String UrlFile = Tags.get(11).getElementsByAttribute("href").attr("href");
        return UrlFile;
    }
    public void LoadFile(String UrlFile) throws IOException {
        URI website = URI.create(ConvertPage(UrlFile));
        try (InputStream in = website.toURL().openStream()){
            Files.copy(in, (new File("src/main/resources/Schedule.xlsx").toPath()),StandardCopyOption.REPLACE_EXISTING);
        }

    }

}
