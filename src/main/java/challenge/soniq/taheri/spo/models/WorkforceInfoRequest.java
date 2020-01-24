package challenge.soniq.taheri.spo.models;

import challenge.soniq.taheri.spo.controllers.validator.Workforce;

import javax.validation.constraints.Min;

public class WorkforceInfoRequest {

    @Workforce
    private Integer[] rooms = new Integer[0];

    @Min(value = 1, message = "Senior capability must be greater than or equal to 1")
    private Integer senior = 0;

    @Min(value = 1, message = "Junior capability must be greater than or equal to 1")
    private Integer junior = 0;

    public WorkforceInfoRequest() {
    }

    public WorkforceInfoRequest(Integer[] rooms, Integer senior, Integer junior) {
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

    public Integer getSenior() {
        return senior;
    }

    public void setSenior(Integer senior) {
        this.senior = senior;
    }

    public Integer getJunior() {
        return junior;
    }

    public void setJunior(Integer junior) {
        this.junior = junior;
    }
}
