package me.mypvp.protocolwrapper.login;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Login.Client;
import com.comphenix.protocol.events.PacketContainer;
import io.netty.buffer.ByteBuf;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundCustomQueryPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.CUSTOM_PAYLOAD;

  private final PacketField<Integer> transactionIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<ByteBuf> dataField = new PacketField<>(
      container().getModifier().withType(ByteBuf.class), 0);

  public ServerboundCustomQueryPacket() {
  }

  public ServerboundCustomQueryPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundCustomQueryPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundCustomQueryPacket transactionId(int id) {
    transactionIdField.write(id);
    return this;
  }

  public int transactionId() {
    return transactionIdField.read();
  }

  public ServerboundCustomQueryPacket data(ByteBuf data) {
    dataField.write(data);
    return this;
  }

  public ByteBuf data() {
    return dataField.read();
  }

}
