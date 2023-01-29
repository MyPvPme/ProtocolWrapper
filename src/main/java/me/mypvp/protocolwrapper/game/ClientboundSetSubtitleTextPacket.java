package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetSubtitleTextPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_SUBTITLE_TEXT;

  private final PacketField<WrappedChatComponent> subtitleField = new PacketField<>(
      container().getChatComponents(), 0);

  public ClientboundSetSubtitleTextPacket() {
  }

  public ClientboundSetSubtitleTextPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetSubtitleTextPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetSubtitleTextPacket subtitle(WrappedChatComponent wrappedChatComponent) {
    subtitleField.write(wrappedChatComponent);
    return this;
  }

  public WrappedChatComponent subtitle() {
    return subtitleField.read();
  }

}
