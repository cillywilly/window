package DataBase.impl;

import DataBase.RouteDAO;
import DataBase.logic.Bus;
import DataBase.logic.Driver;
import DataBase.logic.Route;
import DataBase.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {
    @Override
    public void addRoute(Route route) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateBus(Long route_id, Route route) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Route getRouteById(Long route_id) throws SQLException {
        Session session = null;
        Route route = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            route = (Route) session.load(Route.class, route_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return route;
    }

    @Override
    public Collection getAllRoutes() throws SQLException {
        Session session = null;
        List routes = new ArrayList<Bus>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            routes = session.createCriteria(Route.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return routes;
    }

    @Override
    public void deleteRoute(Route route) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getRoutesByBus(Bus bus) throws SQLException {
        Session session = null;
        List routes = new ArrayList<Route>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Long bus_id = bus.getId();
            Query query = session.createQuery(
                    " select b "
                            + " from Routes b INNER JOIN b.busses busses"
                            + " where bus.id = :busId ")
                    .setLong("busId", bus_id);
            routes = (List<Driver>) query.list();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return routes;
    }

    @Override
    public Collection getRoutesByDriver(Driver driver) throws SQLException {
        Session session = null;
        List routes = new ArrayList<Route>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Long driver_id = driver.getId();
            Query query = session.createQuery("from Routes where driver_id = :driverId ").setLong("driverId", driver_id);
            routes = (List<Bus>) query.list();
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return routes;
    }
}
