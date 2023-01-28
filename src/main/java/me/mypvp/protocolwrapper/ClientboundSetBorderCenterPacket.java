package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderCenterPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_CENTER;

  private final PacketField<Double> newCenterXField = new PacketField<>(getContainer().getDoubles(), 0);
  private final PacketField<Double> newCenterZField = new PacketField<>(getContainer().getDoubles(), 1);

  public ClientboundSetBorderCenterPacket() {
  }

  public ClientboundSetBorderCenterPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetBorderCenterPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setX(double value) {
    newCenterXField.write(value);
  }

  public double getX() {
    return newCenterXField.read();
  }

  public void setZ(double value) {
    newCenterZField.write(value);
  }

  public double getZ() {
    return newCenterZField.read();
  }


}
