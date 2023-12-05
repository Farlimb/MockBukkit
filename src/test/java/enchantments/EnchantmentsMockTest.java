package enchantments;
import be.seeseemelk.mockbukkit.enchantments.EnchantmentMock;
import org.junit.jupiter.api.Test;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EnchantmentsMockTest
{
	@Test
	void testEnchantmentMockProperties() {
		// Arrange
		NamespacedKey key = new NamespacedKey("mockbukkittest", "asdasd");
		String name = "FeatherFalling";
		EnchantmentMock enchantmentMock = new EnchantmentMock(key, name);

		// Act
		enchantmentMock.setMaxLevel(5);
		enchantmentMock.setStartLevel(1);
		enchantmentMock.setItemTarget(EnchantmentTarget.WEAPON);
		enchantmentMock.setTreasure(true);
		enchantmentMock.setCursed(false);

		// Assert
		assertEquals(name, enchantmentMock.getName());
		assertEquals(5, enchantmentMock.getMaxLevel());
		assertEquals(1, enchantmentMock.getStartLevel());
		assertEquals(EnchantmentTarget.WEAPON, enchantmentMock.getItemTarget());
		assertTrue(enchantmentMock.isTreasure());
		assertFalse(enchantmentMock.isCursed());
	}

	@Test
	void testConflictsWith() {
		NamespacedKey key1 = new NamespacedKey("mockbukkittest", "enchantment1");
		NamespacedKey key2 = new NamespacedKey("mockbukkittest", "enchantment2");
		EnchantmentMock enchantment1 = new EnchantmentMock(key1, "Enchantment 1");
		EnchantmentMock enchantment2 = new EnchantmentMock(key2, "Enchantment 2");

		assertFalse(enchantment1.conflictsWith(enchantment2));
	}

	@Test
	void testCanEnchantStack() {
		EnchantmentMock enchantment = new EnchantmentMock(new NamespacedKey(
				"mockbukkittest", "enchantment"), "Sharpness");
		ItemStack itemStack = mock(ItemStack.class);
		assertFalse(enchantment.canEnchantItem(itemStack));
	}
}
