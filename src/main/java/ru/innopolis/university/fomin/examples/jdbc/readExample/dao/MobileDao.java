package ru.innopolis.university.fomin.examples.jdbc.readExample.dao;

import ru.innopolis.university.fomin.examples.jdbc.readExample.pojo.Mobile;

public interface MobileDao {
    Long addMobile(Mobile mobile);
    Mobile getMobileById(Long id);
    boolean updateMobileById(Mobile mobile);
    boolean deleteMobileById(Long id);
}
