public class ParkingSystem {

    private int[] slot;
    public ParkingSystem(int big, int medium, int small) {
        slot = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (slot[carType - 1] > 0) {
            slot[carType - 1]--;
            return true;
        }
        return false;
    }
}
