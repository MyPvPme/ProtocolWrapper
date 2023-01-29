package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundBlockUpdatePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.BLOCK_CHANGE;

  private final PacketField<BlockPosition> blockPositionField
      = new PacketField<>(getContainer().getBlockPositionModifier(), 0);
  private final PacketField<WrappedBlockData> stateField
      = new PacketField<>(getContainer().getBlockData(), 0);

  public ClientboundBlockUpdatePacket() {
  }

  public ClientboundBlockUpdatePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundBlockUpdatePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public ClientboundBlockUpdatePacket blockPosition(BlockPosition blockPosition) {
    blockPositionField.write(blockPosition);
    return this;
  }

  public BlockPosition blockPosition() {
    return blockPositionField.read();
  }

  public ClientboundBlockUpdatePacket blockData(WrappedBlockData blockData) {
    stateField.write(blockData);
    return this;
  }

  public WrappedBlockData blockData() {
    return stateField.read();
  }

}
