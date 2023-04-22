/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author yahir
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado create(Empleado p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();

        session.save(p);
        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se guardo Empleado");

        t.commit();
        session.close();
        return p;

    }

    @Override
    public boolean delete(Long  id) {
        boolean b;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Empleado empleado = findById(id);
        if (empleado != null){
            session.delete(empleado);
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se elimino Empleado");
            b=true;
        }else{
            b=false;
        }
        
        t.commit();
        session.close();
        return b;
    }

    @Override
    public Empleado update(Empleado p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Empleado empleado = findById(id);
        if (empleado != null){
            session.update(empleado);
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se actualizo Empleado");
        }

        t.commit();
        session.close();
        return empleado;

    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> listaempleados=null;
        
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        listaempleados = session.createQuery("FROM ejemplo").list();
        t.commit();
        session.close();
        return listaempleados;
    }

    @Override
    public Empleado findById(Long id) {
        Empleado empleado=null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        empleado = session.get(Empleado.class, id);
        
        t.commit();
        session.close();
        return empleado;
    }

}
