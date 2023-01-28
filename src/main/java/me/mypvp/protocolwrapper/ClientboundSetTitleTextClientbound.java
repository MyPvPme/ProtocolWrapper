package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetTitleTextClientbound extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_TITLE_TEXT;

  private final PacketField<WrappedChatComponent> titleField = new PacketField<>(
      getContainer().getChatComponents(), 0);

  public ClientboundSetTitleTextClientbound() {
  }

  public ClientboundSetTitleTextClientbound(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetTitleTextClientbound(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setTitle(WrappedChatComponent wrappedChatComponent) {
    titleField.write(wrappedChatComponent);
  }

  public WrappedChatComponent getTitle() {
    return titleField.read();
  }

}
