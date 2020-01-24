package challenge.soniq.taheri.spo.models;

import challenge.soniq.taheri.spo.controllers.validator.Workforce;

import javax.validation.constraints.Min;

public class WorkforceInfoRequest {



    @Workforce
    private Integer[] rooms = new Integer[0];

    @Min(value = 1, message = "Senior capability must be greater than or equal to 1")
    private int senior = 0;

    @Min(value = 1, message = "Junior capability must be greater than or equal to 1")
    private int junior = 0;


    public WorkforceInfoRequest() {
    }

    public WorkforceInfoRequest(Integer[] rooms, int senior, int junior) {
        this.rooms = rooms;
        this.senior = senior;
        this.junior = junior;
    }

    public Integer[] getRooms() {
        return rooms;
    }

    public void setRooms(Integer[] rooms) {
        this.rooms = rooms;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }
}
