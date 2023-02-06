package me.mypvp.protocolwrapper.status;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Status.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundStatusResponsePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SERVER_INFO;

  private final PacketField<WrappedServerPing> statusField = new PacketField<>(container().getServerPings(), 0);

  public ClientboundStatusResponsePacket() {
  }

  public ClientboundStatusResponsePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundStatusResponsePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundStatusResponsePacket status(WrappedServerPing serverPing) {
    statusField.write(serverPing);
    return this;
  }

  public WrappedServerPing status() {
    return statusField.read();
  }



}
