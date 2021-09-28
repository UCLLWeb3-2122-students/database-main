package domain.service;

public class DbException extends RuntimeException {
    public DbException(String s) {
        super(s);
    }
}
