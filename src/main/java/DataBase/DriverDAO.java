package DataBase;

import DataBase.logic.Bus;
import DataBase.logic.Driver;
import DataBase.logic.Route;

import java.util.Collection;
import java.sql.SQLException;

public interface DriverDAO {
    public void addDriver(Driver driver) throws SQLException;
    public void updateDriver(Long driver_id, Driver driver) throws SQLException;
    public Driver getDriverById(Long driver_id) throws SQLException;
    public Collection getAllDrivers() throws SQLException;
    public void deleteDriver(Driver driver) throws SQLException;
    public Collection getDriversByBus(Bus bus) throws SQLException;
    public Collection getDriversByRoute(Route route) throws SQLException;
}
