package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.UUID;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import me.mypvp.protocolwrapper.types.BossBarBattle;
import me.mypvp.protocolwrapper.types.BossBarBattle.BarColor;
import me.mypvp.protocolwrapper.types.BossBarBattle.BarStyle;
import org.jetbrains.annotations.NotNull;

public class ClientboundBossEventPacket extends AbstractPacket {

  private static final Class<?> classAddBossBar = Server.BOSS.getPacketClass().getDeclaredClasses()[2];
  private static final Class<?> classUpdateProgressBar = Server.BOSS.getPacketClass().getDeclaredClasses()[3];
  private static final Class<?> classUpdateName = Server.BOSS.getPacketClass().getDeclaredClasses()[4];
  private static final Class<?> classUpdateStyle = Server.BOSS.getPacketClass().getDeclaredClasses()[5];
  private static final Class<?> classUpdateProperties = Server.BOSS.getPacketClass().getDeclaredClasses()[6];

  public static final PacketType TYPE = Server.BOSS;

  private final PacketField<UUID> uuidField = new PacketField<>(container().getUUIDs(), 0);
  private final PacketField<Object> actionField = new PacketField<>(container().getModifier(), 1);

  public ClientboundBossEventPacket() {
  }

  public ClientboundBossEventPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundBossEventPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundBossEventPacket uuid(UUID uuid) {
    uuidField.write(uuid);
    return this;
  }

  public UUID uuid() {
    return uuidField.read();
  }

  public ClientboundBossEventPacket action(Object action) {
    actionField.write(action);
    return this;
  }

  public Object action() {
    return actionField.read();
  }

  public static class AddBossBarPacket extends ClientboundBossEventPacket {

    public AddBossBarPacket(BossBarBattle bossBarBattle) {
      uuid(bossBarBattle.getUUID());
      try {
        Constructor<?> actionConstructor = classAddBossBar.getDeclaredConstructors()[0];
        actionConstructor.setAccessible(true);
        Object actionHandle = actionConstructor.newInstance(BossBarBattle.getConverter().getGeneric(bossBarBattle));
        action(actionHandle);
      } catch (ReflectiveOperationException exception) {
        throw new IllegalStateException("Failed to create bossbar packet", exception);
      }
    }

  }

  public static class RemoveBossBarPacket extends ClientboundBossEventPacket {

    public RemoveBossBarPacket(UUID uuid) {
      uuid(uuid);
      try {
        Field declaredField = Server.BOSS.getPacketClass().getDeclaredFields()[5];
        declaredField.setAccessible(true);
        Object actionRemove = declaredField.get(null);
        action(actionRemove);
      } catch (ReflectiveOperationException exception) {
        throw new IllegalStateException("Failed to create bossbar packet", exception);
      }
    }

  }

  public static class UpdateProgressBarPacket extends ClientboundBossEventPacket {

    public UpdateProgressBarPacket(UUID uuid, float progress) {
      uuid(uuid);
      try {
        Constructor<?> actionConstructor = classUpdateProgressBar.getDeclaredConstructors()[0];
        actionConstructor.setAccessible(true);
        Object actionHandle = actionConstructor.newInstance(progress);
        action(actionHandle);
      } catch (ReflectiveOperationException exception) {
        throw new IllegalStateException("Failed to create bossbar packet", exception);
      }
    }

  }

  public static class UpdateNamePacket extends ClientboundBossEventPacket {

    public UpdateNamePacket(UUID uuid, WrappedChatComponent wrappedChatComponent) {
      uuid(uuid);
      try {
        Constructor<?> actionConstructor = classUpdateName.getDeclaredConstructors()[0];
        actionConstructor.setAccessible(true);
        Object actionHandle = actionConstructor.newInstance(wrappedChatComponent.getHandle());
        action(actionHandle);
      } catch (ReflectiveOperationException exception) {
        throw new IllegalStateException("Failed to create bossbar packet", exception);
      }
    }

  }

  public static class UpdateStylePacket extends ClientboundBossEventPacket {

    public UpdateStylePacket(UUID uuid, BarColor barColor, BarStyle barStyle) {
      uuid(uuid);
      try {
        Constructor<?> actionConstructor = classUpdateStyle.getDeclaredConstructors()[0];
        actionConstructor.setAccessible(true);
        Object actionHandle = actionConstructor.newInstance(null, null);
        InternalStructure structure = InternalStructure.getConverter().getSpecific(actionHandle);
        structure.getEnumModifier(BarColor.class, 0).write(0, barColor);
        structure.getEnumModifier(BarStyle.class, 1).write(0, barStyle);
        action(structure.getHandle());
      } catch (ReflectiveOperationException exception) {
        throw new IllegalStateException("Failed to create bossbar packet", exception);
      }
    }

  }

  public static class UpdatePropertiesPacket extends ClientboundBossEventPacket {

    public UpdatePropertiesPacket(UUID uuid, boolean darkenScreen, boolean playMusic, boolean createWorldFog) {
      uuid(uuid);
      try {
        Constructor<?> actionConstructor = classUpdateProperties.getDeclaredConstructors()[0];
        actionConstructor.setAccessible(true);
        Object actionHandle = actionConstructor.newInstance(darkenScreen, playMusic, createWorldFog);
        action(actionHandle);
      } catch (ReflectiveOperationException exception) {
        throw new IllegalStateException("Failed to create bossbar packet", exception);
      }
    }

  }

}
