package me.mypvp.protocolwrapper.login;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Login.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundHelloPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENCRYPTION_BEGIN;

  private final PacketField<String> serverIdField = new PacketField<>(container().getStrings(), 0);
  private final PacketField<byte[]> publicKeyField = new PacketField<>(container().getByteArrays(), 0);
  private final PacketField<byte[]> nonceField = new PacketField<>(container().getByteArrays(), 1);

  public ClientboundHelloPacket() {
  }

  public ClientboundHelloPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundHelloPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundHelloPacket serverId(String serverId) {
    serverIdField.write(serverId);
    return this;
  }

  public String serverId() {
    return serverIdField.read();
  }

  public ClientboundHelloPacket publicKey(byte[] publicKey) {
    publicKeyField.write(publicKey);
    return this;
  }

  public byte[] publicKey() {
    return publicKeyField.read();
  }

  public ClientboundHelloPacket nonce(byte[] nonce) {
    nonceField.write(nonce);
    return this;
  }

  public byte[] nonce() {
    return nonceField.read();
  }

}
