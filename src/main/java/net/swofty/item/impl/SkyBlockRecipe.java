package net.swofty.item.impl;

import lombok.Getter;
import lombok.Setter;
import net.minestom.server.item.ItemStack;
import net.minestom.server.recipe.Recipe;
import net.swofty.item.ItemType;
import net.swofty.item.MaterialQuantifiable;
import net.swofty.item.SkyBlockItem;
import net.swofty.item.impl.recipes.ShapelessRecipe;
import net.swofty.user.SkyBlockPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Getter
public abstract class SkyBlockRecipe<T> {
    protected SkyBlockItem result;
    @Setter
    protected Function<SkyBlockPlayer, Boolean> canCraft;

    protected SkyBlockRecipe(SkyBlockItem result) {
        this.result = result;
    }

    public abstract T setResult(SkyBlockItem result);

    public abstract void init();

    public static SkyBlockRecipe<?> parseRecipe(ItemStack[] stacks) {
        return ShapelessRecipe.parseShapelessRecipe(stacks);
    }
}
