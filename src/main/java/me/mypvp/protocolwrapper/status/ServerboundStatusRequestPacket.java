package me.mypvp.protocolwrapper.status;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Status.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import org.jetbrains.annotations.NotNull;

public class ServerboundStatusRequestPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.START;

  public ServerboundStatusRequestPacket() {
  }

  public ServerboundStatusRequestPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundStatusRequestPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }
}
