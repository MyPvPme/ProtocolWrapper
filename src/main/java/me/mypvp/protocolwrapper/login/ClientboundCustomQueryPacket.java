package me.mypvp.protocolwrapper.login;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Login.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.MinecraftKey;
import io.netty.buffer.ByteBuf;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundCustomQueryPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.CUSTOM_PAYLOAD;

  private final PacketField<MinecraftKey> channelField = new PacketField<>(container().getMinecraftKeys(), 0);
  private final PacketField<ByteBuf> dataField = new PacketField<>(
      container().getModifier().withType(ByteBuf.class), 0);

  public ClientboundCustomQueryPacket() {
  }

  public ClientboundCustomQueryPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundCustomQueryPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundCustomQueryPacket channel(MinecraftKey minecraftKey) {
    channelField.write(minecraftKey);
    return this;
  }

  public MinecraftKey channel() {
    return channelField.read();
  }

  public ClientboundCustomQueryPacket data(ByteBuf data) {
    dataField.write(data);
    return this;
  }

  public ByteBuf data() {
    return dataField.read();
  }

}
