package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedLevelChunkData.ChunkData;
import com.comphenix.protocol.wrappers.WrappedLevelChunkData.LightData;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundLevelChunkWithLightPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.MAP_CHUNK;

  private final PacketField<Integer> xField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> zField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<ChunkData> chunkDataField = new PacketField<>(container().getLevelChunkData(), 0);
  private final PacketField<LightData> lightDataField = new PacketField<>(container().getLightUpdateData(), 0);

  public ClientboundLevelChunkWithLightPacket() {
  }

  public ClientboundLevelChunkWithLightPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundLevelChunkWithLightPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundLevelChunkWithLightPacket x(int x) {
    xField.write(x);
    return this;
  }

  public int x() {
    return xField.read();
  }

  public ClientboundLevelChunkWithLightPacket z(int z) {
    zField.write(z);
    return this;
  }

  public int z() {
    return zField.read();
  }

  public ClientboundLevelChunkWithLightPacket chunkData(ChunkData chunkData) {
    chunkDataField.write(chunkData);
    return this;
  }

  public ChunkData chunkData() {
    return chunkDataField.read();
  }

  public ClientboundLevelChunkWithLightPacket lightData(LightData lightData) {
    lightDataField.write(lightData);
    return this;
  }

  public LightData lightData() {
    return lightDataField.read();
  }

}
