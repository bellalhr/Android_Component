package io.destreza.android_component.SQLiteDatabase;

public class Players {
    private String playerName;
    private String playerType;
    private String playerAge;

    public Players(String playerName, String playerType, String playerAge) {
        this.playerName = playerName;
        this.playerType = playerType;
        this.playerAge = playerAge;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(String playerAge) {
        this.playerAge = playerAge;
    }
}
