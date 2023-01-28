package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderWarningDistancePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_WARNING_DISTANCE;

  private final PacketField<Integer> warningBlocksField = new PacketField<>(getContainer().getIntegers(), 0);

  public ClientboundSetBorderWarningDistancePacket() {
  }

  public ClientboundSetBorderWarningDistancePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetBorderWarningDistancePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setWarningBlocks(int blocks) {
    warningBlocksField.write(blocks);
  }

  public int getWarningBlocks() {
    return warningBlocksField.read();
  }

}
