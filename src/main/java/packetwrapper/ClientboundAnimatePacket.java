package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundAnimatePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ANIMATION;

  public static final int SWING_MAIN_HAND = 0;
  public static final int HURT = 1;
  public static final int WAKE_UP = 2;
  public static final int SWING_OFF_HAND = 3;
  public static final int CRITICAL_HIT = 4;
  public static final int MAGIC_CRITICAL_HIT = 5;

  private final PacketField<Integer> idField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Integer> actionField = new PacketField<>(getContainer().getIntegers(), 1);

  public ClientboundAnimatePacket() {
  }

  public ClientboundAnimatePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundAnimatePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int id) {
    idField.write(id);
  }

  public int getEntityId() {
    return idField.read();
  }

  public void setAction(int action) {
    actionField.write(action);
  }

  public int getAction() {
    return actionField.read();
  }
}
