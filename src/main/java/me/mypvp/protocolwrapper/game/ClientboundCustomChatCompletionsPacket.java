package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.Converters;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundCustomChatCompletionsPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.CUSTOM_CHAT_COMPLETIONS;

  public enum Action {
    ADD,
    REMOVE,
    SET
  }

  private final PacketField<Action> actionField = new PacketField<>(
      container().getEnumModifier(Action.class, 0), 0);
  private final PacketField<List<String>> entriesField = new PacketField<>(
      container().getLists(Converters.passthrough(String.class)), 0);

  public ClientboundCustomChatCompletionsPacket() {
  }

  public ClientboundCustomChatCompletionsPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundCustomChatCompletionsPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundCustomChatCompletionsPacket action(Action action) {
    actionField.write(action);
    return this;
  }

  public Action action() {
    return actionField.read();
  }

  public ClientboundCustomChatCompletionsPacket entries(List<String> entries) {
    entriesField.write(entries);
    return this;
  }

  public List<String> entries() {
    return entriesField.read();
  }

}
