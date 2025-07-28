package ada.caixaverso.model;

import java.util.Set;

public enum StatusVeihicle {
    AVAILABLE{
        @Override
        public Set<StatusVeihicle> nextStatus(){
            return Set.of(StatusVeihicle.RENTED,StatusVeihicle.UNDER_MAINTENANCE);
        }

        @Override
        public Boolean isDeletePossible() {
            return true;
        }
    },
    RENTED{
        @Override
        public Set<StatusVeihicle> nextStatus(){
            return Set.of(StatusVeihicle.AVAILABLE, StatusVeihicle.UNDER_MAINTENANCE);
        }

        @Override
        public Boolean isDeletePossible() {
            return false;
        }
    },
    UNDER_MAINTENANCE{
        @Override
        public Set<StatusVeihicle> nextStatus(){
            return Set.of(StatusVeihicle.AVAILABLE, StatusVeihicle.UNDER_MAINTENANCE);
        }

        @Override
        public Boolean isDeletePossible() {
            return true ;
        }
    };

    public abstract Set<StatusVeihicle> nextStatus();
    public abstract Boolean isDeletePossible();
}
