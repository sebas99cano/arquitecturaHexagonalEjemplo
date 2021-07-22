module example.org.hexagonal.application {
    requires example.org.hexagonal.domain;
    requires org.junit.platform.commons;

    exports example.org.hexagonal.application;
}