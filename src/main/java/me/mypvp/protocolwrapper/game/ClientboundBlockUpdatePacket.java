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

  public void setBlockPosition(BlockPosition blockPosition) {
    blockPositionField.write(blockPosition);
  }

  public BlockPosition getBlockPosition() {
    return blockPositionField.read();
  }

  public void setBlockData(WrappedBlockData blockData) {
    stateField.write(blockData);
  }

  public WrappedBlockData getBlockData() {
    return stateField.read();
  }

}
