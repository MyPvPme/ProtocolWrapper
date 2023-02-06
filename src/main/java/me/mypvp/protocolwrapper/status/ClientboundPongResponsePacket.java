package me.mypvp.protocolwrapper.status;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Status.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundPongResponsePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.PONG;

  private final PacketField<Long> startTimeField = new PacketField<>(container().getLongs(), 0);

  public ClientboundPongResponsePacket() {
  }

  public ClientboundPongResponsePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundPongResponsePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundPongResponsePacket startTime(long time) {
    startTimeField.write(time);
    return this;
  }

  public long startTime() {
    return startTimeField.read();
  }

}
