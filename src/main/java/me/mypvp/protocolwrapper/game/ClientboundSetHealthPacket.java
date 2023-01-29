package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetHealthPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.UPDATE_HEALTH;

  private final PacketField<Float> healthField = new PacketField<>(getContainer().getFloat(), 0);
  private final PacketField<Integer> foodField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Float> saturationField = new PacketField<>(getContainer().getFloat(), 1);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setHealth(float value) {
    healthField.write(value);
  }

  public float getHealth() {
    return healthField.read();
  }

  public void setSaturation(float value) {
    saturationField.write(value);
  }

  public float getSaturation() {
    return saturationField.read();
  }

  public void setFoodLevel(int value) {
    foodField.write(value);
  }

  public int getFoodLevel() {
    return foodField.read();
  }

}
