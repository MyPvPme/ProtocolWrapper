package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundClientCommandPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.CLIENT_COMMAND;

  public enum Action {
    PERFORM_RESPAWN,
    REQUEST_STATS
  }

  private final PacketField<Action> actionField = new PacketField<>(
      container().getEnumModifier(Action.class, 0), 0);

  public ServerboundClientCommandPacket() {
  }

  public ServerboundClientCommandPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundClientCommandPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundClientCommandPacket action(Action action) {
    actionField.write(action);
    return this;
  }

  public Action action() {
    return actionField.read();
  }

}
