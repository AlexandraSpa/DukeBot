package me.AlexandraSpanache.DiscordBot.CommandBuilders.Commands;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;

public class RSSFeedReader {
    private SyndFeed feed;
    public void setFeed(String url) throws IOException, FeedException {
        URL feedURL = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        this.feed= input.build(new XmlReader(feedURL));
    }
    public SyndEntry getContent(){
        return feed.getEntries().get(0);
    }
}
