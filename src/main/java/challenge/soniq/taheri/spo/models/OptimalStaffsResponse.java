/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.soniq.taheri.spo.models;

public class OptimalStaffsResponse {

    private final int senior;
    private final int junior;

    public OptimalStaffsResponse(int seniorStaff, int juniorStaff){
        this.junior = juniorStaff;
        this.senior = seniorStaff;
    }

    public int getSenior() {
        return senior;
    }

    public int getJunior() {
        return junior;
    }
}
