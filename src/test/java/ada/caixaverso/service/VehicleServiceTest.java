package ada.caixaverso.service;

import ada.caixaverso.repository.VehicleDAO;
import org.junit.jupiter.api.Test;

class VehicleServiceTest {


    @Test
    void create() {
        VehicleService services = new VehicleService(new VehicleDAO());
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }
}