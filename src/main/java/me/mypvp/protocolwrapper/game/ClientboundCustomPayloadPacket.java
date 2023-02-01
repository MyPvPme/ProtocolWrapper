package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.MinecraftKey;
import io.netty.buffer.ByteBuf;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundCustomPayloadPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.CUSTOM_PAYLOAD;

  private final PacketField<MinecraftKey> channelField
      = new PacketField<>(container().getMinecraftKeys(), 0);
  private final PacketField<ByteBuf> dataField
      = new PacketField<>(container().getModifier().withType(ByteBuf.class), 0);

  public ClientboundCustomPayloadPacket() {
  }

  public ClientboundCustomPayloadPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundCustomPayloadPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundCustomPayloadPacket channel(MinecraftKey minecraftKey) {
    channelField.write(minecraftKey);
    return this;
  }

  public MinecraftKey channel() {
    return channelField.read();
  }

  public ClientboundCustomPayloadPacket data(ByteBuf data) {
    dataField.write(data);
    return this;
  }

  public ByteBuf data() {
    return dataField.read();
  }

}
