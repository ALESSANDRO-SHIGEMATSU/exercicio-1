package ada.caixaverso.repository;

import ada.caixaverso.model.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleRepository implements RepositoryInterface<Long,Vehicle> {
    private final Map<Long, Vehicle> store = new ConcurrentHashMap<>();

    @Override
    public Vehicle create(Vehicle vehicle){
        store.put(vehicle.id(), vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(Long id){
        return store.get(id);
    }

    @Override
    public Map<Long,Vehicle> findAll(){
        return store;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public void update( Vehicle vehicle){
        store.remove( vehicle.id());
        store.put(vehicle.id(), vehicle);

    }
}
