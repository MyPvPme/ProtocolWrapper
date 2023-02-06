package me.mypvp.protocolwrapper.status;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Status.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundPingRequestPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.PING;

  private final PacketField<Long> timeField = new PacketField<>(container().getLongs(), 0);

  public ServerboundPingRequestPacket() {
  }

  public ServerboundPingRequestPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundPingRequestPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundPingRequestPacket startTime(long value) {
    timeField.write(value);
    return this;
  }

  public long startTime() {
    return timeField.read();
  }

}
