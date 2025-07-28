package ada.caixaverso.dto;

import ada.caixaverso.model.StatusVeihicle;
import ada.caixaverso.model.Vehicle;

import java.util.Optional;

public record VehicleResponseBody(String brand, String model, Long id,StatusVeihicle status, Long year, String engine, String carTitle ) {
    public static VehicleResponseBody from( Vehicle vehicle) {
        return new VehicleResponseBody(
                vehicle.brand(),
                vehicle.model(),
                vehicle.id(),
                vehicle.status(),
                vehicle.year(),
                vehicle.engine(),
                String.join(" ", vehicle.brand(), vehicle.model(), vehicle.engine())
         );
    }
}
