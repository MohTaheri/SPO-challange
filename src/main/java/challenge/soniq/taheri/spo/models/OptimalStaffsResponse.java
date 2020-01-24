/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.soniq.taheri.spo.models;

public class OptimalStaffsResponse {

    private int senior;
    private int junior;

    public OptimalStaffsResponse() {
    }

    public OptimalStaffsResponse(int seniorStaff, int juniorStaff) {
        this.junior = juniorStaff;
        this.senior = seniorStaff;
    }

    public int getSenior() {
        return senior;
    }

    public int getJunior() {
        return junior;
    }


    @Override
    public int hashCode() {
        return this.senior + this.junior;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OptimalStaffsResponse other = (OptimalStaffsResponse) obj;
        if (this.senior != other.senior) {
            return false;
        }
        if (this.junior != other.junior) {
            return false;
        }
        return true;
    }
}
