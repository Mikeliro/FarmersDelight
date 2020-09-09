package vectorwing.farmersdelight.data;

import com.tterrag.registrate.Registrate;
import vectorwing.farmersdelight.FarmersDelight;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = FarmersDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
	public static final Registrate REGISTRATE = Registrate.create(FarmersDelight.MODID);

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new Recipes(generator));
			generator.addProvider(new Advancements(generator));
		}
		if (event.includeClient()) {
			//generator.addProvider(new Items(generator, event.getExistingFileHelper()));
		}
	}
}
