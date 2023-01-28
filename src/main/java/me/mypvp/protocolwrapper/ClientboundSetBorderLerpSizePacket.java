package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderLerpSizePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_LERP_SIZE;

  private final PacketField<Double> oldSizeField = new PacketField<>(getContainer().getDoubles(), 0);
  private final PacketField<Double> newSizeField = new PacketField<>(getContainer().getDoubles(), 1);
  private final PacketField<Long> lerpTimeField = new PacketField<>(getContainer().getLongs(), 0);

  public ClientboundSetBorderLerpSizePacket() {
  }

  public ClientboundSetBorderLerpSizePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetBorderLerpSizePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setOldSize(double size) {
    oldSizeField.write(size);
  }

  public double getOldSize() {
    return oldSizeField.read();
  }

  public void setNewSize(double size) {
    newSizeField.write(size);
  }

  public double getNewSize() {
    return newSizeField.read();
  }

  public void setLerpTime(long time) {
    lerpTimeField.write(time);
  }

  public long getLerpTime() {
    return lerpTimeField.read();
  }

}
