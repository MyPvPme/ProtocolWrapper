package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.mojang.brigadier.suggestion.Suggestions;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundCommandSuggestionsPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.TAB_COMPLETE;

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Suggestions> suggestionsField = new PacketField<>(container().getModifier().withType(
      Suggestions.class), 0);

  public ClientboundCommandSuggestionsPacket() {
  }

  public ClientboundCommandSuggestionsPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundCommandSuggestionsPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundCommandSuggestionsPacket id(int id) {
    idField.write(id);
    return this;
  }

  public int id() {
    return idField.read();
  }

  public ClientboundCommandSuggestionsPacket suggestions(Suggestions suggestions) {
    suggestionsField.write(suggestions);
    return this;
  }

  public Suggestions suggestions() {
    return suggestionsField.read();
  }

}
