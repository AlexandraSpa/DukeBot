package me.AlexandraSpanache.DiscordBot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Bot bot= new Bot("ODQ1NDY0MTk4NzI4NjQ2Njk3.YKhV5A.asykNuKn_VV8-lHeA6zVInQcOus","594919529088548864","~");
        JDABuilder builder= JDABuilder.createDefault(bot.getToken());

        builder.setActivity(Activity.watching("Loading..."));
        builder.addEventListeners(new Listener(bot));
        builder.build();

    }
}
