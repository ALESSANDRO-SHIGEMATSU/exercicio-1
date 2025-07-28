package ada.caixaverso.model;

import java.util.concurrent.atomic.AtomicLong;

public record Vehicle(String brand, Long id, String model, StatusVeihicle status, Long year, String engine ){
    private static final AtomicLong ATOMIC_LONG = new AtomicLong(1);

    public Vehicle(String brand, String model,Long year, String engine){
        this(brand, ATOMIC_LONG.getAndIncrement(),model,StatusVeihicle.AVAILABLE,year,engine);
    }
    public Vehicle withBrand(String brand){
        return new Vehicle(brand,this.id,this.model,this.status,this.year,this.engine );
    }
    public Vehicle withModel(String model){
        return new Vehicle(this.brand,this.id,model,this.status,this.year,this.engine );
    }
    public Vehicle withStatus(StatusVeihicle status){
        if (!this.status.nextStatus().contains(status)) {
            throw new IllegalArgumentException("Status Nao Permitido!");
        }
        return new Vehicle(this.brand,this.id,this.model,status,this.year,this.engine );
    }
    public Vehicle withYear(Long year){
        return new Vehicle(this.brand,this.id,this.model,this.status,year,this.engine );
    }
    public Vehicle witEngine(String engine){
        return new Vehicle(this.brand,this.id,this.model,this.status,this.year,engine );
    }

}