package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import me.mypvp.protocolwrapper.types.TeamInfoData;
import me.mypvp.protocolwrapper.types.TeamInfoData.CollisionRule;
import me.mypvp.protocolwrapper.types.TeamInfoData.Flag;
import me.mypvp.protocolwrapper.types.TeamInfoData.NameTagVisibility;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetPlayerTeamPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SCOREBOARD_TEAM;

  public enum Action {
    ACTION_ADD,
    ACTION_REMOVE,
    ACTION_UPDATE,
    ACTION_ADD_PLAYERS,
    ACTION_REMOVE_PLAYERS
  }

  public static final int MAX_VISIBILITY_LENGTH = 40;
  public static final int MAX_COLLISION_LENGTH = 40;

  private final PacketField<Integer> actionField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<String> nameField = new PacketField<>(container().getStrings(), 0);
  private final PacketField<Collection> playerNamesField =
      new PacketField<>(container().getSpecificModifier(Collection.class), 0);
  private final PacketField<Optional<InternalStructure>> parametersField
      = new PacketField<>(container().getOptionalStructures(), 0);

  public ClientboundSetPlayerTeamPacket() {
  }

  public ClientboundSetPlayerTeamPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetPlayerTeamPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetPlayerTeamPacket action(Action action) {
    actionField.write(action.ordinal());
    return this;
  }

  public Action action() {
    Integer action = actionField.read();
    if (action != null) {
      return Action.values()[action];
    }
    return null;
  }

  public ClientboundSetPlayerTeamPacket name(String name) {
    nameField.write(name);
    return this;
  }

  public String name() {
    return nameField.read();
  }

  public ClientboundSetPlayerTeamPacket playerNames(List<String> names) {
    playerNamesField.write(names);
    return this;
  }

  public List<String> playerNames() {
    return (List<String>) playerNamesField.read();
  }

  public TeamInfoData teamInfo() {
    Optional<InternalStructure> paramStructOpt = parametersField.read();
    if(!paramStructOpt.isPresent()) {
      return new TeamInfoData();
    }
    InternalStructure structure = paramStructOpt.get();
    WrappedChatComponent displayName = structure.getChatComponents().read(0);
    WrappedChatComponent playerPrefix = structure.getChatComponents().read(1);
    WrappedChatComponent playerSuffix = structure.getChatComponents().read(2);
    String nameTagVisibilityString = structure.getStrings().read(0);
    String collisionRuleString = structure.getStrings().read(1);
    ChatColor color = structure.getEnumModifier(ChatColor.class,
        MinecraftReflection.getMinecraftClass("EnumChatFormat")).read(0);
    int value = structure.getIntegers().read(0);

    List<Flag> flags = new ArrayList<>();
    if((value & 2) == 2) {
      flags.add(Flag.CAN_SEE_FRIENDLY_INVISIBLE);
    }
    if((value & 1) == 1) {
      flags.add(Flag.ALLOW_FRIENDLY_FIRE);
    }

    NameTagVisibility nameTagVisibility = null;
    for (NameTagVisibility entry : NameTagVisibility.values()) {
      if(entry.getKey().equalsIgnoreCase(nameTagVisibilityString)) {
        nameTagVisibility = entry;
        break;
      }
    }
    CollisionRule collisionRule = null;
    for (CollisionRule entry : CollisionRule.values()) {
      if(entry.getKey().equalsIgnoreCase(collisionRuleString)) {
        collisionRule = entry;
        break;
      }
    }
    return new TeamInfoData(displayName, playerPrefix, playerSuffix, nameTagVisibility,
        collisionRule, color, flags.toArray(new Flag[0]));
  }

  public void teamInfo(TeamInfoData teamInfo) {
    Optional<InternalStructure> paramStructOpt = parametersField.read();
    if(paramStructOpt.isPresent()) {

      WrappedChatComponent displayName = teamInfo.displayName();
      WrappedChatComponent playerPrefix = teamInfo.playerPrefix();
      WrappedChatComponent playerSuffix = teamInfo.playerSuffix();
      NameTagVisibility nameTagVisibility = teamInfo.nameTagVisibility();
      CollisionRule collisionRule = teamInfo.collisionRule();
      ChatColor color = teamInfo.color();
      Flag[] flags = teamInfo.flags();

      InternalStructure structure = paramStructOpt.get();
      if(displayName != null) {
        structure.getChatComponents().write(0, displayName);
      }
      if(playerPrefix != null) {
        structure.getChatComponents().write(1, playerPrefix);
      }
      if(playerSuffix != null) {
        structure.getChatComponents().write(2, playerSuffix);
      }
      if(nameTagVisibility != null) {
        structure.getStrings().write(0, nameTagVisibility.getKey());
      }
      if(collisionRule != null) {
        structure.getStrings().write(0, collisionRule.getKey());
      }
      if(color != null) {
        structure.getEnumModifier(ChatColor.class, MinecraftReflection.getMinecraftClass("EnumChatFormat"))
            .write(0, color);
      }
      if(flags != null) {
        int value = 0;
        for (Flag flag : flags) {
          if(flag == Flag.ALLOW_FRIENDLY_FIRE) {
            value |= 1;
          }
          if(flag == Flag.CAN_SEE_FRIENDLY_INVISIBLE) {
            value |= 2;
          }
        }
        structure.getIntegers().write(0, value);
      }
      parametersField.write(Optional.of(structure));
    }
  }

  public static class CreateTeamPacket extends ClientboundSetPlayerTeamPacket {

    public CreateTeamPacket(String teamName, WrappedChatComponent displayName, WrappedChatComponent prefix,
        WrappedChatComponent suffix, NameTagVisibility nameTagVisibility,
        CollisionRule collisionRule, ChatColor color, Flag[] flags, List<String> entries) {
      name(teamName);
      action(Action.ACTION_ADD);
      playerNames(entries);
      TeamInfoData data = new TeamInfoData(displayName, prefix, suffix, nameTagVisibility,
          collisionRule, color, flags);
      teamInfo(data);
    }

  }

  public static class RemoveTeamPacket extends ClientboundSetPlayerTeamPacket {

    public RemoveTeamPacket(String teamName) {
      name(teamName);
      action(Action.ACTION_REMOVE);
    }

  }

  public static class UpdateTeamPacket extends ClientboundSetPlayerTeamPacket {

    public UpdateTeamPacket(String teamName, WrappedChatComponent displayName, WrappedChatComponent prefix,
        WrappedChatComponent suffix, NameTagVisibility nameTagVisibility,
        CollisionRule collisionRule, ChatColor color, Flag[] flags) {
      name(teamName);
      action(Action.ACTION_UPDATE);
      TeamInfoData data = new TeamInfoData(displayName, prefix, suffix, nameTagVisibility,
          collisionRule, color, flags);
      teamInfo(data);
    }

  }

  public static class AddPlayerPacket extends ClientboundSetPlayerTeamPacket {

    public AddPlayerPacket(String teamName, List<String> entries) {
      name(teamName);
      action(Action.ACTION_ADD_PLAYERS);
      playerNames(entries);
    }

  }

  public static class RemovePlayerPacket extends ClientboundSetPlayerTeamPacket {

    public RemovePlayerPacket(String teamName, List<String> entries) {
      name(teamName);
      action(Action.ACTION_REMOVE_PLAYERS);
      playerNames(entries);
    }

  }
}
