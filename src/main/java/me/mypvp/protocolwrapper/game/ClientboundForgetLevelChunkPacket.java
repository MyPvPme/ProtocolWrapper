package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundForgetLevelChunkPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.UNLOAD_CHUNK;

  private final PacketField<Integer> xField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> zField = new PacketField<>(container().getIntegers(), 1);

  public ClientboundForgetLevelChunkPacket() {
  }

  public ClientboundForgetLevelChunkPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundForgetLevelChunkPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundForgetLevelChunkPacket x(int x) {
    xField.write(x);
    return this;
  }

  public int x() {
    return xField.read();
  }

  public ClientboundForgetLevelChunkPacket z(int z) {
    zField.write(z);
    return this;
  }

  public int z() {
    return zField.read();
  }

}
