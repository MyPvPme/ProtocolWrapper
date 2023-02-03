package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundPlayerLookAtPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.LOOK_AT;

  public enum Anchor {
    FEET,
    EYES
  }

  private final PacketField<Double> xField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(container().getDoubles(), 2);
  private final PacketField<Integer> entityIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Anchor> fromAnchorField = new PacketField<>(
      container().getEnumModifier(Anchor.class, 4), 0);
  private final PacketField<Anchor> toAnchorField = new PacketField<>(
      container().getEnumModifier(Anchor.class, 4), 1);
  private final PacketField<Boolean> lookAtEntityField = new PacketField<>(container().getBooleans(), 0);

  public ClientboundPlayerLookAtPacket() {
  }

  public ClientboundPlayerLookAtPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundPlayerLookAtPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundPlayerLookAtPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundPlayerLookAtPacket x(double value) {
    xField.write(value);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ClientboundPlayerLookAtPacket y(double value) {
    yField.write(value);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ClientboundPlayerLookAtPacket z(double value) {
    zField.write(value);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ClientboundPlayerLookAtPacket fromAnchor(Anchor anchor) {
    fromAnchorField.write(anchor);
    return this;
  }

  public Anchor fromAnchor() {
    return fromAnchorField.read();
  }

  public ClientboundPlayerLookAtPacket toAnchor(Anchor anchor) {
    toAnchorField.write(anchor);
    return this;
  }

  public Anchor toAnchor() {
    return toAnchorField.read();
  }

  public ClientboundPlayerLookAtPacket lookAtEntity(boolean value) {
    lookAtEntityField.write(value);
    return this;
  }

  public boolean lookAtEntity() {
    return lookAtEntityField.read();
  }


}
