package net.swofty.types.generic.item.items.vanilla;

import net.swofty.types.generic.item.ItemType;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.Craftable;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.SkyBlockRecipe;
import net.swofty.types.generic.item.impl.recipes.ShapelessRecipe;
import net.swofty.types.generic.user.statistics.ItemStatistics;

public class Stick implements CustomSkyBlockItem, Craftable {
    @Override
    public SkyBlockRecipe<?> getRecipe() {
        return new ShapelessRecipe(SkyBlockRecipe.RecipeType.NONE, new SkyBlockItem(ItemType.STICK), 4)
                .add(ItemType.OAK_PLANKS, 2);
    }

    @Override
    public ItemStatistics getStatistics() {
        return ItemStatistics.EMPTY;
    }
}
