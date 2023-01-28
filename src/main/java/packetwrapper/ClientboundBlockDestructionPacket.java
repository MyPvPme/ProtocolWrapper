package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import org.jetbrains.annotations.NotNull;

public class ClientboundBlockDestructionPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.BLOCK_BREAK_ANIMATION;

  private final PacketField<Integer> eidField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<BlockPosition> positionField
      = new PacketField<>(getContainer().getBlockPositionModifier(), 0);
  private final PacketField<Integer> stageField = new PacketField<>(getContainer().getIntegers(), 1);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int id) {
    eidField.write(id);
  }

  public int getEntityId() {
    return eidField.read();
  }

  public void setBlockPosition(BlockPosition blockPosition) {
    positionField.write(blockPosition);
  }

  public BlockPosition getBlockPosition() {
    return positionField.read();
  }

  public void setStage(int stage) {
    stageField.write(stage);
  }

  public int getStage() {
    return stageField.read();
  }
}
