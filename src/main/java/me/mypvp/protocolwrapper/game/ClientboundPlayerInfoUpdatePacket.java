package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundPlayerInfoUpdatePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.PLAYER_INFO;

  private final PacketField<PlayerInfoAction> actionField
      = new PacketField<>(container().getPlayerInfoAction(), 0);
  private final PacketField<List<PlayerInfoData>> dataField
      = new PacketField<>(container().getPlayerInfoDataLists(), 0);

  public ClientboundPlayerInfoUpdatePacket() {}

  public ClientboundPlayerInfoUpdatePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundPlayerInfoUpdatePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundPlayerInfoUpdatePacket action(PlayerInfoAction action) {
    actionField.write(action);
    return this;
  }

  public PlayerInfoAction action() {
    return actionField.read();
  }

  public ClientboundPlayerInfoUpdatePacket dataList(List<PlayerInfoData> list) {
    dataField.write(list);
    return this;
  }

  public List<PlayerInfoData> dataList() {
    return dataField.read();
  }

}
