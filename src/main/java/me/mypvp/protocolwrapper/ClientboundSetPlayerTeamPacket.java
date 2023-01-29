package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

  private final PacketField<Integer> actionField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<String> nameField = new PacketField<>(getContainer().getStrings(), 0);
  private final PacketField<Collection> playerNamesField =
      new PacketField<>(getContainer().getSpecificModifier(Collection.class), 0);
  private final PacketField<Optional<InternalStructure>> parametersField
      = new PacketField<>(getContainer().getOptionalStructures(), 0);

  public ClientboundSetPlayerTeamPacket() {}

  public ClientboundSetPlayerTeamPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetPlayerTeamPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setAction(Action action) {
    int value;
    switch (action) {
      case ACTION_ADD:
        value = 0;
        break;
      case ACTION_REMOVE:
        value = 1;
        break;
      case ACTION_UPDATE:
        value = 2;
        break;
      case ACTION_ADD_PLAYERS:
        value = 3;
        break;
      case ACTION_REMOVE_PLAYERS:
        value = 4;
        break;
      default:
        return;
    }
    actionField.write(value);
  }

  public Action getAction() {
    int action = actionField.read();
    switch (action) {
      case 0:
        return Action.ACTION_ADD;
      case 1:
        return Action.ACTION_REMOVE;
      case 2:
        return Action.ACTION_UPDATE;
      case 3:
        return Action.ACTION_ADD_PLAYERS;
      case 4:
        return Action.ACTION_REMOVE_PLAYERS;
      default:
        return null;
    }
  }

  public void setName(String name) {
    nameField.write(name);
  }

  public String getName() {
    return nameField.read();
  }

  public void setPlayerNames(List<String> names) {
    playerNamesField.write(names);
  }

  public List<String> getPlayerNames() {
    return (List<String>) playerNamesField.read();
  }

  public TeamInfoData getTeamInfo() {
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

  public void setTeamInfo(TeamInfoData teamInfo) {
    Optional<InternalStructure> paramStructOpt = parametersField.read();
    if(paramStructOpt.isPresent()) {

      WrappedChatComponent displayName = teamInfo.getDisplayName();
      WrappedChatComponent playerPrefix = teamInfo.getPlayerPrefix();
      WrappedChatComponent playerSuffix = teamInfo.getPlayerSuffix();
      NameTagVisibility nameTagVisibility = teamInfo.getNameTagVisibility();
      CollisionRule collisionRule = teamInfo.getCollisionRule();
      ChatColor color = teamInfo.getColor();
      Flag[] flags = teamInfo.getFlags();

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

}
