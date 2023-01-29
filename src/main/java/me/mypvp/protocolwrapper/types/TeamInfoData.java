package me.mypvp.protocolwrapper.types;

import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.ChatColor;

public class TeamInfoData {

  public enum NameTagVisibility {
    ALWAYS("always"),
    HIDE_FOR_OTHER_TEAMS("hideForOtherTeams"),
    HIDE_FOR_OWN_TEAMS("hideForOwnTeam"),
    NEVER("never");

    private final String key;

    NameTagVisibility(String key) {
      this.key = key;
    }

    public String getKey() {
      return key;
    }
  }

  public enum CollisionRule {
    ALWAYS("always"),
    PUSH_OTHER_TEAMS("pushOtherTeams"),
    PUSH_OWN_TEAM("pushOwnTeam"),
    NEVER("never");

    private final String key;

    CollisionRule(String key) {
      this.key = key;
    }

    public String getKey() {
      return key;
    }
  }

  public enum Flag {
    ALLOW_FRIENDLY_FIRE,
    CAN_SEE_FRIENDLY_INVISIBLE
  }

  private WrappedChatComponent displayName;
  private WrappedChatComponent playerPrefix;
  private WrappedChatComponent playerSuffix;
  private NameTagVisibility nameTagVisibility;
  private CollisionRule collisionRule;
  private ChatColor color;
  private Flag[] flags;

  public TeamInfoData() {
  }

  public TeamInfoData(WrappedChatComponent displayName, WrappedChatComponent playerPrefix,
      WrappedChatComponent playerSuffix, NameTagVisibility nameTagVisibility, CollisionRule collisionRule,
      ChatColor color, Flag[] flags) {
    this.displayName = displayName;
    this.playerPrefix = playerPrefix;
    this.playerSuffix = playerSuffix;
    this.nameTagVisibility = nameTagVisibility;
    this.collisionRule = collisionRule;
    this.color = color;
    this.flags = flags;
  }

  public WrappedChatComponent getDisplayName() {
    return displayName;
  }

  public void setDisplayName(WrappedChatComponent displayName) {
    this.displayName = displayName;
  }

  public WrappedChatComponent getPlayerPrefix() {
    return playerPrefix;
  }

  public void setPlayerPrefix(WrappedChatComponent playerPrefix) {
    this.playerPrefix = playerPrefix;
  }

  public WrappedChatComponent getPlayerSuffix() {
    return playerSuffix;
  }

  public void setPlayerSuffix(WrappedChatComponent playerSuffix) {
    this.playerSuffix = playerSuffix;
  }

  public NameTagVisibility getNameTagVisibility() {
    return nameTagVisibility;
  }

  public void setNameTagVisibility(NameTagVisibility nameTagVisibility) {
    this.nameTagVisibility = nameTagVisibility;
  }

  public CollisionRule getCollisionRule() {
    return collisionRule;
  }

  public void setCollisionRule(CollisionRule collisionRule) {
    this.collisionRule = collisionRule;
  }

  public ChatColor getColor() {
    return color;
  }

  public void setColor(ChatColor color) {
    this.color = color;
  }

  public Flag[] getFlags() {
    return flags;
  }

  public void setFlags(Flag[] flags) {
    this.flags = flags;
  }

}
