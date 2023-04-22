/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa05;

import org.hibernate.Session;
/**
 *
 * @author yahir
 */
public class Programa05 {

    public static void main(String[] args) {
//        Session session = HibernateUtil.getSession();
        DAOEmpleado dao = new DAOEmpleado();
        Empleado empleado = new Empleado();
        empleado.setClave(13);
        empleado.setNombre("Angel");
        empleado.setDireccion("Ave.16");
        empleado.setTelefono("55555");
        
        dao.create(empleado);
        



        long a = 12;
        dao.delete(a);
    }
}
