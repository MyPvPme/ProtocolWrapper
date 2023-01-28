package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderSizePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_SIZE;

  private final PacketField<Double> sizeField = new PacketField<>(getContainer().getDoubles(), 0);

  public ClientboundSetBorderSizePacket() {
  }

  public ClientboundSetBorderSizePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetBorderSizePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setSize(double size) {
    sizeField.write(size);
  }

  public double getSize() {
    return sizeField.read();
  }

}
