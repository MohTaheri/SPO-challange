/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.soniq.taheri.spo.services.impl;

import challenge.soniq.taheri.spo.models.WorkforceInfoRequest;
import challenge.soniq.taheri.spo.services.OptimiseStaffs;
import challenge.soniq.taheri.spo.models.OptimalStaffsResponse;
import challenge.soniq.taheri.spo.utils.Utility;

import java.util.ArrayList;

public class GreedyOptimiseStaffsImpl implements OptimiseStaffs {

    @Override
    public OptimalStaffsResponse[] optimiseStaffs(WorkforceInfoRequest workforceInfo) {
        ArrayList<OptimalStaffsResponse> optimalStaffsResponseList = new ArrayList<>();

        for (int roomsCount : workforceInfo.getRooms()) {

            //Start point by just seniors And no juniors
            int seniorsCount = (int) Math.ceil((double) roomsCount / (double) workforceInfo.getSenior());
            int juniorsCount = 0;

            int minInterval = Utility.GCD(workforceInfo.getSenior(), workforceInfo.getJunior());
            int minStep = Math.min(workforceInfo.getSenior(), workforceInfo.getJunior());

            int[] result = optimiseStructureCapacity(roomsCount, minInterval, minStep,
                    workforceInfo.getSenior(), workforceInfo.getJunior(), seniorsCount,
                    seniorsCount, juniorsCount, juniorsCount);

            optimalStaffsResponseList.add(new OptimalStaffsResponse(result[0], result[1]));
        }

        return optimalStaffsResponseList.toArray(new OptimalStaffsResponse[optimalStaffsResponseList.size()]);
    }


    private int[] optimiseStructureCapacity(int roomsCount, int minInterval, int minStep,
                                            int seniorCapacity, int juniorCapacity,
                                            int priorSeniors, int currSeniors, int priorJuniors, int currJuniors) {

        int currentStaffCapacity = (seniorCapacity * currSeniors) + (juniorCapacity * currJuniors);
        int diff = Math.abs(currentStaffCapacity - roomsCount);

        if (diff <= minInterval && currentStaffCapacity >= roomsCount) {

            // check improve by decrease seniorsCount and increase juniorsCount
            if (currentStaffCapacity > roomsCount) {
                int currentStaffCapacityWithOnlySeniors = seniorCapacity * currSeniors;
                if (currSeniors > 1 && currentStaffCapacityWithOnlySeniors > roomsCount) {
                    return optimiseStructureCapacity(roomsCount, minInterval, minStep, seniorCapacity,
                            juniorCapacity, currSeniors, currSeniors - 1, currJuniors, currJuniors + 1);
                }
            }
            // otherwise we find optimal point
            return new int[]{currSeniors, currJuniors};
        }

        if (diff > minStep && currentStaffCapacity < roomsCount) {
            // backtrack and return previous step
            return new int[]{priorSeniors, priorJuniors};
        }

        // decrease seniorCount and test
        if (currentStaffCapacity > roomsCount && currSeniors > 1) {
            return optimiseStructureCapacity(roomsCount, minInterval, minStep, seniorCapacity,
                    juniorCapacity, currSeniors, currSeniors - 1, currJuniors, currJuniors);
        }

        // increase juniorCount and test
        if (currentStaffCapacity < roomsCount) {
            return optimiseStructureCapacity(roomsCount, minInterval, minStep, seniorCapacity,
                    juniorCapacity, currSeniors, currSeniors, currJuniors, currJuniors + 1);
        }

        return new int[]{currSeniors, currJuniors};
    }

}
