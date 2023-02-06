package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundPingPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.PING;

  private final PacketField<Integer> parameterField = new PacketField<>(container().getIntegers(), 0);

  public ClientboundPingPacket() {
  }

  public ClientboundPingPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundPingPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundPingPacket parameter(int param) {
    parameterField.write(param);
    return this;
  }

  public int parameter() {
    return parameterField.read();
  }

}
