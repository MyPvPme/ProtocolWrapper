package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundAddExperienceOrbPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SPAWN_ENTITY_EXPERIENCE_ORB;

  private final PacketField<Integer> idField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Double> xField = new PacketField<>(getContainer().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(getContainer().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(getContainer().getDoubles(), 2);
  private final PacketField<Integer> valueField = new PacketField<>(getContainer().getIntegers(), 1);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int id) {
    idField.write(id);
  }

  public int getEntityId() {
    return idField.read();
  }

  public void setX(double value) {
    xField.write(value);
  }

  public double getX() {
    return xField.read();
  }

  public void setY(double value) {
    yField.write(value);
  }

  public double getY() {
    return yField.read();
  }

  public void setZ(double value) {
    zField.write(value);
  }

  public double getZ() {
    return zField.read();
  }

  public void setValue(int value) {
    valueField.write(value);
  }

  public int getValue() {
    return valueField.read();
  }

}
