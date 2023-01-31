package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedParticle;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundLevelParticlesPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.WORLD_PARTICLES;

  private final PacketField<Double> xField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(container().getDoubles(), 2);
  private final PacketField<Float> offXField = new PacketField<>(container().getFloat(), 0);
  private final PacketField<Float> offYField = new PacketField<>(container().getFloat(), 1);
  private final PacketField<Float> offZField = new PacketField<>(container().getFloat(), 2);
  private final PacketField<Float> speedField = new PacketField<>(container().getFloat(), 3);
  private final PacketField<Integer> countField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Boolean> longDistanceField = new PacketField<>(container().getBooleans(), 0);
  private final PacketField<WrappedParticle> particleParamField = new PacketField<>(
      container().getNewParticles(), 0);

  public ClientboundLevelParticlesPacket() {
  }

  public ClientboundLevelParticlesPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundLevelParticlesPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundLevelParticlesPacket x(double value) {
    xField.write(value);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ClientboundLevelParticlesPacket y(double value) {
    yField.write(value);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ClientboundLevelParticlesPacket z(double value) {
    zField.write(value);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ClientboundLevelParticlesPacket offsetX(float value) {
    offXField.write(value);
    return this;
  }

  public float offsetX() {
    return offXField.read();
  }

  public ClientboundLevelParticlesPacket offsetY(float value) {
    offYField.write(value);
    return this;
  }

  public float offsetY() {
    return offYField.read();
  }

  public ClientboundLevelParticlesPacket offsetZ(float value) {
    offZField.write(value);
    return this;
  }

  public float offsetZ() {
    return offZField.read();
  }

  public ClientboundLevelParticlesPacket speed(float value) {
    speedField.write(value);
    return this;
  }

  public float speed() {
    return speedField.read();
  }

  public ClientboundLevelParticlesPacket count(int value) {
    countField.write(value);
    return this;
  }

  public int count() {
    return countField.read();
  }

  public ClientboundLevelParticlesPacket longDistance(boolean value) {
    longDistanceField.write(value);
    return this;
  }

  public boolean longDistance() {
    return longDistanceField.read();
  }

  public ClientboundLevelParticlesPacket particle(WrappedParticle<?> particle) {
    particleParamField.write(particle);
    return this;
  }

  public WrappedParticle<?> particle() {
    return particleParamField.read();
  }

}
