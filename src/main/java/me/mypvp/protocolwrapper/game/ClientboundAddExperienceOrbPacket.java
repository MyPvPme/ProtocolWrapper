package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundAddExperienceOrbPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SPAWN_ENTITY_EXPERIENCE_ORB;

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Double> xField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(container().getDoubles(), 2);
  private final PacketField<Integer> valueField = new PacketField<>(container().getIntegers(), 1);

  public ClientboundAddExperienceOrbPacket() {

  }

  public ClientboundAddExperienceOrbPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundAddExperienceOrbPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundAddExperienceOrbPacket entityId(int id) {
    idField.write(id);
    return this;
  }

  public int entityId() {
    return idField.read();
  }

  public ClientboundAddExperienceOrbPacket x(double value) {
    xField.write(value);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ClientboundAddExperienceOrbPacket y(double value) {
    yField.write(value);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ClientboundAddExperienceOrbPacket z(double value) {
    zField.write(value);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ClientboundAddExperienceOrbPacket value(int value) {
    valueField.write(value);
    return this;
  }

  public int value() {
    return valueField.read();
  }

}
