package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundBlockDestructionPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.BLOCK_BREAK_ANIMATION;

  private final PacketField<Integer> eidField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<BlockPosition> positionField
      = new PacketField<>(container().getBlockPositionModifier(), 0);
  private final PacketField<Integer> stageField = new PacketField<>(container().getIntegers(), 1);

  public ClientboundBlockDestructionPacket() {
  }

  public ClientboundBlockDestructionPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundBlockDestructionPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundBlockDestructionPacket entityId(int id) {
    eidField.write(id);
    return this;
  }

  public int entityId() {
    return eidField.read();
  }

  public ClientboundBlockDestructionPacket blockPosition(BlockPosition blockPosition) {
    positionField.write(blockPosition);
    return this;
  }

  public BlockPosition blockPosition() {
    return positionField.read();
  }

  public ClientboundBlockDestructionPacket stage(int stage) {
    stageField.write(stage);
    return this;
  }

  public int stage() {
    return stageField.read();
  }
}
