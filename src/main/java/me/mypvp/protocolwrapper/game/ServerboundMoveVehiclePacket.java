package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundMoveVehiclePacket extends AbstractPacket {

  public static final PacketType TYPE = Client.VEHICLE_MOVE;

  private final PacketField<Double> xField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(container().getDoubles(), 2);
  private final PacketField<Float> yawField = new PacketField<>(container().getFloat(), 0);
  private final PacketField<Float> pitchField = new PacketField<>(container().getFloat(), 1);

  public ServerboundMoveVehiclePacket() {
  }

  public ServerboundMoveVehiclePacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundMoveVehiclePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundMoveVehiclePacket x(double x) {
    xField.write(x);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ServerboundMoveVehiclePacket y(double y) {
    yField.write(y);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ServerboundMoveVehiclePacket z(double z) {
    zField.write(z);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ServerboundMoveVehiclePacket yaw(float yaw) {
    yawField.write(yaw);
    return this;
  }

  public float yaw() {
    return yawField.read();
  }

  public ServerboundMoveVehiclePacket pitch(float pitch) {
    pitchField.write(pitch);
    return this;
  }

  public float pitch() {
    return pitchField.read();
  }




}
