package hu.progmasters.animals;

import hu.progmasters.enums.HealthStatus;

public class DogHealth {
    private int dogHealthId;
    private boolean vaccinated;
    private boolean dewormed;
    private HealthStatus healthStatus;

    public DogHealth(boolean vaccinated, boolean dewormed, HealthStatus healthStatus) {
        this.vaccinated = vaccinated;
        this.dewormed = dewormed;
        this.healthStatus = healthStatus;
    }

    public DogHealth(int dogHealthId, boolean vaccinated, boolean dewormed, HealthStatus healthStatus) {
        this.dogHealthId = dogHealthId;
        this.vaccinated = vaccinated;
        this.dewormed = dewormed;
        this.healthStatus = healthStatus;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isDewormed() {
        return dewormed;
    }

    public void setDewormed(boolean dewormed) {
        this.dewormed = dewormed;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getDogHealthId() {
        return dogHealthId;
    }

    public void setDogHealthId(int dogHealthId) {
        this.dogHealthId = dogHealthId;
    }

    @Override
    public String toString() {
        return "DogHealth{" +
                "dogHealthId=" + dogHealthId +
                ", vaccinated=" + vaccinated +
                ", dewormed=" + dewormed +
                ", healthStatus=" + healthStatus +
                '}';
    }
}
