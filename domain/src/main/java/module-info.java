module example.org.hexagonal.domain {
    requires lombok;
    requires org.junit.jupiter.api;
    requires org.mockito;
    requires org.mockito.junit.jupiter;

    exports example.org.hexagonal.domain.data;
    exports example.org.hexagonal.domain.repo;
    exports example.org.hexagonal.domain.services;
}