package io.th0rgal.oraxen.mechanics.provided.repair;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;

import org.bukkit.configuration.ConfigurationSection;

public class RepairMechanicFactory extends MechanicFactory {

    private final boolean oraxenItemsOnly;

    public RepairMechanicFactory(ConfigurationSection section) {
        super(section);
        oraxenItemsOnly = section.getBoolean("oraxen_items_only");
        MechanicsManager.registerListeners(OraxenPlugin.get(), new RepairMechanicListener(this));
    }

    @Override
    public Mechanic parse(ConfigurationSection itemMechanicConfiguration) {
        Mechanic mechanic = new RepairMechanic(this, itemMechanicConfiguration);
        addToImplemented(mechanic);
        return mechanic;
    }

    public boolean isOraxenItemsOnly() {
        return oraxenItemsOnly;
    }
}