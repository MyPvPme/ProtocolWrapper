package me.mypvp.protocolwrapper.handshake;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Handshake.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientIntentionPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.SET_PROTOCOL;

  public enum ConnectionProtocol {
    HANDSHAKING,
    PLAY,
    STATUS,
    LOGIN
  }

  private final PacketField<Integer> protocolVersionField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<String> hostNameField = new PacketField<>(container().getStrings(), 0);
  private final PacketField<Integer> portField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<ConnectionProtocol> connectionProtocolField
      = new PacketField<>(container().getEnumModifier(ConnectionProtocol.class, 3), 0);

  public ClientIntentionPacket() {
  }

  public ClientIntentionPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientIntentionPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientIntentionPacket protocolVersion(int version) {
    protocolVersionField.write(version);
    return this;
  }

  public int protocolVersion() {
    return protocolVersionField.read();
  }

  public ClientIntentionPacket hostName(String hostName) {
    hostNameField.write(hostName);
    return this;
  }

  public String hostName() {
    return hostNameField.read();
  }

  public ClientIntentionPacket port(int port) {
    portField.write(port);
    return this;
  }

  public int port() {
    return portField.read();
  }

  public ClientIntentionPacket connectionProtocol(ConnectionProtocol connectionProtocol) {
    connectionProtocolField.write(connectionProtocol);
    return this;
  }

  public ConnectionProtocol connectionProtocol() {
    return connectionProtocolField.read();
  }

}
