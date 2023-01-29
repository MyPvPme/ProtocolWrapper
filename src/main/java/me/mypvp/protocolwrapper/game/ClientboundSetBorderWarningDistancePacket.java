package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderWarningDistancePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_WARNING_DISTANCE;

  private final PacketField<Integer> warningBlocksField = new PacketField<>(container().getIntegers(), 0);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetBorderWarningDistancePacket warningBlocks(int blocks) {
    warningBlocksField.write(blocks);
    return this;
  }

  public int warningBlocks() {
    return warningBlocksField.read();
  }

}
