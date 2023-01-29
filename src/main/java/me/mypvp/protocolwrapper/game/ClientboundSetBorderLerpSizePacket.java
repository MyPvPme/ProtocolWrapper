package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderLerpSizePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_LERP_SIZE;

  private final PacketField<Double> oldSizeField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> newSizeField = new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Long> lerpTimeField = new PacketField<>(container().getLongs(), 0);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetBorderLerpSizePacket oldSize(double size) {
    oldSizeField.write(size);
    return this;
  }

  public double oldSize() {
    return oldSizeField.read();
  }

  public ClientboundSetBorderLerpSizePacket newSize(double size) {
    newSizeField.write(size);
    return this;
  }

  public double newSize() {
    return newSizeField.read();
  }

  public ClientboundSetBorderLerpSizePacket lerpTime(long time) {
    lerpTimeField.write(time);
    return this;
  }

  public long lerpTime() {
    return lerpTimeField.read();
  }

}
