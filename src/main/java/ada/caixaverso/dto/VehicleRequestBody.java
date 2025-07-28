package ada.caixaverso.dto;

import ada.caixaverso.model.Vehicle;

public record VehicleRequestBody(String brand, String model, Long year, String engine) {
    public static Vehicle toVehicle(VehicleRequestBody body) {
        return new Vehicle(
                body.brand(),
                body.model(),
                body.year(),
                body.engine()
        );
    }
}
