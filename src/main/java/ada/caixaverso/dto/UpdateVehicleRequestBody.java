package ada.caixaverso.dto;
import ada.caixaverso.model.StatusVeihicle;

public record UpdateVehicleRequestBody(String brand, String model, StatusVeihicle status, Long year, String engine) {
}