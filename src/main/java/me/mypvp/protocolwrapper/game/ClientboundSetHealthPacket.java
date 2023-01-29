package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetHealthPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.UPDATE_HEALTH;

  private final PacketField<Float> healthField = new PacketField<>(container().getFloat(), 0);
  private final PacketField<Integer> foodField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Float> saturationField = new PacketField<>(container().getFloat(), 1);

  public ClientboundSetHealthPacket() {
  }

  public ClientboundSetHealthPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetHealthPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetHealthPacket health(float value) {
    healthField.write(value);
    return this;
  }

  public float health() {
    return healthField.read();
  }

  public ClientboundSetHealthPacket saturation(float value) {
    saturationField.write(value);
    return this;
  }

  public float saturation() {
    return saturationField.read();
  }

  public ClientboundSetHealthPacket foodLevel(int value) {
    foodField.write(value);
    return this;
  }

  public int foodLevel() {
    return foodField.read();
  }

}
