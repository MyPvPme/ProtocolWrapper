package me.mypvp.protocolwrapper.login;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Login.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundGameProfilePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SUCCESS;

  private final PacketField<WrappedGameProfile> gameProfileField
      = new PacketField<>(container().getGameProfiles(), 0);

  public ClientboundGameProfilePacket() {
  }

  public ClientboundGameProfilePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundGameProfilePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundGameProfilePacket gameProfile(WrappedGameProfile gameProfile) {
    gameProfileField.write(gameProfile);
    return this;
  }

  public WrappedGameProfile gameProfile() {
    return gameProfileField.read();
  }

}
