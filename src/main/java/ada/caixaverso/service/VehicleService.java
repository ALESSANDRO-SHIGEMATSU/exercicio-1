package ada.caixaverso.service;

import ada.caixaverso.dto.UpdateVehicleRequestBody;
import ada.caixaverso.dto.VehicleRequestBody;
import ada.caixaverso.dto.VehicleResponseBody;
import ada.caixaverso.model.Vehicle;
import ada.caixaverso.repository.VehicleDAO;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleService implements ServiceInterface<VehicleRequestBody, VehicleResponseBody,UpdateVehicleRequestBody>{

    private final VehicleDAO vehicleDAO;

    public VehicleService( VehicleDAO vehicleDAO){
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public VehicleResponseBody create(VehicleRequestBody vehicleRequestBody){
        Vehicle vehicle = VehicleRequestBody.toVehicle(vehicleRequestBody);
        vehicleDAO.create(vehicle);
        return VehicleResponseBody.from(vehicle);
    }

    @Override
    public VehicleResponseBody findById(Long id){
        Vehicle vehicle = vehicleDAO.findById(id);

        if (vehicle == null) {
            throw new NotFoundException("Veículo com ID " + id + " não encontrado");
        }

        return VehicleResponseBody.from(vehicle);
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = vehicleDAO.findById(id);

        if (vehicle == null) {
            throw new NotFoundException("Veículo com ID " + id + " não encontrado");
        }

        if (!vehicle.status().isDeletePossible()) {
            throw new IllegalArgumentException("Veiculo com status" + vehicle.status() + " nao pode ser deletado");
        }
        vehicleDAO.deleteById(id);
    }

    @Override
    public List<VehicleResponseBody> findAll() {
        Map<Long,Vehicle> vehicles = vehicleDAO.findAll();

        List<VehicleResponseBody> list = new ArrayList<>();
        for (Vehicle vehicle : vehicles.values()) {
            list.add(VehicleResponseBody.from(vehicle));
        }
        return list;

    }

    @Override
    public void update(Long id, UpdateVehicleRequestBody body){
        Vehicle vehicle = vehicleDAO.findById(id);

        if (vehicle == null) {
            throw new NotFoundException("Veículo com ID " + id + " não encontrado");
        }

        if (body.brand() != null) {
            vehicle = vehicle.withBrand(body.brand());
        }
        if (body.model() != null) {
            vehicle = vehicle.withModel(body.model());
        }
        if (body.status() != null) {
            vehicle = vehicle.withStatus(body.status());
        }
        if (body.year() != null) {
            vehicle = vehicle.withYear(body.year());
        }
        if (body.engine() != null) {
            vehicle = vehicle.witEngine(body.engine());
        }

        vehicleDAO.update(vehicle); // ou put(updated.id(), updated);
    }
}
