package DataBase;

import DataBase.logic.Bus;
import DataBase.logic.Driver;
import DataBase.logic.Route;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws SQLException {

        Collection routes = Factory.getInstance().getRouteDAO().getAllRoutes();
        Iterator iterator = routes.iterator();
        System.out.println("========Все маршруты=========");
        while (iterator.hasNext()) {
            Route route = (Route) iterator.next();
            System.out.println("Маршрут : " + route.getName() + "  Номер маршрута : " + route.getNumber());
            Collection busses = Factory.getInstance().getBusDAO().getBussesByRoute(route);
            Iterator iterator2 = busses.iterator();
            while (iterator2.hasNext()) {
                Bus bus = (Bus) iterator2.next();
                System.out.println("Автобус № " + bus.getNumber());

            }
        }

        Collection busses = Factory.getInstance().getBusDAO().getAllBusses();
        iterator = busses.iterator();
        System.out.println("========Все автобусы=========");
        while (iterator.hasNext()) {
            Bus bus = (Bus) iterator.next();
            Collection drivers = Factory.getInstance().getDriverDAO().getDriversByBus(bus);
            Iterator iterator2 = drivers.iterator();
            System.out.println("Автобус № " + bus.getNumber());
            while (iterator2.hasNext()) {
                Driver driver = (Driver) iterator2.next();
                System.out.println("Имя : " + driver.getName() + "   Фамилия: " + driver.getSurname());

            }
        }
    }
}
