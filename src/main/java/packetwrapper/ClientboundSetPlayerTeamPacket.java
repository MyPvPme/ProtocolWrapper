package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

  public enum NameTagVisibility {
    ALWAYS("always"),
    HIDE_FOR_OTHER_TEAMS("hideForOtherTeams"),
    HIDE_FOR_OWN_TEAMS("hideForOwnTeam"),
    NEVER("never");

    private final String key;

    NameTagVisibility(String key) {
      this.key = key;
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
  }

  public enum Flag {
    ALLOW_FRIENDLY_FIRE,
    CAN_SEE_FRIENDLY_INVISIBLE
  }

  public static class Parameters {
    public WrappedChatComponent displayName;
    public WrappedChatComponent playerPrefix;
    public WrappedChatComponent playerSuffix;
    public NameTagVisibility nameTagVisibility;
    public CollisionRule collisionRule;
    public ChatColor color;
    public Flag[] flags;
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

  public void setParameters(Parameters parameters) {
    Optional<InternalStructure> paramStructOpt = parametersField.read();
    if(paramStructOpt.isPresent()) {

      WrappedChatComponent displayName = parameters.displayName;
      WrappedChatComponent playerPrefix = parameters.playerPrefix;
      WrappedChatComponent playerSuffix = parameters.playerSuffix;
      NameTagVisibility nameTagVisibility = parameters.nameTagVisibility;
      CollisionRule collisionRule = parameters.collisionRule;
      ChatColor color = parameters.color;
      Flag[] flags = parameters.flags;

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
        structure.getStrings().write(0, nameTagVisibility.key);
      }
      if(collisionRule != null) {
        structure.getStrings().write(0, collisionRule.key);
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
