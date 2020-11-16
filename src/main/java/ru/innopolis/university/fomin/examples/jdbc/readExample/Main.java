package ru.innopolis.university.fomin.examples.jdbc.readExample;

import ru.innopolis.university.fomin.examples.jdbc.readExample.dao.MobileDao;
import ru.innopolis.university.fomin.examples.jdbc.readExample.dao.MobileDaoJdbcImpl;
import ru.innopolis.university.fomin.examples.jdbc.readExample.pojo.Mobile;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MobileDao mobileDao = new MobileDaoJdbcImpl();
        // Создаём новую запись в БД
        Mobile mobile = new Mobile(null, "Iphone 2", 25000, "Apple");
        Long id = mobileDao.addMobile(mobile);
        mobile = mobileDao.getMobileById(id);
        System.out.println(mobile);
        // Обновляем запись в БД
        mobile.setPrice(70000);
        mobileDao.updateMobileById(mobile);
        mobile = mobileDao.getMobileById(id);
        System.out.println(mobile);
        // Удаленные запись из БД
        mobileDao.deleteMobileById(id);
        mobile = mobileDao.getMobileById(id);
        System.out.println(mobile);
    }
}
