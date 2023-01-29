package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderCenterPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_CENTER;

  private final PacketField<Double> newCenterXField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> newCenterZField = new PacketField<>(container().getDoubles(), 1);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetBorderCenterPacket x(double value) {
    newCenterXField.write(value);
    return this;
  }

  public double x() {
    return newCenterXField.read();
  }

  public ClientboundSetBorderCenterPacket z(double value) {
    newCenterZField.write(value);
    return this;
  }

  public double z() {
    return newCenterZField.read();
  }


}
