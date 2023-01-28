package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetActionBarTextPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_ACTION_BAR_TEXT;

  private final PacketField<WrappedChatComponent> messageField =
      new PacketField<>(getContainer().getChatComponents(), 0);

  public ClientboundSetActionBarTextPacket() {
  }

  public ClientboundSetActionBarTextPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetActionBarTextPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setMessage(WrappedChatComponent component) {
    messageField.write(component);
  }

  public WrappedChatComponent getMessage() {
    return messageField.read();
  }

}
