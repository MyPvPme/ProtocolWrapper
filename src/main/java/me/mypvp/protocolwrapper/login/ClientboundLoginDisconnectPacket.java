package me.mypvp.protocolwrapper.login;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Login.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundLoginDisconnectPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.DISCONNECT;

  private final PacketField<WrappedChatComponent> reasonField
      = new PacketField<>(container().getChatComponents(), 0);

  public ClientboundLoginDisconnectPacket() {
  }

  public ClientboundLoginDisconnectPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundLoginDisconnectPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundLoginDisconnectPacket reason(WrappedChatComponent component) {
    reasonField.write(component);
    return this;
  }

  public WrappedChatComponent reason() {
    return reasonField.read();
  }

}
