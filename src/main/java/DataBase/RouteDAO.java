package DataBase;

import DataBase.logic.Bus;
import DataBase.logic.Driver;
import DataBase.logic.Route;

import java.sql.SQLException;
import java.util.Collection;

public interface RouteDAO {
    public void addRoute(Route route) throws SQLException;
    public void updateBus(Long route_id, Route route) throws SQLException;
    public Route getRouteById(Long route_id) throws SQLException;
    public Collection getAllRoutes() throws SQLException;
    public void deleteRoute(Route route) throws SQLException;
    public Collection getRoutesByBus(Bus bus) throws SQLException;
    public Collection getRoutesByDriver(Driver driver) throws SQLException;
}
