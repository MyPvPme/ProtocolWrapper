package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetObjectivePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SCOREBOARD_OBJECTIVE;

  private final PacketField<String> nameField = new PacketField<>(container().getStrings(), 0);
  private final PacketField<WrappedChatComponent> displayNameField
      = new PacketField<>(container().getChatComponents(), 0);
  private final PacketField<HealthDisplay> healthDisplayField = new PacketField<>(
      container().getEnumModifier(HealthDisplay.class, 2), 0);
  private final PacketField<Integer> actionField = new PacketField<>(container().getIntegers(), 0);

  public enum HealthDisplay {
    INTEGER,
    HEARTS
  }

  public enum Action {
    ADD,
    REMOVE,
    UPDATE
  }

  public ClientboundSetObjectivePacket() {
  }

  public ClientboundSetObjectivePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetObjectivePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetObjectivePacket name(String name) {
    nameField.write(name);
    return this;
  }

  public String name() {
    return nameField.read();
  }

  public ClientboundSetObjectivePacket displayName(WrappedChatComponent displayName) {
    displayNameField.write(displayName);
    return this;
  }

  public WrappedChatComponent displayName() {
    return displayNameField.read();
  }

  public ClientboundSetObjectivePacket healthDisplay(HealthDisplay healthDisplay) {
    healthDisplayField.write(healthDisplay);
    return this;
  }

  public HealthDisplay healthDisplay() {
    return healthDisplayField.read();
  }

  public ClientboundSetObjectivePacket action(Action action) {
    actionField.write(action.ordinal());
    return this;
  }

  public Action action() {
    return Action.values()[actionField.read()];
  }

}
