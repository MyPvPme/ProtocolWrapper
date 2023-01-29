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

  public TeamInfoData(TeamInfoData data) {
    this.displayName = data.displayName;
    this.playerPrefix = data.playerPrefix;
    this.playerSuffix = data.playerSuffix;
    this.nameTagVisibility = data.nameTagVisibility;
    this.collisionRule = data.collisionRule;
    this.color = data.color;
    this.flags = data.flags;
  }

  public WrappedChatComponent displayName() {
    return displayName;
  }

  public TeamInfoData displayName(WrappedChatComponent displayName) {
    this.displayName = displayName;
    return this;
  }

  public WrappedChatComponent playerPrefix() {
    return playerPrefix;
  }

  public TeamInfoData playerPrefix(WrappedChatComponent playerPrefix) {
    this.playerPrefix = playerPrefix;
    return this;
  }

  public WrappedChatComponent playerSuffix() {
    return playerSuffix;
  }

  public TeamInfoData playerSuffix(WrappedChatComponent playerSuffix) {
    this.playerSuffix = playerSuffix;
    return this;
  }

  public NameTagVisibility nameTagVisibility() {
    return nameTagVisibility;
  }

  public TeamInfoData nameTagVisibility(NameTagVisibility nameTagVisibility) {
    this.nameTagVisibility = nameTagVisibility;
    return this;
  }

  public CollisionRule collisionRule() {
    return collisionRule;
  }

  public TeamInfoData collisionRule(CollisionRule collisionRule) {
    this.collisionRule = collisionRule;
    return this;
  }

  public ChatColor color() {
    return color;
  }

  public TeamInfoData color(ChatColor color) {
    this.color = color;
    return this;
  }

  public Flag[] flags() {
    return flags;
  }

  public TeamInfoData flags(Flag[] flags) {
    this.flags = flags;
    return this;
  }

}
