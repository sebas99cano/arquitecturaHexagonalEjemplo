module hr.dstr89.hexagonal.infrastructure {
    requires java.sql;
    requires lombok;
    requires example.org.hexagonal.application;
    requires example.org.hexagonal.domain;

    exports example.org.hexagonal.infrastructure;
}