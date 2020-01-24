package challenge.soniq.taheri.spo.services;

import challenge.soniq.taheri.spo.models.*;


public interface OptimiseStaffs {
    OptimalStaffsResponse[] optimiseStaffs(WorkforceInfoRequest workforceInfo);
}
