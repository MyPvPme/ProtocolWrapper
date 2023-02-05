package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundInitializeBorderPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.INITIALIZE_BORDER;

  private final PacketField<Double> newCenterXField = new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> newCenterZField = new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Double> oldSizeField = new PacketField<>(container().getDoubles(), 3);
  private final PacketField<Double> newSizeField = new PacketField<>(container().getDoubles(), 4);
  private final PacketField<Long> lerpTimeField = new PacketField<>(container().getLongs(), 0);
  private final PacketField<Integer> newAbsoluteMaxSizeField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> warningBlocksField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<Integer> warningTimeField = new PacketField<>(container().getIntegers(), 2);

  public ClientboundInitializeBorderPacket() {
  }

  public ClientboundInitializeBorderPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundInitializeBorderPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundInitializeBorderPacket x(double value) {
    newCenterXField.write(value);
    return this;
  }

  public double x() {
    return newCenterXField.read();
  }

  public ClientboundInitializeBorderPacket z(double value) {
    newCenterZField.write(value);
    return this;
  }

  public double z() {
    return newCenterZField.read();
  }

  public ClientboundInitializeBorderPacket oldSize(double size) {
    oldSizeField.write(size);
    return this;
  }

  public double oldSize() {
    return oldSizeField.read();
  }

  public ClientboundInitializeBorderPacket newSize(double size) {
    newSizeField.write(size);
    return this;
  }

  public double newSize() {
    return newSizeField.read();
  }

  public ClientboundInitializeBorderPacket lerpTime(long time) {
    lerpTimeField.write(time);
    return this;
  }

  public long lerpTime() {
    return lerpTimeField.read();
  }

  public ClientboundInitializeBorderPacket absoluteMaxSize(int size) {
    newAbsoluteMaxSizeField.write(size);
    return this;
  }

  public int absoluteMaxSize() {
    return newAbsoluteMaxSizeField.read();
  }

  public ClientboundInitializeBorderPacket warningBlocks(int blocks) {
    warningBlocksField.write(blocks);
    return this;
  }

  public int warningBlocks() {
    return warningBlocksField.read();
  }

  public ClientboundInitializeBorderPacket warningTime(int time) {
    warningTimeField.write(time);
    return this;
  }

  public int warningTime() {
    return warningTimeField.read();
  }

}
