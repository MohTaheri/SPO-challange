package challenge.soniq.taheri.spo.services.impl;

import challenge.soniq.taheri.spo.services.OptimiseStaffs;
import challenge.soniq.taheri.spo.services.OptimiseStaffsFactory;

public class OptimiseStaffsFactoryImpl implements OptimiseStaffsFactory {
    @Override
    public OptimiseStaffs getOptimiser() {
        return new GreedyOptimiseStaffsImpl();
    }
}
