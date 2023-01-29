package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ClientboundPlayerInfoUpdatePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.PLAYER_INFO;

  private final PacketField<PlayerInfoAction> actionField
      = new PacketField<>(getContainer().getPlayerInfoAction(), 0);
  private final PacketField<List<PlayerInfoData>> dataField
      = new PacketField<>(getContainer().getPlayerInfoDataLists(), 0);

  public ClientboundPlayerInfoUpdatePacket() {}

  public ClientboundPlayerInfoUpdatePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundPlayerInfoUpdatePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setAction(PlayerInfoAction action) {
    actionField.write(action);
  }

  public PlayerInfoAction getAction() {
    return actionField.read();
  }

  public void setDataList(List<PlayerInfoData> list) {
    dataField.write(list);
  }

  public List<PlayerInfoData> readDataList() {
    return dataField.read();
  }

}
