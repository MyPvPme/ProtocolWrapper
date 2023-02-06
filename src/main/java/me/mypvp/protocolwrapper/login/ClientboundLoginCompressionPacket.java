package me.mypvp.protocolwrapper.login;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Login.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundLoginCompressionPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_COMPRESSION;

  private final PacketField<Integer> compressionThresholdField = new PacketField<>(container().getIntegers(), 0);

  public ClientboundLoginCompressionPacket() {
  }

  public ClientboundLoginCompressionPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundLoginCompressionPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundLoginCompressionPacket compressionThreshold(int compressionThreshold) {
    compressionThresholdField.write(compressionThreshold);
    return this;
  }

  public int compressionThreshold() {
    return compressionThresholdField.read();
  }

}
