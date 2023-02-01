package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundContainerClosePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.CLOSE_WINDOW;

  private final PacketField<Integer> containerIdField = new PacketField<>(container().getIntegers(), 0);

  public ClientboundContainerClosePacket() {
  }

  public ClientboundContainerClosePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundContainerClosePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundContainerClosePacket containerId(int id) {
    containerIdField.write(id);
    return this;
  }

  public int containerId() {
    return containerIdField.read();
  }

}
