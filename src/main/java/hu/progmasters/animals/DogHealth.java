package hu.progmasters.animals;

import hu.progmasters.enums.HealthStatus;

public class DogHealth {

    private boolean vaccinated;
    private boolean dewormed;
    private HealthStatus healthStatus;

    public DogHealth(boolean vaccinated, boolean dewormed, HealthStatus healthStatus) {
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

    @Override
    public String toString() {
        return "DogHealth{" +
                "vaccinated=" + vaccinated +
                ", dewormed=" + dewormed +
                ", healthStatus=" + healthStatus +
                '}';
    }
}
