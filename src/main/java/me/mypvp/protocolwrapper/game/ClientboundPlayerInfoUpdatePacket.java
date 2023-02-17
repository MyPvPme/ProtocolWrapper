package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BukkitConverters;
import java.util.Collection;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import me.mypvp.protocolwrapper.types.PlayerInfoData;
import org.jetbrains.annotations.NotNull;

public class ClientboundPlayerInfoUpdatePacket extends AbstractPacket {

  public enum Action {
    ADD_PLAYER,
    UPDATE_GAME_MODE,
    UPDATE_LATENCY,
    UPDATE_DISPLAY_NAME,
    REMOVE_PLAYER
  }

  public static final PacketType TYPE = Server.PLAYER_INFO;

  private final PacketField<Action> actionField
      = new PacketField<>(container().getEnumModifier(Action.class, 0), 0);
  private final PacketField<List<PlayerInfoData>> dataField
      = new PacketField<>(container().getModifier()
      .withType(Collection.class, BukkitConverters.getListConverter(PlayerInfoData.getConverter())), 0);

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

  public ClientboundPlayerInfoUpdatePacket action(Action action) {
    actionField.write(action);
    return this;
  }

  public Action action() {
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
