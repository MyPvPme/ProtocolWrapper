package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetTitleTextPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_TITLE_TEXT;

  private final PacketField<WrappedChatComponent> titleField = new PacketField<>(
      container().getChatComponents(), 0);

  public ClientboundSetTitleTextPacket() {
  }

  public ClientboundSetTitleTextPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetTitleTextPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetTitleTextPacket title(WrappedChatComponent wrappedChatComponent) {
    titleField.write(wrappedChatComponent);
    return this;
  }

  public WrappedChatComponent title() {
    return titleField.read();
  }

}
