package me.AlexandraSpanache.DiscordBot;

public class Bot {
    private String token;
    private String ownerId;
    private String prefix;

    public Bot(String token, String ownerId, String prefix) {
        this.token = token;
        this.ownerId = ownerId;
        this.prefix = prefix;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
