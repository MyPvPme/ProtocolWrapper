package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundCommandSuggestionPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.TAB_COMPLETE;

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<String> commandField = new PacketField<>(container().getStrings(), 0);

  public ServerboundCommandSuggestionPacket() {
  }

  public ServerboundCommandSuggestionPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundCommandSuggestionPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundCommandSuggestionPacket id(int id) {
    idField.write(id);
    return this;
  }

  public int id() {
    return idField.read();
  }

  public ServerboundCommandSuggestionPacket command(String command) {
    commandField.write(command);
    return this;
  }

  public String command() {
    return commandField.read();
  }

}
